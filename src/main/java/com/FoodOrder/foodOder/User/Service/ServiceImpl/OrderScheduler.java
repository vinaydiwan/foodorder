package com.FoodOrder.foodOder.User.Service.ServiceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.FoodOrder.foodOder.User.DTOs.OrderStatus;
import com.FoodOrder.foodOder.User.Model.OrderJob;
import com.FoodOrder.foodOder.User.Repository.OrderJobRepository;
import com.FoodOrder.foodOder.User.Repository.OrdersRepository;

@Component
public class OrderScheduler {
	private static final Logger logger = LoggerFactory.getLogger(OrderScheduler.class);

	private OrdersRepository ordersRepo;
	private OrderJobRepository orderJobRepo;
	private Random random = new Random();

	public OrderScheduler(OrdersRepository ordersRepo, OrderJobRepository orderJobRepo) {
		super();
		this.ordersRepo = ordersRepo;
		this.orderJobRepo = orderJobRepo;
	}

	@Scheduled(fixedRate = 30000)
	public void moveToInPreparation() {
		List<OrderJob> orderJobs = orderJobRepo.findByStatus(OrderStatus.OrderReceived.toString());
		for(OrderJob orderJob: orderJobs) {
			logger.debug("checking for order: {}", orderJob);
			if(isTimeElapsed(orderJob.getScheduleTime(), orderJob.getUpdatedTime())) {
				logger.debug("updating order: {}", orderJob);
				ordersRepo.updateStatusByOrderId(orderJob.getOrderId(), OrderStatus.InPreparation.toString());
				
				orderJob.setUpdatedTime(LocalDateTime.now());
				orderJob.setStatus(OrderStatus.InPreparation.toString());
				orderJob.setScheduleTime(random.nextInt(10) + 3);
				orderJobRepo.save(orderJob);
				logger.debug("moveToInPreparation: updated order: {}", orderJob);
			}
		}
	}
	

	@Scheduled(fixedRate = 30000)
	public void moveToOutForDelivery() {
		List<OrderJob> orderJobs = orderJobRepo.findByStatus(OrderStatus.InPreparation.toString());
		for(OrderJob orderJob: orderJobs) {
			logger.debug("checking for order: {}", orderJob);
			if(isTimeElapsed(orderJob.getScheduleTime(), orderJob.getUpdatedTime())) {
				logger.debug("updating order: {}", orderJob);
				ordersRepo.updateStatusByOrderId(orderJob.getOrderId(), OrderStatus.OutForDelivery.toString());
				
				orderJob.setUpdatedTime(LocalDateTime.now());
				orderJob.setStatus(OrderStatus.OutForDelivery.toString());
				orderJob.setScheduleTime(random.nextInt(5) + 3);
				orderJobRepo.save(orderJob);
				logger.debug("moveToOutForDelivery: updated order: {}", orderJob);
			}
		}
	}

	@Scheduled(fixedRate = 30000)
	public void moveToDelivered() {
		List<OrderJob> orderJobs = orderJobRepo.findByStatus(OrderStatus.OutForDelivery.toString());
		for(OrderJob orderJob: orderJobs) {
			logger.debug("checking for order: {}", orderJob);
			if(isTimeElapsed(orderJob.getScheduleTime(), orderJob.getUpdatedTime())) {
				logger.debug("updating order: {}", orderJob);
				ordersRepo.updateStatusByOrderId(orderJob.getOrderId(), OrderStatus.Delivered.toString());
				
				orderJobRepo.deleteById(orderJob.getOrderId());
				logger.debug("moveToDelivered: order delivered");
			}
		}
	}	

	private boolean isTimeElapsed(Integer scheduleTime, LocalDateTime updatedTime) {
		Duration duration = Duration.between(updatedTime, LocalDateTime.now());
        return duration.toMinutes() >= scheduleTime.longValue();
	}
}

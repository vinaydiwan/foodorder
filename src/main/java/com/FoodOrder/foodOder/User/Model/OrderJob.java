package com.FoodOrder.foodOder.User.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderjob")
public class OrderJob {

	@Id
	@Column(name = "orderid")
	private Long orderId;

	@Column(name = "status")
	private String status;

	@Column(name = "scheduletime")
	private Integer scheduleTime;

	@Column(name = "updatedtime")
	private LocalDateTime updatedTime;

	public OrderJob() {
		super();
	}

	public OrderJob(Long orderId, String status, Integer scheduleTime, LocalDateTime updatedTime) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.scheduleTime = scheduleTime;
		this.updatedTime = updatedTime;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Integer scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "OrderJob [orderId=" + orderId + ", status=" + status + ", scheduleTime=" + scheduleTime
				+ ", updatedTime=" + updatedTime + "]";
	}

}

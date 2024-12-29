package com.FoodOrder.foodOder.Admin.Exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 8098752531681108439L;

	private LocalDateTime localDateTime;
	private String message;

	public CustomException(String message) {
		super();
		this.localDateTime = LocalDateTime.now();
		this.message = message;
	}

	public CustomException(LocalDateTime localDateTime, String message) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "CustomException [localDateTime=" + localDateTime.format(format) + ", message=" + message + "]";
	}

}

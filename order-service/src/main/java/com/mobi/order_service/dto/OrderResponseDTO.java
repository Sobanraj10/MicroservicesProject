package com.mobi.order_service.dto;

public class OrderResponseDTO {
	
	
	private Long orderId;
	private Long productId;
	private Integer quantity;
	private Double totalPrice;
	
	private String productName;
	private Double productPrice;
	
	
	public OrderResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponseDTO(Long orderId, Long productId, Integer quantity, Double totalPrice, String productName,
			Double productPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.productPrice = productPrice;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}

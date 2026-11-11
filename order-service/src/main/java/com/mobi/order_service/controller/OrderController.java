package com.mobi.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.mobi.order_service.dto.OrderResponseDTO;
import com.mobi.order_service.dto.ProductDTO;
import com.mobi.order_service.entity.Order;
import com.mobi.order_service.repo.OrderRepo;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@PostMapping("/placeorder")
	public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order){
		//Fetch product details from product services
		
		return webClientBuilder.build().get().uri("http://localhost:8081/products/"+ order.getProductId()).retrieve()
						.bodyToMono(ProductDTO.class).map(productDTO -> {
							OrderResponseDTO responseDTO = new OrderResponseDTO();
							
							responseDTO.setProductId(order.getProductId());
							responseDTO.setQuantity(order.getQuantity());
							
							responseDTO.setProductName(productDTO.getName());
							responseDTO.setTotalPrice(order.getQuantity() * productDTO.getPrice());
							responseDTO.setProductPrice(productDTO.getPrice());
							orderRepo.save(order);
							responseDTO.setOrderId(order.getId());
							return ResponseEntity.ok(responseDTO);
						});
	}
	
	@GetMapping
	public List<Order> getAllOrders(){
		System.out.println("GET_ALL_ORDERS");
		return orderRepo.findAll();
	}

}

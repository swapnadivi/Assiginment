package com.eureka.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class APIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(APIGatewayApplication.class, args);
	}



	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/product/create")
						.uri("http://localhost:3001/product/create"))
				.route(p->p.path("/product/productId/**")
						.uri("http://localhost:3001/product/productId/**"))
				.route(p->p.path("/product/update")
						.uri("http://localhost:3001/product/update"))
				.route(p->p.path("/product/allProducts")
						.uri("http://localhost:3001/product/allProducts"))
				.route(p->p.path("/product/checkProductById")
						.filters(rw -> rw.rewritePath("/product/checkProductById/(?<productId>.*)", "/product/checkProductById/${productId}"))
						.uri("http://localhost:3001/product/checkProductById/"))
				.route(p -> p
						.path("/carts/add-into-cart")
						.uri("http://localhost:3001//carts/add-into-cart"))
				.route(p -> p
						.path("/carts/update")
						.uri("http://localhost:3001/carts/update"))
				.route(p -> p
						.path("/carts/allCarts")
						.uri("http://localhost:3001/carts/allCarts"))
				.route(p -> p
						.path("/carts/delete")
						.filters(rw -> rw.rewritePath("/shopping/delete/(?<cartId>.*)", "/shopping/delete/${cartId}"))
						.uri("http://localhost:3001/carts/delete"))
				.route(p -> p
						.path("/consumer-carts/all-carts")
						.filters(rw -> rw.rewritePath("/consumer-carts/all-carts/(?<userId>.*)", "/consumer-carts/all-carts/${userId}"))
						.uri("http://localhost:3002/consumer-carts/all-carts"))
				.build();
	}
}

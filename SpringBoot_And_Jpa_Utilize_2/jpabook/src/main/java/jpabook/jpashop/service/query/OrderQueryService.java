package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderSimpleApiController;
import jpabook.jpashop.domain.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class OrderQueryService {

	public List<OrderDto> ordersV3() {
		List<Order> orders = orderRepository.findAllWithMemberDelivery();
		return orders.stream()
				.map(OrderSimpleApiController.SimpleOrderDto::new)
				.toList();
	}
}

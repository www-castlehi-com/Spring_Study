package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void test() {
		Order order = new Order();
		order.addOrderItem(new OrderItem());

		em.persist(order); // 필요하면
	}
}

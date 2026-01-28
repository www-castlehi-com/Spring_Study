package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void test() {
		Book book = new Book();
		book.setName("JPA");
		book.setAuthor("김영한");

		em.persist(book);
	}
}

package hello.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void test() {
		Member member = new Member();
		member.setUsername("member1");
		em.persist(member);
	}
}

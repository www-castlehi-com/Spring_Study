package hello.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void test() {
		for (int i = 0; i < 100; i++) {
			Member member = new Member();
			member.setUsername("member" + i);
			member.setAge(i);
			em.persist(member);
		}

		em.flush();
		em.clear();

		List<Member> result = em.createQuery("select m FROM Member m order by m.age desc", Member.class)
				.setFirstResult(1)
				.setMaxResults(10)
				.getResultList();

		System.out.println("result.size() = " + result.size());
		for (Member member1 : result) {
			System.out.println("member1 = " + member1);
		}
	}
}

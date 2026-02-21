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
		Member member = new Member();
		member.setUsername("member1");
		member.setAge(10);
		em.persist(member);

		em.flush();
		em.clear();

		List<MemberDTO> result = em.createQuery("select new MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
				.getResultList();
		MemberDTO memberDTO = result.get(0);
		System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
		System.out.println("memberDTO.getAge() = " + memberDTO.getAge());
	}
}

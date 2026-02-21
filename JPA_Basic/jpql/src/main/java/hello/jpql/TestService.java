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
		Team team = new Team();
		team.setName("teamA");
		em.persist(team);

		Member member = new Member();
		member.setUsername("member");
		member.setAge(10);
		member.changeTeam(team);

		em.persist(member);

		em.flush();
		em.clear();

		// String query = "select m from Member m inner join m.team t";
		// String query = "select m from Member m left join m.team t";
		String query = "select m from Member m, Team t where m.username = t.name";
		List<Member> result = em.createQuery(query, Member.class)
				.getResultList();

		System.out.println("result.size() = " + result.size());
	}
}

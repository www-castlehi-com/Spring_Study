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
		Team teamA = new Team();
		teamA.setName("팀A");
		em.persist(teamA);

		Team teamB = new Team();
		teamB.setName("팀B");
		em.persist(teamB);

		Member member1 = new Member();
		member1.setUsername("회원1");
		member1.changeTeam(teamA);
		em.persist(member1);

		Member member2 = new Member();
		member2.setUsername("회원2");
		member2.changeTeam(teamA);
		em.persist(member2);

		Member member3 = new Member();
		member3.setUsername("회원3");
		member3.changeTeam(teamB);
		em.persist(member3);

		em.flush();
		em.clear();

		// String query = "select m from Member m join fetch m.team";
		// List<Member> result = em.createQuery(query, Member.class)
		// 		.getResultList();
		//
		// for (Member member : result) {
		// 	System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());
		// }

		String query = "select t from Team t join fetch t.members";
		List<Team> teams = em.createQuery(query, Team.class).getResultList();

		for (Team team : teams) {
			System.out.println("team = " + team.getName() + ", " + team.getMembers().size());
		}
	}
}

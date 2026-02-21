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
		member.setUsername("관리자");
		member.setAge(10);
		member.changeTeam(team);

		em.persist(member);

		em.flush();
		em.clear();

		// String query = "select case when m.age <= 10 then '학생요금' when m.age >= 60 then '경로요금' else '일반요금' end from Member m";
		// String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
		String query = "select nullif(m.username, '관리자') from Member m";
		List<String> result = em.createQuery(query, String.class).getResultList();
		for (String s : result) {
			System.out.println("s = " + s);
		}
	}
}

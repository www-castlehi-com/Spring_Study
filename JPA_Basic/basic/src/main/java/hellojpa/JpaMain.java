package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

public class JpaMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		//code
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member = new Member();
			member.setUsername("member1");

			member.getFavoriteFoods().addAll(Arrays.asList("치킨", "족발", "피자"));
			member.getAddressHistory().addAll(Arrays.asList(new AddressEntity("old1", "street", "10000"), new AddressEntity("old2", "street", "10000")));

			em.persist(member);

			em.flush();
			em.clear();

			System.out.println("=============== START ===============");
			Member findMember = em.find(Member.class, member.getId());

			findMember.getFavoriteFoods().remove("치킨");
			findMember.getFavoriteFoods().add("한식");

			findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
			findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();
	}
}

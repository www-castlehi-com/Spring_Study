package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
			List<Member> resultList = em.createNativeQuery("select member_id, username from member").getResultList();

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

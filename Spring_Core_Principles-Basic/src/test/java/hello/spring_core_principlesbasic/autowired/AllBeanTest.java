package hello.spring_core_principlesbasic.autowired;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.spring_core_principlesbasic.AutoAppConfig;
import hello.spring_core_principlesbasic.discount.DiscountPolicy;
import hello.spring_core_principlesbasic.member.Grade;
import hello.spring_core_principlesbasic.member.Member;

public class AllBeanTest {

	static class DiscountService {
		private final Map<String, DiscountPolicy> policyMap;
		private final List<DiscountPolicy> policies;

		public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
			this.policyMap = policyMap;
			this.policies = policies;
			System.out.println("policyMap = " + policyMap);
			System.out.println("policies = " + policies);
		}

		public int discount(Member member, int price, String discountCode) {
			DiscountPolicy discountPolicy = policyMap.get(discountCode);

			return discountPolicy.discount(member, price);
		}
	}

	@Test
	void findAllBean() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

		DiscountService discountService = ac.getBean(DiscountService.class);
		Member member = new Member(1L, "userA", Grade.VIP);
		int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

		assertThat(discountService).isInstanceOf(DiscountService.class);
		assertThat(discountPrice).isEqualTo(1000);

		int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
		assertThat(rateDiscountPrice).isEqualTo(2000);
	}
}

package hello.spring_core_principlesbasic.discount;

import hello.spring_core_principlesbasic.member.Member;

public interface DiscountPolicy {

	/**
	 * @return 할인 대상 금액
	 */
	int discount(Member member, int price);
}

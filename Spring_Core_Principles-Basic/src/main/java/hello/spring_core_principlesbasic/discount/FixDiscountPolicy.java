package hello.spring_core_principlesbasic.discount;

import org.springframework.stereotype.Component;

import hello.spring_core_principlesbasic.member.Grade;
import hello.spring_core_principlesbasic.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000; // 1000원 할인

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}

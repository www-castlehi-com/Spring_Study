package hello.spring_core_principlesbasic;

import hello.spring_core_principlesbasic.discount.DiscountPolicy;
import hello.spring_core_principlesbasic.discount.FixDiscountPolicy;
import hello.spring_core_principlesbasic.member.MemberRepository;
import hello.spring_core_principlesbasic.member.MemberService;
import hello.spring_core_principlesbasic.member.MemberServiceImpl;
import hello.spring_core_principlesbasic.member.MemoryMemberRepository;
import hello.spring_core_principlesbasic.order.OrderService;
import hello.spring_core_principlesbasic.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	private static MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	private static DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
}

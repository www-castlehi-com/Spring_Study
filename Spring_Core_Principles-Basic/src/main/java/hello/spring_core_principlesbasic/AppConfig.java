package hello.spring_core_principlesbasic;

import hello.spring_core_principlesbasic.discount.FixDiscountPolicy;
import hello.spring_core_principlesbasic.member.MemberService;
import hello.spring_core_principlesbasic.member.MemberServiceImpl;
import hello.spring_core_principlesbasic.member.MemoryMemberRepository;
import hello.spring_core_principlesbasic.order.OrderService;
import hello.spring_core_principlesbasic.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(new MemoryMemberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
}

package hello.spring_core_principlesbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.spring_core_principlesbasic.discount.DiscountPolicy;
import hello.spring_core_principlesbasic.discount.RateDiscountPolicy;
import hello.spring_core_principlesbasic.member.MemberRepository;
import hello.spring_core_principlesbasic.member.MemberService;
import hello.spring_core_principlesbasic.member.MemberServiceImpl;
import hello.spring_core_principlesbasic.member.MemoryMemberRepository;
import hello.spring_core_principlesbasic.order.OrderService;
import hello.spring_core_principlesbasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public static MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public static DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
}

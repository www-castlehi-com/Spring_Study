package hello.spring_core_principlesbasic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.spring_core_principlesbasic.AppConfig;
import hello.spring_core_principlesbasic.member.MemberRepository;
import hello.spring_core_principlesbasic.member.MemberServiceImpl;
import hello.spring_core_principlesbasic.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

	@Test
	void ConfigurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(
			AppConfig.class);

		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();

		System.out.println("memberService -> memberRepository = " + memberRepository1);
		System.out.println("orderService -> memberRepository = " + memberRepository2);
		System.out.println("memberRepository = " + memberRepository);

		assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}

	@Test
	void configurationDeep() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			AppConfig.class);

		AppConfig bean = ac.getBean(AppConfig.class);

		System.out.println("bean = " + bean.getClass());
	}
}

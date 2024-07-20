package hello.spring_core_principlesbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.spring_core_principlesbasic.member.Grade;
import hello.spring_core_principlesbasic.member.Member;
import hello.spring_core_principlesbasic.member.MemberService;
import hello.spring_core_principlesbasic.order.Order;
import hello.spring_core_principlesbasic.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();

		// MemberService memberService = new MemberServiceImpl();
		// OrderService orderService = new OrderServiceImpl();

		// MemberService memberService = appConfig.memberService();
		// OrderService orderService = appConfig.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 20000);

		System.out.println("order = " + order);
	}
}

package hello.aop.proxyvs;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class ProxyCastingTest {

	@Test
	void jdkProxy() {
		MemberServiceImpl target = new MemberServiceImpl();
		ProxyFactory proxyFactory = new ProxyFactory(target);
		proxyFactory.setProxyTargetClass(false);

		// 프록시를 인터페이스로 캐스팅 성공
		MemberService proxy = (MemberService)proxyFactory.getProxy();

		// JDK 동적 프록시를 구현 클래스로 캐스팅 시도 실패, ClassCastException 예외 발생
		assertThatThrownBy(() -> {
			MemberServiceImpl memberServiceImpl = (MemberServiceImpl)proxy;
		}).isInstanceOf(ClassCastException.class);
	}

	@Test
	void cglibProxy() {
		MemberServiceImpl target = new MemberServiceImpl();
		ProxyFactory proxyFactory = new ProxyFactory(target);
		proxyFactory.setProxyTargetClass(true);

		// 프록시를 인터페이스로 캐스팅 성공
		MemberService proxy = (MemberService)proxyFactory.getProxy();

		// CGLIB 동적 프록시를 구현 클래스로 캐스팅 시도 성공, ClassCastException 예외 발생
		MemberServiceImpl memberServiceImpl = (MemberServiceImpl)proxy;
	}
}

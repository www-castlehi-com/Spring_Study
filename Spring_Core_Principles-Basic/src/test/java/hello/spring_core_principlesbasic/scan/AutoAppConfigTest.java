package hello.spring_core_principlesbasic.scan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.spring_core_principlesbasic.AutoAppConfig;
import hello.spring_core_principlesbasic.member.MemberService;

public class AutoAppConfigTest {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			AutoAppConfig.class);

		MemberService memberService = ac.getBean(MemberService.class);

		assertThat(memberService).isInstanceOf(MemberService.class);
	}
}

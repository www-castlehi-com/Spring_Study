package hello.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private EntityManager em;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// @Bean
	// public MemberRepository memberRepository() {
	// 	// return new MemoryMemberRepository();
	// 	// return new JdbcMemberRepository(dataSource);
	// 	// return new JdbcTemplateMemberRepository(dataSource);
	// 	return new JpaMemberRepostiory(em);
	// }

	@Bean
	public MemberService memberService() {
		// return new MemberService(memberRepository());
		return new MemberService(memberRepository);
	}

	// @Bean
	// public TimeTraceAop timeTraceAop() {
	// 	return new TimeTraceAop();
	// }
}

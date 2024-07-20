package hello.spring_core_principlesbasic;

import hello.spring_core_principlesbasic.member.Grade;
import hello.spring_core_principlesbasic.member.Member;
import hello.spring_core_principlesbasic.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();

		// MemberService memberService = new MemberServiceImpl();
		MemberService memberService = appConfig.memberService();
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
	}
}

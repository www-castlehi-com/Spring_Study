package hello.spring_core_principlesbasic.member;

public interface MemberService {

	void join(Member member);

	Member findMember(Long memberId);
}

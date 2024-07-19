package hello.spring_core_principlesbasic.order;

import hello.spring_core_principlesbasic.discount.DiscountPolicy;
import hello.spring_core_principlesbasic.discount.FixDiscountPolicy;
import hello.spring_core_principlesbasic.member.Member;
import hello.spring_core_principlesbasic.member.MemberRepository;
import hello.spring_core_principlesbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}

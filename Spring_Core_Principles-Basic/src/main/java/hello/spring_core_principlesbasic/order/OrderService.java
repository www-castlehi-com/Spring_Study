package hello.spring_core_principlesbasic.order;

public interface OrderService {

	Order createOrder(Long memberId, String itemName, int itemPrice);
}

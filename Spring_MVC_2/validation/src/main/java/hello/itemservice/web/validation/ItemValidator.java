package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return Item.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Item item = (Item) o;

		// 검증 로직
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "required");
		if (!StringUtils.hasText(item.getItemName())) {
			errors.rejectValue("itemName", "required");
		}
		if (item.getPrice() == null || item.getPrice() < 1_000 || item.getPrice() > 1_000_000) {
			errors.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
		}
		if (item.getQuantity() == null || item.getQuantity() >= 9999) {
			errors.rejectValue("quantity", "max", new Object[]{9999}, null);
		}

		// 특정 필드가 아닌 복합 룰 검증
		if (item.getPrice() != null && item.getQuantity() != null) {
			int resultPrice = item.getPrice() * item.getQuantity();
			if (resultPrice < 10_000) {
				errors.reject("totalPrice", new Object[]{10000, resultPrice}, null);
			}
		}
	}
}

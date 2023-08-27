package phonesale.service;

import java.util.List;

import phonesale.dto.cartDTO;
import phonesale.dto.productDTO;

public interface cartService {
	List<productDTO> getProductCart(String username);
	int totalCart(String username);
	int quantity(Long productId);
	Long totalPrice(String username);
	void upQuantity(Long productId);
	void downQuantity(Long productId);
	void deleteCart(Long productId);
}

package phone2.service;

import java.util.List;

import phone2.dto.cartDTO;
import phone2.dto.productDTO;

public interface cartService {
	List<productDTO> getProductCart(String username);
	int totalCart(String username);
	int quantity(Long productId);
	Long totalPrice(String username);
	void upQuantity(Long productId);
	void downQuantity(Long productId);
	void deleteCart(Long productId);
}

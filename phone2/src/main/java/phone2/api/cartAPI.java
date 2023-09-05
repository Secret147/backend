package phone2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import phone2.service.cartService;


@RestController
@CrossOrigin
public class cartAPI {
	
	@Autowired
	private cartService cartSe;

	@GetMapping("/product2/{username}")
	public ResponseEntity<?> getProduct(@PathVariable("username") String username) {
		return ResponseEntity.ok(cartSe.getProductCart(username));
	}
	@GetMapping("/size/{username}")
	public ResponseEntity<?> countProduct(@PathVariable("username") String username) {
		return ResponseEntity.ok(cartSe.totalCart(username));
	}
	@GetMapping("/cart/quantity/{productId}")
	public ResponseEntity<?> countQuantity(@PathVariable("productId") Long productId){
		return ResponseEntity.ok(cartSe.quantity(productId));
	}
	@GetMapping("/cart/totalprice/{username}")
	public ResponseEntity<?> totalPrice(@PathVariable("username") String username){
		return ResponseEntity.ok(cartSe.totalPrice(username));
	}
	@PostMapping("/cart/up/{productId}")
	public ResponseEntity<?> upQuantity(@PathVariable("productId") Long productId){
		cartSe.upQuantity(productId);
		return ResponseEntity.ok("upQuantity");
	}
	@PostMapping("/cart/down/{productId}")
	public ResponseEntity<?> downQuantity(@PathVariable("productId") Long productId){
		cartSe.downQuantity(productId);
		return ResponseEntity.ok("downQuantity");
	}
	@DeleteMapping("/cart/product/{productId}")
    public ResponseEntity<String> removeProduct(@PathVariable Long productId) {
        cartSe.deleteCart(productId);
        return ResponseEntity.ok("success");
    }

}

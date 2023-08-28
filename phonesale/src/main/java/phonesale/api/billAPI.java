package phonesale.api;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.experimental.PackagePrivate;
import phonesale.dto.billDTO;
import phonesale.entity.billEntity;
import phonesale.entity.billdetailEntity;
import phonesale.entity.cartEntity;
import phonesale.entity.customerEntity;
import phonesale.entity.productEntity;
import phonesale.repository.billRepository;
import phonesale.repository.billdetailRepository;
import phonesale.repository.cartRepository;
import phonesale.repository.customerRepository;
import phonesale.service.billService;

@RestController
@CrossOrigin
public class billAPI {
	@Autowired
	private billRepository billRe;
	
	@Autowired
	private customerRepository customerRe;
	
	@Autowired
	private billdetailRepository billdetailRe;
	
	@Autowired
	private cartRepository cartRe;
	
	@Autowired
	private billService billSe;

	@PostMapping("/bill/{username}")
	public ResponseEntity<?> createBill(@RequestBody billDTO bill,@PathVariable("username") String username){
		 billSe.saveBill(bill, username);
	     return ResponseEntity.ok(bill);
	}
	@PostMapping("bill/saveone/{username}/{productId}")
	public ResponseEntity<?> saveOnebill(@RequestBody billDTO bill, 
			@PathVariable("username") String username,@PathVariable("productId") Long productId){
		billSe.saveOneBill(bill, username,productId);
		return ResponseEntity.ok(null);
	}
	@GetMapping("/bill/{username}")
	public ResponseEntity<?> getBill(@PathVariable("username") String username){
		return ResponseEntity.ok(billSe.getAllBill(username));
	}
	@GetMapping("bill/all")
	public ResponseEntity<?> getAllBill(){
		
		return ResponseEntity.ok(billSe.getAllBills());
	}
	@GetMapping("bill/one/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id){
		return ResponseEntity.ok(billSe.getBill(id));
	}
	@DeleteMapping("/bill/{billid}")
	public ResponseEntity<?> deleteBill(@PathVariable("billid") Long billId){
		billSe.deleteBill(billId);
		return ResponseEntity.ok("success");
	}
	

}

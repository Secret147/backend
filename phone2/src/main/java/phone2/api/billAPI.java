package phone2.api;

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
import phone2.dto.billDTO;
import phone2.entity.billEntity;
import phone2.entity.billdetailEntity;
import phone2.entity.cartEntity;
import phone2.entity.customerEntity;
import phone2.entity.productEntity;
import phone2.repository.billRepository;
import phone2.repository.billdetailRepository;
import phone2.repository.cartRepository;
import phone2.repository.customerRepository;
import phone2.service.billService;

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

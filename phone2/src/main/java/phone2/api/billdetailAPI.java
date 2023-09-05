package phone2.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import phone2.entity.billEntity;
import phone2.entity.billdetailEntity;
import phone2.entity.productEntity;
import phone2.repository.billRepository;
import phone2.repository.billdetailRepository;
import phone2.repository.productRepository;
import phone2.service.billdetailService;

@RestController
@CrossOrigin
public class billdetailAPI {
	@Autowired
	private billdetailRepository billdetailRe;
	
	@Autowired
	private billRepository billRe;
	
	@Autowired
	private productRepository productRe;
	
	@Autowired
	private billdetailService billdetailSe;

	@GetMapping("/billdetail/{billid}")
	public ResponseEntity<?> getproduct (@PathVariable("billid")Long id){
		return ResponseEntity.ok(billdetailSe.getProducts(id));
	}
	@GetMapping("/billdetail/quantity/{productid}/{billid}")
	public ResponseEntity<?> getQantity(@PathVariable("productid") Long productid,@PathVariable("billid") Long billid){
		return ResponseEntity.ok(billdetailSe.quantity(productid, billid));
		
	}

}

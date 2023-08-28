package phonesale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phonesale.converter.billConverter;
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
import phonesale.repository.productRepository;
import phonesale.service.billService;

@Service
public class billServiceImpl implements billService{
	@Autowired
	private billRepository billRe;
	
	@Autowired
	private customerRepository customerRe;
	
	@Autowired
	private billdetailRepository billdetailRe;
	
	@Autowired
	private cartRepository cartRe;
	
	@Autowired
	private billConverter billCo;
	
	@Autowired
	private productRepository productRe;
	
	@Override
	public void saveBill(billDTO dto,String username) {
		 customerEntity customer = customerRe.findByName(username);
		 billEntity bill = billCo.tobillEntity(dto);
		 List<billdetailEntity> billdetails = new ArrayList<>();
		 List<cartEntity> carts = cartRe.findAllByCustomer_Id(customer.getId());
		 long sum=0;
		 for(cartEntity cart : carts) {
			 billdetailEntity billdetail = new billdetailEntity();
			 productEntity product = cart.getProduct();
			 sum += cart.getQuantity()*product.getPrice();
			 billdetail.setBill(bill);
			 billdetail.setProductbill(cart.getProduct());
			 billdetail.setQuantity(cart.getQuantity());
			 billdetails.add(billdetail);
			
		 }
		 bill.setCustomerbill(customer);
	     bill.setTotalprice(sum);
	     billRe.save(bill);
		 billdetailRe.saveAll(billdetails);
	     cartRe.deleteAll(carts);
	}
	
	@Override
	public void saveOneBill(billDTO dto,String username, Long productid) {
		customerEntity customer = customerRe.findByName(username);
		billEntity bill = billCo.tobillEntity(dto);
		productEntity product = productRe.findById(productid).get();
		billdetailEntity billdetail = new billdetailEntity();
		bill.setCustomerbill(customer);
		bill.setTotalprice(product.getPrice());
		billRe.save(bill);
		billdetail.setBill(bill);
		billdetail.setProductbill(product);
		billdetail.setQuantity(1);
		billdetailRe.save(billdetail);
		
		
	}
	
	@Override
	public List<billDTO> getAllBill(String username){
		customerEntity customer = customerRe.findByName(username);
		List<billEntity> bills = billRe.findByCustomerbill_Id(customer.getId());
		List<billDTO> dtos = new ArrayList<>();
		for(billEntity bill : bills) {
			dtos.add(billCo.tobillDTO(bill));
		}
		return dtos;
	}
	
	@Override
	public List<billDTO> getAllBills(){
		List<billEntity> bills = billRe.findAll();
		List<billDTO> dtos = new ArrayList<>();
		for(billEntity bill : bills) {
			dtos.add(billCo.tobillDTO(bill));
		}
		return dtos;
	}
	
	@Override
	public billDTO getBill(Long id) {
		billEntity bill = billRe.findById(id).get();
		return billCo.tobillDTO(bill);
	}
	@Override
	public void deleteBill(Long billId) {
		billEntity bill = billRe.findById(billId).get();
		List<billdetailEntity> billdetails = billdetailRe.findAllByBill_Id(billId);
		billdetailRe.deleteAll(billdetails);
		billRe.delete(bill);
	}
	
	
	

}

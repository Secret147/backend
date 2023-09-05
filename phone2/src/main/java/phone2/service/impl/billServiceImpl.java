package phone2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phone2.converter.billConverter;
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
import phone2.repository.productRepository;
import phone2.service.billService;

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

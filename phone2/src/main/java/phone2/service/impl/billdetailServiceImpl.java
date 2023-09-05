package phone2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phone2.converter.productConverter;
import phone2.dto.productDTO;
import phone2.entity.billEntity;
import phone2.entity.billdetailEntity;
import phone2.entity.productEntity;
import phone2.repository.billRepository;
import phone2.repository.billdetailRepository;
import phone2.repository.productRepository;
import phone2.service.billdetailService;

@Service
public class billdetailServiceImpl implements billdetailService {
	@Autowired
	private billdetailRepository billdetailRe;
	
	@Autowired
	private billRepository billRe;
	
	@Autowired
	private productRepository productRe;
	
	@Autowired
	private productConverter productCo;
	
	@Override
	public List<productDTO> getProducts(Long id){
		List<productDTO> products = new ArrayList<>();
		List<billdetailEntity> billdetails = billdetailRe.findAllByBill_Id(id);
		for(billdetailEntity billdetail : billdetails) {
			products.add(productCo.toproductDTO(billdetail.getProductbill()));
		}
		return products;
	}
	
	@Override
	public int quantity(Long productid,Long billid) {
		List<billdetailEntity> billdetails = billdetailRe.findAllByBill_Id(billid);
		int quantity = 0;
		for(billdetailEntity billdetail : billdetails) {
			if(billdetail.getProductbill().getId().equals(productid)) {
				quantity = billdetail.getQuantity();
			}
		}
		return quantity;
	}
}

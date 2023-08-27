package phonesale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phonesale.converter.productConverter;
import phonesale.dto.productDTO;
import phonesale.entity.billEntity;
import phonesale.entity.billdetailEntity;
import phonesale.entity.productEntity;
import phonesale.repository.billRepository;
import phonesale.repository.billdetailRepository;
import phonesale.repository.productRepository;
import phonesale.service.billdetailService;

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

package phone2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phone2.converter.customerConverter;
import phone2.dto.customerDTO;
import phone2.entity.customerEntity;
import phone2.repository.customerRepository;
import phone2.service.customerService;

@Service
public class customerServiceImpl implements customerService {
	@Autowired
	private customerRepository customerRe;

	@Autowired
	private customerConverter customerCo;

	@Override
	public customerDTO findByName(String username) {
		customerEntity entity = customerRe.findByName(username);
		return customerCo.tocustomerDTO(entity);
	}
    
	@Override
	public int check(customerDTO customer) {
		if(customerRe.findByName(customer.getName())==null) {
			return 1;
		}
		else {
			return 0;
		}
	}
	@Override
	public void save(customerDTO customer) {
		customerRe.save(customerCo.tocustomerEntity(customer));
	}

	@Override
	public List<customerDTO> findAll() {
		List<customerEntity> customers = customerRe.findAll();
		List<customerDTO> dtos = new ArrayList<>();
		for (customerEntity entity : customers) {
			dtos.add(customerCo.tocustomerDTO(entity));
		}
		return dtos;
	}

	@Override
	public customerDTO findById(Long id) {
		customerEntity entity = customerRe.findById(id).get();
		return customerCo.tocustomerDTO(entity);
	}

	@Override
	public void delete(customerDTO customer) {
		customerRe.delete(customerCo.tocustomerEntity(customer));
	}
}
package phone2.service;

import java.util.List;

import phone2.dto.customerDTO;
import phone2.entity.customerEntity;

public interface customerService {

	customerDTO findByName(String username);
	
	int check(customerDTO customer);

	void save(customerDTO customer);

	List<customerDTO> findAll();

	customerDTO findById(Long id);

	void delete(customerDTO customer);
}

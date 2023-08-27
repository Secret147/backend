package phonesale.service;

import java.util.List;

import phonesale.dto.customerDTO;
import phonesale.entity.customerEntity;

public interface customerService {

	customerDTO findByName(String username);
	
	int check(customerDTO customer);

	void save(customerDTO customer);

	List<customerDTO> findAll();

	customerDTO findById(Long id);

	void delete(customerDTO customer);
}

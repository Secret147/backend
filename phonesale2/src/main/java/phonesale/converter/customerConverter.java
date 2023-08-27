package phonesale.converter;

import org.springframework.stereotype.Component;

import phonesale.dto.customerDTO;
import phonesale.entity.customerEntity;

@Component
public class customerConverter {
	public customerEntity tocustomerEntity(customerDTO dto) {
		customerEntity entity = new customerEntity();
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		entity.setPassword(dto.getPassword());
		entity.setBirth(dto.getBirth());
		entity.setName(dto.getName());
		entity.setNumber(dto.getNumber());
		entity.setRole(dto.getRole());
		return entity;
	}
	public customerDTO tocustomerDTO(customerEntity entity) {
		customerDTO dto = new customerDTO();
		dto.setId(entity.getId());
		dto.setAddress(entity.getAddress());
		dto.setPassword(entity.getPassword());
		dto.setBirth(entity.getBirth());
		dto.setName(entity.getName());
		dto.setNumber(entity.getNumber());
		dto.setRole(entity.getRole());
		return dto;
	}
}

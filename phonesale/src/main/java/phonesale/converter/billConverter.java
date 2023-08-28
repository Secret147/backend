package phonesale.converter;

import org.springframework.stereotype.Component;

import phonesale.dto.billDTO;
import phonesale.entity.billEntity;

@Component
public class billConverter {

	public billEntity tobillEntity(billDTO dto) {
		billEntity entity = new billEntity();
		entity.setId(dto.getId());
		entity.setCreateAt(dto.getCreateAt());
		entity.setAddress(dto.getAddress());
		entity.setBill(dto.getBill());
		entity.setEmail(dto.getEmail());
		entity.setNumberphone(dto.getNumberphone());
		entity.setName(dto.getName());
		entity.setNote(dto.getNote());
		entity.setTotalprice(dto.getTotalprice());
		entity.setMethod(dto.getMethod());
		return entity;
	}
	public billDTO tobillDTO(billEntity entity) {
		billDTO dto = new billDTO();
		dto.setId(entity.getId());
		dto.setCreateAt(entity.getCreateAt());
		dto.setAddress(entity.getAddress());
		dto.setBill(entity.getBill());
		dto.setEmail(entity.getEmail());
		dto.setNumberphone(entity.getNumberphone());
		dto.setName(entity.getName());
		dto.setNote(entity.getNote());
		dto.setTotalprice(entity.getTotalprice());
		dto.setMethod(entity.getMethod());
		return dto;
	}

}

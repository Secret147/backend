package phone2.converter;

import org.springframework.stereotype.Component;

import phone2.dto.productDTO;
import phone2.entity.productEntity;

@Component
public class productConverter {

	public productEntity toproductEntity(productDTO dto) {
		productEntity entity = new productEntity();
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setMemory(dto.getMemory());
		entity.setImg(dto.getImg());
		entity.setPrice(dto.getPrice());
		entity.setName(dto.getName());
		entity.setType(dto.getType());
		return entity;
	}

	public productDTO toproductDTO(productEntity entity) {
		productDTO dto = new productDTO();
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setMemory(entity.getMemory());
		dto.setImg(entity.getImg());
		dto.setPrice(entity.getPrice());
		dto.setName(entity.getName());
		dto.setType(entity.getType());
		return dto;
	}

}

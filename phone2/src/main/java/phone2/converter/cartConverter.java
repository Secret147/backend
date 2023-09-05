package phone2.converter;

import org.springframework.stereotype.Component;

import phone2.dto.cartDTO;
import phone2.entity.cartEntity;

@Component
public class cartConverter {

	public cartEntity tocartEntity(cartDTO dto) {
		cartEntity entity = new cartEntity();
		entity.setId(dto.getId());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
	public cartDTO tocartDTO(cartEntity entity) {
		cartDTO dto = new cartDTO();
		dto.setId(entity.getId());
		dto.setQuantity(entity.getQuantity());
		return dto;

	}

}

package phone2.converter;

import phone2.dto.billDTO;
import phone2.dto.billdetailDTO;
import phone2.entity.billEntity;
import phone2.entity.billdetailEntity;

public class billdetailConverter {

	public billdetailEntity tobilldetailEntity(billdetailDTO dto) {
	      billdetailEntity entity = new billdetailEntity();
	      entity.setId(dto.getId());
	      entity.setQuantity(dto.getQuantity());
	      return entity;
	}
	public billdetailDTO tobilldetailDTO(billdetailEntity entity) {
	      billdetailDTO dto = new billdetailDTO();
	      dto.setId(entity.getId());
	      dto.setQuantity(entity.getQuantity());
	      return dto;
	}

}

package phonesale.converter;

import phonesale.dto.billDTO;
import phonesale.dto.billdetailDTO;
import phonesale.entity.billEntity;
import phonesale.entity.billdetailEntity;

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

package phone2.service;

import java.util.List;

import phone2.dto.billDTO;

public interface billService {
     void saveBill(billDTO dto,String username);
     void saveOneBill(billDTO dto,String username, Long productId);
     List<billDTO> getAllBill(String username);
     List<billDTO> getAllBills();
     billDTO getBill(Long billId);
     void deleteBill(Long billId);
}

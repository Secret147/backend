package phone2.service;
import java.util.List;

import phone2.dto.productDTO;

public interface billdetailService {
     List<productDTO> getProducts(Long id);
     int quantity(Long productid,Long billid);
}

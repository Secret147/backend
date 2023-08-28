package phonesale.service;
import java.util.List;

import phonesale.dto.productDTO;

public interface billdetailService {
     List<productDTO> getProducts(Long id);
     int quantity(Long productid,Long billid);
}

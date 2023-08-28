package phonesale.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import phonesale.dto.productDTO;
import phonesale.entity.productEntity;

public interface productService {
	List<productDTO> findAllPage(Pageable pageble);
	List<productEntity> searchProducts(String keyword);
    List<productDTO> findByType(String type);
    List<productDTO> findAll();
    productDTO findById(Long id);
    void saveCart(String username, Long productId);
    void save(productDTO product);
    void delete(Long id);
}

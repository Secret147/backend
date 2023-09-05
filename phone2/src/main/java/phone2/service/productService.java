package phone2.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import phone2.dto.productDTO;
import phone2.entity.productEntity;

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

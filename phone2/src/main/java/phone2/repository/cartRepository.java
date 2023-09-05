package phone2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phone2.entity.cartEntity;
import phone2.entity.customerEntity;
import phone2.entity.productEntity;

public interface cartRepository extends JpaRepository<cartEntity, Long>{
    List<cartEntity> findAllByCustomer_Id(Long customerId);
    cartEntity findByProduct_Id(Long productId);
    cartEntity findByCustomer_Id(Long customerId);
}

package phonesale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phonesale.entity.cartEntity;
import phonesale.entity.customerEntity;
import phonesale.entity.productEntity;

public interface cartRepository extends JpaRepository<cartEntity, Long>{
    List<cartEntity> findAllByCustomer_Id(Long customerId);
    cartEntity findByProduct_Id(Long productId);
    cartEntity findByCustomer_Id(Long customerId);
}

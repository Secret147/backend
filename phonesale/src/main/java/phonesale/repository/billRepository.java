package phonesale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phonesale.entity.billEntity;
import phonesale.entity.customerEntity;

public interface billRepository extends JpaRepository<billEntity, Long>{
    List<billEntity> findByCustomerbill_Id(Long id);
}

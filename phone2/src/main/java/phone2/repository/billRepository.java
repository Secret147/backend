package phone2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phone2.entity.billEntity;
import phone2.entity.customerEntity;

public interface billRepository extends JpaRepository<billEntity, Long>{
    List<billEntity> findByCustomerbill_Id(Long id);
}

package phone2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phone2.entity.billdetailEntity;

public interface billdetailRepository extends JpaRepository<billdetailEntity, Long>{
	List<billdetailEntity> findByProductbill_Id(Long id);
	List<billdetailEntity> findAllByBill_Id(Long id);
	billdetailEntity findByBill_Id(Long id);
	
}

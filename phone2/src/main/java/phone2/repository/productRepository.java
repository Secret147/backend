package phone2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import phone2.entity.customerEntity;
import phone2.entity.productEntity;

public interface productRepository extends JpaRepository<productEntity, Long> {

	List<productEntity> findByName(String name);

	List<productEntity> findByType(String type);

}

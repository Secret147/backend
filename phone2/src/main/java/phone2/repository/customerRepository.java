package phone2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phone2.entity.customerEntity;

public interface customerRepository extends JpaRepository<customerEntity, Long>{
	customerEntity findByName(String name);

}

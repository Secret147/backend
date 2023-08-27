package phonesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phonesale.entity.customerEntity;

public interface customerRepository extends JpaRepository<customerEntity, Long>{
	customerEntity findByName(String name);

}

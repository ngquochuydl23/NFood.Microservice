package spring.demo.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.demo.demo.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByPhone(String phone);

    boolean existsByPhone(String phone);

}

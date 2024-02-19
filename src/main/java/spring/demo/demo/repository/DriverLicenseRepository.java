package spring.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.demo.demo.entity.DriverLicense;

public interface DriverLicenseRepository extends JpaRepository<DriverLicense, String> {
    boolean existsByNumberDriverLicense(String numberDriverLicense);
}

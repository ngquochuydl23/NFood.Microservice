package spring.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.demo.demo.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    boolean existsByLicensePlates(String licensePlates);
}

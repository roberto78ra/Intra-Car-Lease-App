package pl.coderslab.IntraCarLease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.IntraCarLease.model.Car;
import pl.coderslab.IntraCarLease.model.Lessor;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByCarPlate (String carPlate);
    Car findByBrand(String brand);
    Car findByLessor(Lessor lessor);
    List<Car> findAllByLessor(Lessor lessor);
}

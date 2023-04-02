package ma.enset.springgestioncabinetmedical.repository;

import ma.enset.springgestioncabinetmedical.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}

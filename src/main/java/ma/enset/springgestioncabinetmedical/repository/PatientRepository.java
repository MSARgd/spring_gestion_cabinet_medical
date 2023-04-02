package ma.enset.springgestioncabinetmedical.repository;

import jdk.dynalink.linker.LinkerServices;
import ma.enset.springgestioncabinetmedical.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findPatientByName(String name);
    List<Patient> findPatientByMalade(Boolean malade);

}

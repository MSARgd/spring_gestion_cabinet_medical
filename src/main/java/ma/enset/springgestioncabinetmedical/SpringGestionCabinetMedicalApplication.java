package ma.enset.springgestioncabinetmedical;

import ma.enset.springgestioncabinetmedical.entity.Patient;
import ma.enset.springgestioncabinetmedical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
public class SpringGestionCabinetMedicalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringGestionCabinetMedicalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0;i<=10;i++){
            patientRepository.save(new Patient(
                    (long) i,"patient"+i,new Random().nextBoolean(),new Random().nextInt(),
                    new Date((long) (Math.random() * System.currentTimeMillis()))
            ));
        }
        System.out.println("========================================");
        List<Patient> patientList = patientRepository.findAll();
        patientList.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("========================================");
        Patient patient = patientRepository.findById(1L).get();
        System.out.println(patient.toString());
        System.out.println("========================================");
        Patient patient2 = patientRepository.findPatientByName("patient3");
        System.out.println(patient2.toString());
        System.out.println("========================================");
        List<Patient> patientByMaladeTrue = patientRepository.findPatientByMalade(true);
        System.out.println("Les patient -> malade=true");
        patientByMaladeTrue.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("============================================");
        System.out.println("Les patient -> malade=false");
        List<Patient> patientByMaladeFalse = patientRepository.findPatientByMalade(false);
        patientByMaladeFalse.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("========================================");
        System.out.println("metter a jour un patient");
        Patient patientToUpdate = patientRepository.findById(2L).get();
        System.out.println("before update : "+patientToUpdate);
        patientToUpdate.setScore(100);
        patientToUpdate.setMalade(false);
        patientRepository.save(patientToUpdate);
        System.out.println("after update : "+patientRepository.findById(2L).get().toString());
        System.out.println("===================================");

    }
}
package ma.enset.springgestioncabinetmedical;

import ma.enset.springgestioncabinetmedical.entity.Patient;
import ma.enset.springgestioncabinetmedical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;
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






    }
}

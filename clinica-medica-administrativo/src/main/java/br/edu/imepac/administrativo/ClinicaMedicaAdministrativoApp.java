package br.edu.imepac.administrativo;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Data
@SpringBootApplication
@AllArgsConstructor
@NoArgsConstructor
public class ClinicaMedicaAdministrativoApp {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaMedicaAdministrativoApp.class, args);
    }
}


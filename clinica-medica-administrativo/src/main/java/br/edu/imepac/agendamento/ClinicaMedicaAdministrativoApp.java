package br.edu.imepac.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {"br.edu.imepac"}
)
@EnableJpaRepositories(basePackages = {"br.edu.imepac.central.repositories"})
@EntityScan(basePackages = {"br.edu.imepac.central.models"})
public class ClinicaMedicaAdministrativoApp {
    public static void main(String[] args) {
        SpringApplication.run(ClinicaMedicaAdministrativoApp.class, args);
    }
}
package com.faisaldev.taskplanner.seeders;

import com.faisaldev.taskplanner.models.Roles;
import com.faisaldev.taskplanner.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.faisaldev.taskplanner.enums.RolePermission.ADMIN;
import static com.faisaldev.taskplanner.enums.RolePermission.USER;


@Component
public class seeder implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        seedRole();
    }

    public void seedRole(){
        if (roleRepository.count() == 0) {
            Roles roleUser = new Roles();
            roleUser.setRole(USER);
            roleRepository.save(roleUser);

            Roles roleAdmin = new Roles();
            roleAdmin.setRole(ADMIN);
            roleRepository.save(roleAdmin);
        }
    }
}

package com.arrows.security;

import com.arrows.security.persistence.entity.PermissionEntity;
import com.arrows.security.persistence.entity.RoleEntity;
import com.arrows.security.persistence.entity.RoleEnum;
import com.arrows.security.persistence.entity.UserEntity;
import com.arrows.security.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();
            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();
            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();
            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();
            PermissionEntity refactoPermission = PermissionEntity.builder()
                    .name("REFACTOR")
                    .build();

            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEmun(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
                    .build();
            RoleEntity roleUser = RoleEntity.builder()
                    .roleEmun(RoleEnum.USER)
                    .permissionList(Set.of(createPermission, readPermission))
                    .build();
            RoleEntity roleInvited = RoleEntity.builder()
                    .roleEmun(RoleEnum.INVITED)
                    .permissionList(Set.of(readPermission))
                    .build();
            RoleEntity roleDeveloper = RoleEntity.builder()
                    .roleEmun(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactoPermission))
                    .build();

            UserEntity userAron = UserEntity.builder()
                    .username("AronLS")
                    .password("$2a$10$w/qCR/ojUO9PqRyJ8yuK9uf6C4uHgloqJG7631Vb6dmiIN0S2809.")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();
            UserEntity userDaniel = UserEntity.builder()
                    .username("DanielPE")
                    .password("$2a$10$w/qCR/ojUO9PqRyJ8yuK9uf6C4uHgloqJG7631Vb6dmiIN0S2809.")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();
            UserEntity userJimena = UserEntity.builder()
                    .username("JimenaOT")
                    .password("$2a$10$w/qCR/ojUO9PqRyJ8yuK9uf6C4uHgloqJG7631Vb6dmiIN0S2809.")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();
            UserEntity userMaria = UserEntity.builder()
                    .username("MariaDW")
                    .password("$2a$10$w/qCR/ojUO9PqRyJ8yuK9uf6C4uHgloqJG7631Vb6dmiIN0S2809.")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();
            userRepository.saveAll(List.of(userAron, userDaniel, userJimena, userMaria));
        };
    }

}

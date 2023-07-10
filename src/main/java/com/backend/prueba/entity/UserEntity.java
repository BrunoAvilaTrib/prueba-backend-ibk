package com.backend.prueba.entity;

import com.backend.prueba.common.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Bruno Avila
 * @FileName: UserEntity.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"})
})
public class UserEntity  implements UserDetails{

        @Id
        @GeneratedValue
        Integer id;
        @Column(nullable = false)
        String username;
        String password;
        String firstname;
        String telephone;
        Role role;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority((role.name())));
        }

        @Override
        public String getUsername() {
                return username;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}










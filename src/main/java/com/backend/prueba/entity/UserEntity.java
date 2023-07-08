package com.backend.prueba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

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
@Table(name = "user" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userName"})
})
public class UserEntity  implements UserDetails{

        @Id
        @GeneratedValue
        Integer id;
        @Column(nullable = false)
        String userName;
        String password;
        String firstname;
        String telephone;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
        }

        @Override
        public String getUsername() {
                return null;
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










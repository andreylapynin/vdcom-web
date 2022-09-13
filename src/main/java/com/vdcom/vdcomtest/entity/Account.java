package com.vdcom.vdcomtest.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
}

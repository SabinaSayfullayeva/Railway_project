package com.example.railway.domain;

import com.example.railway.config.auditing.Auditor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull

    private String username;

    private String email;

    private String password;
    @Builder.Default
    @Column(columnDefinition = "bigint default 1")
    private long roles = Role.USER_ROLE.getFlag();

    @Column(columnDefinition = "boolean default true")
    @Builder.Default
    private boolean enabled = Boolean.TRUE;
    @OneToMany
    List<Card> card;

}
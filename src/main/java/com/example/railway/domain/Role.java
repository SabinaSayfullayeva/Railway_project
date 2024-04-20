package com.example.railway.domain;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum Role {
    USER_ROLE(1),
    ADMIN_ROLE(1 << 1),
    SUPER_ADMIN_ROLE(1 << 2),
    ROLE_MANAGER(1 << 3);

    private final long flag;

    Role(long flag) {
        this.flag = flag;
    }

    private static final Map<Long, Role> ROLE_MAP = Arrays
            .stream(Role.values())
            .collect(Collectors.toMap(Role::getFlag, role -> role));

    public static Role of(final long flag) {
        final var role = ROLE_MAP.get(flag);
        if (role == null) {
            throw new IllegalArgumentException("Invalid role flag: " + flag);
        }
        return role;
    }

    public static Collection<? extends GrantedAuthority> toGrantedAuthorities(final long roles) {
        return Arrays.stream(Role.values())
                .filter(role -> (role.getFlag() & roles) == role.getFlag())
                .map(Role::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}

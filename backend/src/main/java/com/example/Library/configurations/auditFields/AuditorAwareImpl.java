package com.example.Library.configurations.auditFields;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        int randomNumber = (int) (Math.random() * 10);
        return Optional.ofNullable(String.valueOf(randomNumber));
    }
}

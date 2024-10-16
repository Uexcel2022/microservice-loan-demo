package com.eazybyties.loan.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    /**
     * @return Returns the current auditor in the application
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("LOAN_MS");
    }
}

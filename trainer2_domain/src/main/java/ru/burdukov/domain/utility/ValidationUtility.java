package ru.burdukov.domain.utility;

import java.util.Objects;

public final class ValidationUtility {
    private ValidationUtility() {}

    public static void validateNotEmpty(String variableUnderValidation, String errorMessage) {
        if (Objects.isNull(variableUnderValidation) || variableUnderValidation.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

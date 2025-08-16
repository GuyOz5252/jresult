package com.project.jresult;

import java.util.Map;

public sealed interface Result<T> permits Failure, Success {
    boolean isSuccess();
    boolean isFailure();
    T get();
    <TOut> Failure<TOut> getError();

    static <T> Success<T> success(T value) {
        return new Success<>(value);
    }

    static <T> ParameterizedFailure<T> validationFailure(String message) {
        return new ParameterizedFailure<>(
                ErrorType.VALIDATION,
                message,
                Map.of());
    }

    static <T> ParameterizedFailure<T> validationFailure(String message, Map<String, Object> parameters) {
        return new ParameterizedFailure<>(
                ErrorType.VALIDATION,
                message,
                parameters == null ? Map.of() : parameters);
    }
}

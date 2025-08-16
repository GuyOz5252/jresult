package com.project.jresult.abstraction;

import com.project.jresult.error.ErrorType;
import com.project.jresult.ParameterizedFailure;

public sealed interface Failure<T> extends Result<T> permits ParameterizedFailure {
    @Override
    default boolean isSuccess() {
        return false;
    }

    @Override
    default boolean isFailure() {
        return true;
    }

    @Override
    default T get() {
        throw new IllegalStateException("Cannot get value from failure result");
    }

    ErrorType errorType();
    String message();
}

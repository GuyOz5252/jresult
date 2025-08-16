package com.project.jresult;

import com.project.jresult.abstraction.Failure;
import com.project.jresult.error.ErrorType;

import java.util.Map;

public record ParameterizedFailure<T>(
        ErrorType errorType,
        String message,
        Map<String, Object> parameters)
        implements Failure<T> {
    @SuppressWarnings("unchecked")
    @Override
    public <TOut> ParameterizedFailure<TOut> getError() {
        return (ParameterizedFailure<TOut>)this;
    }
}

package com.project.jresult;

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

package com.project.jresult;

public record Success<T>(T value) implements Result<T> {
    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public boolean isFailure() {
        return false;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public <TOut> Failure<TOut> getError() {
        throw new IllegalStateException("Cannot get error from success result");
    }
}

package com.thoughtworks.repository;


import com.thoughtworks.domain.ValueHolder;

public interface ValueHolderInterface {
    void beforeValueHolder(ValueHolder<String> valueHolder);
    void afterValueHolder(ValueHolder<String> valueHolder);
    String afterReturningValueHolder(ValueHolder<String> valueHolder);
    void afterThrowingValueHolder(ValueHolder<String> valueHolder);
    void aroundValueHolder(ValueHolder<String> valueHolder);

}

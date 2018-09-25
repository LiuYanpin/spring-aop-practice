package com.thoughtworks.domain;

import org.springframework.stereotype.Repository;

@Repository
public class ValueHolder<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

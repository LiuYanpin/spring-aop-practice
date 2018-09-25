package com.thoughtworks.repository;

import com.thoughtworks.domain.ValueHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ValueHolderInterfaceImpl implements ValueHolderInterface {

    @Override
    public void beforeValueHolder(ValueHolder<String> valueHolder) {
        valueHolder.setValue(valueHolder.getValue() + "OverrideBefore ");
    }

    @Override
    public void afterValueHolder(ValueHolder<String> valueHolder) {
        valueHolder.setValue(valueHolder.getValue() + "OverrideAfter ");
    }

    @Override
    public String afterReturningValueHolder(ValueHolder<String> valueHolder) {
        valueHolder.setValue(valueHolder.getValue() + "OverrideAfterReturning ");
        return valueHolder.getValue();
    }

    @Override
    public void afterThrowingValueHolder(ValueHolder<String> valueHolder) {
        valueHolder.setValue(valueHolder.getValue() + "OverrideAfterThrowing ");
        throw new IllegalArgumentException();
    }

    @Override
    public void aroundValueHolder(ValueHolder<String> valueHolder) {
        valueHolder.setValue(valueHolder.getValue() + "OverrideAround ");
    }
}

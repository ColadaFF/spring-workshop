package co.ias.bootcamp.springworkshop.configuration.domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class ParameterKey {
    private final String value;

    public ParameterKey(String value) {
        Objects.requireNonNull(value, "Key can not be null");
        Validate.isTrue(StringUtils.isNotBlank(value), "Key can not be blank");
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

package co.ias.bootcamp.springworkshop.configuration.domain;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Parameter {
    public static class ParameterMapper implements RowMapper<Parameter> {

        @Override
        public Parameter mapRow(ResultSet resultSet, int i) throws SQLException {
            ParameterKey parameterKey = new ParameterKey(resultSet.getString("PARAM_KEY"));
            ParameterValue parameterValue = new ParameterValue(resultSet.getString("PARAM_VALUE"));
            return new Parameter(parameterKey, parameterValue);
        }
    }



    private final ParameterKey parameterKey;
    private final ParameterValue parameterValue;

    public Parameter(ParameterKey parameterKey, ParameterValue parameterValue) {
        this.parameterKey = Objects.requireNonNull(parameterKey, "parameter key can not be null");
        this.parameterValue = Objects.requireNonNull(parameterValue, "parameter value can not be null");
    }

    public String getParameterKey() {
        return parameterKey.getValue();
    }

    public String getParameterValue() {
        return parameterValue.getValue();
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "parameterKey=" + parameterKey +
                ", parameterValue=" + parameterValue +
                '}';
    }
}

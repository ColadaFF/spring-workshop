package co.ias.bootcamp.springworkshop.repositories;

import co.ias.bootcamp.springworkshop.configuration.domain.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ParameterRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParameterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Parameter getApplicationParameter(String parameterKey) {
        Optional<Parameter> parameter = jdbcTemplate.query("SELECT * FROM PARAMETERS WHERE PARAM_KEY = ?", new Object[]{parameterKey}, new Parameter.ParameterMapper())
                .stream()
                .findFirst();

        return parameter
                .orElseThrow(() -> new IllegalArgumentException("El parametro Cron no está configurado"));

    }
}

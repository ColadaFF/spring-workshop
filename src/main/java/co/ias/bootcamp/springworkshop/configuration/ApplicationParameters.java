package co.ias.bootcamp.springworkshop.configuration;

import co.ias.bootcamp.springworkshop.configuration.domain.Parameter;
import co.ias.bootcamp.springworkshop.repositories.ParameterRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

@Configuration
public class ApplicationParameters {


    @Bean
    @Qualifier("cron-parameter")
    @Profile({"dev"})
    public Parameter providesCronParameter(ParameterRepository repository) {
        return repository.getApplicationParameter("CRON-RATE");
    }


    @Bean("cron")
    @Qualifier("cron")
    public String providesCronParameterString(@Qualifier("cron-parameter") Parameter parameter) {
        return parameter.getParameterValue();
    }
}

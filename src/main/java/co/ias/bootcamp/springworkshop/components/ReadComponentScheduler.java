package co.ias.bootcamp.springworkshop.components;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ReadComponentScheduler {

    @Scheduled(cron = "#{cron}")
    public void schedulePrint() {
        System.out.println("Scheduled function");

    }
}

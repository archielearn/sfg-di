package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration
public class GreetingServiceConfig {

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){

        return new PrimaryGreetingService();
    }
    @Bean
    ConstructorGreetingService constructorGreetingService(){

        return new ConstructorGreetingService();
    }


    @Bean("i18nService")
    @Profile("EN")
    I18nEnglishGreetingService i18nEnglishGreetingService(){

        return new I18nEnglishGreetingService();
    }


    @Bean("i18nService")
    @Profile({"ES", "default"})
    I18nSpanishGreetingService i18nSpanishGreetingService(){

        return new I18nSpanishGreetingService();
    }

@Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){

        return new PropertyInjectedGreetingService();
}
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){

        return new SetterInjectedGreetingService();
    }

}

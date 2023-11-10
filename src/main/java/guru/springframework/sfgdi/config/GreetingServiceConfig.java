package guru.springframework.sfgdi.config;

<<<<<<< Updated upstream
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration
public class GreetingServiceConfig {

=======
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfg-di-xmlconfig.xml")
@Configuration
public class GreetingServiceConfig {

@Bean
PetServiceFactory petServiceFactory(){
    return new PetServiceFactory();
}
    @Bean
    @Profile({"dog","default"})
PetService dogPetService(PetServiceFactory petServiceFactory){
   return  petServiceFactory.getPetService("dog");
}


    @Bean
    @Profile("cat")

    PetService catPetService(PetServiceFactory petServiceFactory){
        return  petServiceFactory.getPetService("cat");
    }



>>>>>>> Stashed changes
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){

        return new PrimaryGreetingService();
    }
<<<<<<< Updated upstream
    @Bean
=======
    //@Bean
>>>>>>> Stashed changes
    ConstructorGreetingService constructorGreetingService(){

        return new ConstructorGreetingService();
    }
<<<<<<< Updated upstream


    @Bean("i18nService")
    @Profile("EN")
    I18nEnglishGreetingService i18nEnglishGreetingService(){

        return new I18nEnglishGreetingService();
=======
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl() ;
    }

    @Bean("i18nService")
    @Profile("EN")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){

        return new I18nEnglishGreetingService(englishGreetingRepository);
>>>>>>> Stashed changes
    }


    @Bean("i18nService")
    @Profile({"ES", "default"})
    I18nSpanishGreetingService i18nSpanishGreetingService(){

        return new I18nSpanishGreetingService();
    }

<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
@Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){

        return new PropertyInjectedGreetingService();
}
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){

        return new SetterInjectedGreetingService();
    }

}

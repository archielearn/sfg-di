package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfg-di-xmlconfig.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${archit.username}") String username,
                                  @Value("${archit.password}")String password,
                                  @Value("${archit.jdbcurl}")String jdbcurl){
FakeDataSource fakeDataSource=new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

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



    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){

        return new PrimaryGreetingService();
    }
    //@Bean
    ConstructorGreetingService constructorGreetingService(){

        return new ConstructorGreetingService();
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl() ;
    }

    @Bean("i18nService")
    @Profile("EN")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){

        return new I18nEnglishGreetingService(englishGreetingRepository);
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

package com.example.sem3HomeTask.configuration;

import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/*
Данный класс реализует паттерн Singleton
Класс реализует интерфейс UserRepository, который обеспечивает работу с данными о пользователях,
а также гарантирует, что Spring будет создавать только один экземпляр UserRepository.

 */
public class UserConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public UserRepository userRepository() {
        return new UserRepository();
    }
}

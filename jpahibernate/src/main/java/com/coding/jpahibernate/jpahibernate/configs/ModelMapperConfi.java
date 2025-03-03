package com.coding.jpahibernate.jpahibernate.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfi {
    @Bean
    public ModelMapper getmodelMapper() {
        return new ModelMapper();
    }
}

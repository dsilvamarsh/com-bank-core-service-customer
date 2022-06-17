package com.bank.core.service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
@EntityScan(basePackages = {"com.bank.core.service.model"})
@EnableJdbcRepositories(basePackages = {"com.bank.core.service.repository"})
@Configuration
public class Config {

}

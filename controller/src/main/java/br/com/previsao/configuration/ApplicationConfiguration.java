package br.com.previsao.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "br.com.previsao" })
@EntityScan(basePackages = { "br.com.previsao" })
@EnableJpaRepositories(basePackages = { "br.com.previsao" } )
@EnableTransactionManagement
public class ApplicationConfiguration {

}

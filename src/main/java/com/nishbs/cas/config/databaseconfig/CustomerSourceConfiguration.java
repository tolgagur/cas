package com.nishbs.cas.config.databaseconfig;


import com.nishbs.cas.model.customer.Customer;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@EnableJpaRepositories(basePackages = "com.nishbs.cas.repository.customer",
        entityManagerFactoryRef = "customerEntityManagerFactory",
        transactionManagerRef= "customerTransactionManager")
public class CustomerSourceConfiguration {

    @Bean
    @ConfigurationProperties("app.datasource.customer")
    public DataSourceProperties customerDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.customer.configuration")
    public DataSource customerDataSource() {
        return customerDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        HashMap<String,Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return builder
                .dataSource(customerDataSource())
                .packages(Customer.class)
                .properties(properties)
                .build();
    }

    @Bean
    public PlatformTransactionManager customerTransactionManager(
            final @Qualifier("customerEntityManagerFactory") LocalContainerEntityManagerFactoryBean customerEntityManagerFactory) {
        return new JpaTransactionManager(customerEntityManagerFactory.getObject());
    }
}

package com.nishbs.cas.config.databaseconfig;

import com.nishbs.cas.model.file.File;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.nishbs.cas.repository.file",
        entityManagerFactoryRef = "fileEntityManagerFactory",
        transactionManagerRef= "fileTransactionManager")
public class FileSourceConfiguration {


    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.file")
    public DataSourceProperties fileDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.file.configuration")
    public DataSource fileDataSource() {
        return fileDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Primary
    @Bean(name = "fileEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fileEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(fileDataSource())
                .packages(File.class)
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager fileTransactionManager(
            final @Qualifier("fileEntityManagerFactory") LocalContainerEntityManagerFactoryBean fileEntityManagerFactory) {
        return new JpaTransactionManager(fileEntityManagerFactory.getObject());
    }
}

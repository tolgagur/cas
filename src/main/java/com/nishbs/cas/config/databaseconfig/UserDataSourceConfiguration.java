package com.nishbs.cas.config.databaseconfig;


import com.nishbs.cas.model.user.RefreshToken;
import com.nishbs.cas.model.user.User;
import com.nishbs.cas.model.user.VerificationToken;
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

@Configuration
@EnableJpaRepositories(basePackages = "com.nishbs.cas.repository.user",
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef= "userTransactionManager")
public class UserDataSourceConfiguration {


    @Bean
    @ConfigurationProperties("app.datasource.user")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @ConfigurationProperties("app.datasource.user.configuration")
    public DataSource userDataSource() {
        return userDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }


    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(userDataSource())
                .packages(User.class)
                .packages(RefreshToken.class)
                .packages(VerificationToken.class)
                .build();
    }


    @Bean
    public PlatformTransactionManager userTransactionManager(
            final @Qualifier("userEntityManagerFactory") LocalContainerEntityManagerFactoryBean userEntityManagerFactory) {
        return new JpaTransactionManager(userEntityManagerFactory.getObject());
    }

}

package com.web.prog4td.Configuration.DatasourceConf;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.web.prog4td.Repository.cnaps",
        entityManagerFactoryRef = "EntityManagerFactoryCnaps",
        transactionManagerRef = "cnapsTransactionManager"
)
public class DatasourceCnapsConf {
    @Bean(name = "cnapsDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.cnaps")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "EntityManagerFactoryCnaps")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(
            EntityManagerFactoryBuilder builder,
            @Qualifier("cnapsDatasource") DataSource dataSource
    ) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return builder
                .dataSource(dataSource)
                .packages("com.web.prog4td.Model.entity.cnaps")
                .properties(properties)
                .persistenceUnit("db1")
                .build();
    }

    @Bean(name = "cnapsTransactionManager")
    public PlatformTransactionManager transactionManager1(
            @Qualifier("EntityManagerFactoryCnaps") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

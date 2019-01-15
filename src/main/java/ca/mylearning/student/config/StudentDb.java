package ca.mylearning.student.config;

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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "studentDBEntityManagerFactory",
        transactionManagerRef = "studentDBTransactionManager",
        basePackages={"ca.mylearning.student.repository"})
public class StudentDb {

    @Bean(name = "studentDataSource")
    @ConfigurationProperties(prefix="spring.datasource.student")
    public DataSource studentDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "studentDBEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean studentDBEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("studentDataSource") DataSource studentDataSource) {

        return builder
                .dataSource(studentDataSource)
                .packages("ca.mylearning.student.model")
                .persistenceUnit("student")
                .build();
    }


    @Bean(name = "studentDBTransactionManager")
    public PlatformTransactionManager studentDBTransactionManager(
            @Qualifier("studentDBEntityManagerFactory") EntityManagerFactory studentDBEntityManagerFactory) {

        return new JpaTransactionManager(studentDBEntityManagerFactory);
    }
}

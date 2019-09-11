package com.example.n1.configuration;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class AppCfg {

  @Bean
  public DriverManagerDataSource getDriverManagerDataSource(){
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("org.h2.Driver");
    driverManagerDataSource.setUrl("jdbc:h2:~/test");
    driverManagerDataSource.setUsername("ss");
    driverManagerDataSource.setPassword("");

    return driverManagerDataSource;
  }

  @Bean(name = "entityManagerFactory")
  @Autowired
  public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(
      DriverManagerDataSource source){
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(source);
    factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    Map<String,String> jpaProps = new HashMap<>();
    jpaProps.put("hibernate.show_sql","true");
    jpaProps.put("hibernate.hbm2ddl.auto","create");
    factoryBean.setJpaPropertyMap(jpaProps);

    factoryBean.setPackagesToScan("com.example.n1");

    return factoryBean;
  }

}

package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.app" })
@PropertySources({ @PropertySource(encoding = "UTF-8", value = "classpath:application.properties") })
public class AppConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/inventory");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	/*
	 * @Bean(name = "sessionFactory") public SessionFactory
	 * getSessionFactory(DataSource dataSource) { LocalSessionFactoryBuilder
	 * sessionBuilder = new LocalSessionFactoryBuilder(dataSource); //
	 * sessionBuilder.addAnnotatedClasses(User.class); return
	 * sessionBuilder.buildSessionFactory(); }
	 */

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		//sessionFactory.setAnnotatedPackages("com.app.entity");
		sessionFactory.setPackagesToScan("com.app.entity");
		
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;

	}

	private Properties getHibernateProperties() {
		System.out.println("getHibernateProperties()  - start");
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.generate_statistics", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		System.out.println("getHibernateProperties()  - end");
		return properties;
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}

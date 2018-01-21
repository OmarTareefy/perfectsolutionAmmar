package net.perfectsolution.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(
	    name = "props",
	    value = { "/WEB-INF/props/hibernateConfig.properties"})
@ComponentScan(basePackages = { "net.perfectsolution.backend.dto" })
@EnableTransactionManagement

public class HibernateConfig {
	// Database mysql properties

	@Value("${databaseUrl}")
	private String databaseUrl;
	@Value("${databaseDriver}")
	private String databaseDriver;
	@Value("${databaseDialect}")
	private String databaseDialect;
	@Value("${databaseUsername}")
	private String databaseUsername;
	@Value("${databasePassword}")
	private String databasePassword;
	@Value("${showSql}")
	private String showSql;
	@Value("${formatSql}")
	private String formatSql;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean("dataSource") // this name will match with the data-source-ref in spring-security.xml file
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		// Providing the database connection Information
		dataSource.setDriverClassName(databaseDriver);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);
		return dataSource;

	}

	// sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.perfectsolution.backend.dto");
		return builder.buildSessionFactory();

	}

	// All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", databaseDialect);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.format_sql", formatSql);
		// properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}

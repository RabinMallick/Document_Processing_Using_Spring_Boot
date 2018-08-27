package com.ude.sdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.ude.sdp" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.ude.sdp.repository" })
@EntityScan("com.ude.sdp.model")
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class SdpappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdpappApplication.class, args);
	}

}

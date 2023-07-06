package com.nttdata.msreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main class.
 */
@SpringBootApplication
@EnableEurekaClient
public class ReportsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReportsApplication.class, args);
  }

}

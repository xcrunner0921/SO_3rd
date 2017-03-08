package com.pineone.icbms.so.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SoSchedulerApplication {
	/**
	 * application main
	 * @param args
	 */
	public static void main(String[] args) {
//		SpringApplication.run(SoSchedulerApplication.class, args);
		SpringApplication app = new SpringApplication(SoSchedulerApplication.class);
		app.run(args);
	}
}

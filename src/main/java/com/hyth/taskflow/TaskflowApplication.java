package com.hyth.taskflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class TaskflowApplication {
	public static void main(String[] args) {
		loadEnv();

		ApplicationContext context = SpringApplication.run(TaskflowApplication.class, args);
	}

	private static void loadEnv() {
		Dotenv dotenv = Dotenv.configure()
			.ignoreIfMalformed()
			.ignoreIfMissing()
			.load();

		dotenv.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});
	}
}

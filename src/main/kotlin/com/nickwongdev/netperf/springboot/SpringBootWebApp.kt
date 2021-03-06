package com.nickwongdev.netperf.springboot

import com.nickwongdev.netperf.service.WorkService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {
	@Bean
	fun workService(): WorkService {
		return WorkService()
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args)
}

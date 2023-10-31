package com.kcook.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class KcookMenuApplication {
	public static void main(String[] args) {
		SpringApplication.run(KcookMenuApplication.class, args);
	}
}

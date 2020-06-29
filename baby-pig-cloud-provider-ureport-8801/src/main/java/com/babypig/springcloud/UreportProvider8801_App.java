package com.babypig.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
//@EnableDiscoveryClient //服务发现
//@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class UreportProvider8801_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(UreportProvider8801_App.class, args);
	}
}

package com.baby.pig.springboot.cloud;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.bstek.ureport.console.UReportServlet;
import com.bstek.ureport.definition.datasource.BuildinDatasource;
//不加项目能够启动但是会导致加载数据源报错或加载不了
//@ImportResource("classpath:ureport-console-context.xml")
@Configuration
public class UreportConfig implements BuildinDatasource {
	
	@Resource
    DataSource dataSource;
    private Logger log = LoggerFactory.getLogger(getClass());
    
    public String name() {
    	return "myUReportDatasource";
	}
    
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Bean
	public ServletRegistrationBean ureportServlet(){
		UReportServlet urlservlet = new UReportServlet();
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(urlservlet);
		srb.addUrlMappings("/ureport/*");
        return srb;
	}

 
}
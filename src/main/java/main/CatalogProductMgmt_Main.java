package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages ={"catalog_master_mgmt","compclass_mgmt","location_class_structure_mgmt","pricerange_mgmt","rating_mgmt","resource_class_structure_mgmt"})
@EnableJpaRepositories(basePackages ={ "catalog_master_mgmt","compclass_mgmt","location_class_structure_mgmt","pricerange_mgmt","rating_mgmt","resource_class_structure_mgmt"})
@ComponentScan(basePackages ={"catalog_master_mgmt","compclass_mgmt","location_class_structure_mgmt","pricerange_mgmt","rating_mgmt","resource_class_structure_mgmt"})
public class CatalogProductMgmt_Main extends SpringBootServletInitializer  
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CatalogProductMgmt_Main.class);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(CatalogProductMgmt_Main.class, args);
	}
	
}
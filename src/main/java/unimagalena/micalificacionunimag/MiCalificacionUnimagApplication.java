package unimagalena.micalificacionunimag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;




@SpringBootApplication
@EnableJpaRepositories
//@SecurityScheme(name = "techgeeknext-api", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
//@OpenAPIDefinition(info = @Info(title = "User API", version = "2.0", description = "User Details"))
public class MiCalificacionUnimagApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MiCalificacionUnimagApplication.class, args);
	}

}

package com.project.salsa_Modas_Manager;

import com.project.salsa_Modas_Manager.model.dto.Response.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class SalsaModasmanagerApplicationTests {

	@Test
	void contextLoads() {
		ProductResponse productResponse = new ProductResponse("cor","hamal",new BigDecimal("10.0"),"rosa",
				1L);

	}

}

package microtan65.pizza.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import microtan65.pizza.bean.Pizza;
import microtan65.pizza.repo.PizzaRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTest {

	@MockBean
	private PizzaRepo mockRepo;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getPizzaNotFound() {
		given(mockRepo.get("id")).willReturn(null);
		ResponseEntity<Pizza> result = restTemplate.exchange("/pizzas/id", HttpMethod.GET, null, Pizza.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getPizzaSuccess() {
		Pizza pizza = new Pizza("id", "name", 100, Arrays.asList("ing1", "ing2"));
		given(mockRepo.get("id")).willReturn(pizza);
		Pizza result = restTemplate.getForObject("/pizzas/id", Pizza.class);
		assertThat(result.getId()).isEqualTo(pizza.getId());
		assertThat(result.getName()).isEqualTo(pizza.getName());
		assertThat(result.getCost()).isEqualTo(pizza.getCost());
		assertThat(result.getIngredients()).isEqualTo(pizza.getIngredients());
	}
	
	// TODO all the other test cases..
}

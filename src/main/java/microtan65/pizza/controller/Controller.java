package microtan65.pizza.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import microtan65.pizza.bean.Pizza;
import microtan65.pizza.repo.PizzaRepo;

@RestController
public class Controller {
	@Autowired
	PizzaRepo pizzaRepo;

	@RequestMapping("/pizzas")
	public List<Pizza> getAllPizzas() {
		return pizzaRepo.getAll();
	}

	@RequestMapping("/pizzas/{id}")
	public ResponseEntity<?> getPizza(@PathVariable String id) {
		Pizza result = pizzaRepo.get(id);
		if (result != null) {
			return ResponseEntity.ok().body(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "/pizzas", method = RequestMethod.POST)
	public ResponseEntity<?> createPizza(@RequestBody Pizza input) {
		Pizza createdPizza = pizzaRepo.create(input);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPizza.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePizza(@PathVariable String id) {
		if (pizzaRepo.get(id) != null) {
			pizzaRepo.delete(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

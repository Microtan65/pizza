package microtan65.pizza.repo;

import java.util.List;

import microtan65.pizza.bean.Pizza;

public interface PizzaRepo {
	Pizza get(String id);
	List<Pizza> getAll();
	Pizza create(Pizza pizza);
	void delete(String id);
}

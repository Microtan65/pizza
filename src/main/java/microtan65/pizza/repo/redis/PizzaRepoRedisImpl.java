package microtan65.pizza.repo.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import microtan65.pizza.bean.Pizza;
import microtan65.pizza.repo.PizzaRepo;

@Repository
public class PizzaRepoRedisImpl implements PizzaRepo {
	private final String KEY = "pizza";

	@Autowired
	private RedisTemplate<String, Pizza> redisTemplate;

	private HashOperations hashOps;

	public PizzaRepoRedisImpl() {
	}

	@PostConstruct
	private void init() {
		hashOps = redisTemplate.opsForHash();
	}

	@Override
	public Pizza get(String id) {
		return (Pizza) hashOps.get(KEY, id);
	}

	@Override
	public List<Pizza> getAll() {
		return new ArrayList<Pizza>(hashOps.entries(KEY).values());
	}

	@Override
	public Pizza create(Pizza pizza) {
		Pizza createdPizza = new Pizza(UUID.randomUUID().toString(), pizza.getName(), pizza.getCost(), pizza.getIngredients());
		hashOps.put(KEY, createdPizza.getId(), createdPizza);
		return createdPizza;
	}

	@Override
	public void delete(String id) {
		hashOps.delete(KEY, id);
	}
}

package microtan65.pizza.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pizza {
	private final String id;
	private final String name;
	private final int cost;
	private final List<String> ingredients;
	
	@JsonCreator
	public Pizza(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("cost") int cost, @JsonProperty("ingredients") List<String> ingredients) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.ingredients = ingredients;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getCost() {
		return cost;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
}

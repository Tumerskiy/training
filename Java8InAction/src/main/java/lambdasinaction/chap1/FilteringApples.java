package lambdasinaction.chap1;

import java.util.*;
import java.util.function.Predicate;

public class FilteringApples{

	public static void main(String ... args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green", 100),
				new Apple(155, "green", 120),
				new Apple(120, "red", 200),
				new Apple(300, "white", 70),
				new Apple(400, "pink", 150),
				new Apple(500, "crazy", 200),
				new Apple(600, "mad", 400));	

		inventory.sort((Apple a1, Apple a2)-> a1.getColor().compareTo(a2.getColor()));
		
		System.out.println(inventory);

		List<Apple> tastyApples = filterApples(inventory, FilteringApples::isTastyApple);
		//System.out.println(tastyApples);

		List<Apple> maahApples = filterApples(inventory, (Apple a) -> (a.getColor().equals("mad")||a.getColor().equals("crazy"))&&(a.getTaste()>=200));
		//System.out.println(maahApples);

		//[Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
		//System.out.println(greenApples);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
		//System.out.println(heavyApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		//System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
		//System.out.println(heavyApples2);

		// []
		List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
				"brown".equals(a.getColor()));
		//System.out.println(weirdApples);
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for (Apple apple: inventory){
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterHeavyApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for (Apple apple: inventory){
			if (apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor()); 
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	public static boolean isTastyApple(Apple apple) {
		return apple.getTaste() > 100;
	}

	/**
	 * Check mad apples. Returns boolean based on name and taste.
	 * Every apple with name "mad" and taste over 300 is mad. 
	 * 
	 * @param apple some apple object for verification
	 * @return boolan if apple is mad
	 */
	public static boolean isMadApple(Apple apple) {
		return apple.getColor().equals("mad") && apple.getTaste()>300;
	}

	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}       

	/**
	 * Apple class blah blah blah
	 * @author etumhor
	 *
	 */
	public static class Apple {
		private int weight = 0;
		private String color = "";
		private int taste = 0;

		public int getTaste() {
			return taste;
		}

		public void setTaste(int taste) {
			this.taste = taste;
		}

		public Apple(int weight, String color, int taste){
			this.weight = weight;
			this.color = color;
			this.taste = taste;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}



		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}



		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					", taste=" + taste +
					'}';
		}
	}

}

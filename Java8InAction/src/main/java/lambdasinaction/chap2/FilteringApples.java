package lambdasinaction.chap2;

import java.util.*;

import javax.swing.text.DateFormatter;

public class FilteringApples{

	public static void main(String ... args){
		
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));	
		List<Apple> testout = filter(inventory, (Apple a1)-> a1.getColor()=="green"&&a1.getWeight()>100);
		
		
		List<Apple> testout1 = filter(inventory, new AppleGreenAndHeavyPredicate());
	
		//System.out.println(testout+"\n"+testout1);
		
		prettyPrintApple(inventory, new PPCW());
		
		prettyPrintApple(inventory, (Apple a)-> "not sure about "+a.getColor()+" apples");
		
		prettyPrintApple(inventory, (Apple a)-> "This "+a.getColor()+" apple, is "+(a.getWeight()>100 ? "heavy":"light") );
		
		
//		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//		List<Apple> greenApples = filterApplesByColor(inventory, "green");
//		System.out.println(greenApples);
//
//		// [Apple{color='red', weight=120}]
//		List<Apple> redApples = filterApplesByColor(inventory, "red");
//		System.out.println(redApples);
//
//		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
//		System.out.println(greenApples2);
//
//		// [Apple{color='green', weight=155}]
//		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
//		System.out.println(heavyApples);
//
//		// []
//		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
//		System.out.println(redAndHeavyApples);
//
//		// [Apple{color='red', weight=120}]
//		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
//			public boolean test(Apple a){
//				return a.getColor().equals("red"); 
//			}
//		});
//		System.out.println(redApples2);

	}
	public static void prettyPrintApple(List<Apple> inventory, PrettyPrintUO p){
	    for(Apple apple: inventory) {
		String output = p.print(apple);
		System.out.println(output);
	    }
	}
	interface PrettyPrintUO{
		public String print(Apple a);
	}
	
	static class PPCW implements PrettyPrintUO{
		public String print(Apple a) {
			String re = "An apple of "+a.getColor()+" color, with weight of "+a.getWeight();
			return re;
		}
	}
	
	

	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}


	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}       

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
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
					'}';
		}
	}

	interface ApplePredicate{
		public boolean test(Apple a);
	}
	static class AppleGreenAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple a) {
			return a.getColor().equals("green")&&a.getWeight()>100;
		}
	}

	static class AppleWeightPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return apple.getWeight() > 150; 
		}
	}
	static class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
}
package lambdasinaction.chap4;

import java.util.*;
import java.util.stream.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import static lambdasinaction.chap4.Dish.menu;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        //getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        //System.out.println("---");

        // Java 8
        //getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        
        //System.out.println(Dish.firstTwoMeatDishes);
        
        
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map((o1)-> o1*o1).collect(Collectors.toList());
        
        
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<String> numbers3 = numbers1.stream().map((o1)-> numbers2.stream().map((o2) -> "("+Integer.toString(o1)+","+Integer.toString(o2)+")").collect(Collectors.joining(", "))).collect(Collectors.toList());
        List<String> numbers4 = numbers1.stream().map((o1)-> numbers2.stream().filter((o2)-> (o1+o2)%3==0).map((o2) -> "("+Integer.toString(o1)+","+Integer.toString(o2)+")").collect(Collectors.joining(", "))).collect(Collectors.toList());
        System.out.println(numbers3);
        System.out.println(numbers4);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}

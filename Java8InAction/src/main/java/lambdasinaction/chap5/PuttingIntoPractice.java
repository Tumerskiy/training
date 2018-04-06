package lambdasinaction.chap5;

import lambdasinaction.chap5.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
		
        

		/**
		 * What are all the unique cities where the traders work?
			Find all traders from Cambridge and sort them by name.
			Return a string of all traders’ names sorted alphabetically.
			Are any traders based in Milan?
			Print all transactions’ values from the traders living in Cambridge.
			What's the highest value of all the transactions?
			Find the transaction with the smallest value.
		 */
//		List<Transaction> q0 = transactions.stream().filter((o1)-> o1.getYear()==2011).sorted(comparing(Transaction::getYear)).collect(Collectors.toList());
//		System.out.println(q0);
//		
//		List<String> q1 = transactions.stream().filter(o -> o.getTrader().getCity() == "Cambridge").map(o1->o1.getTrader().getName()).distinct().sorted().collect(toList());
//		System.out.println(q1);
//		
//		List<String> q2 = transactions.stream().map((o1) -> o1.getTrader().getCity()).distinct().collect(Collectors.toList());
//		System.out.println(q2);
//		
//		String q3 = transactions.stream().map((o1) -> o1.getTrader().getName()).sorted().distinct().collect(Collectors.joining(", "));
//		System.out.println(q3);
//		
//		Boolean q4 = transactions.stream().anyMatch((o1)->o1.getTrader().getCity()=="Milan");
//		System.out.println(q4);
//		
//		int q5 = transactions.stream().filter((a1)-> a1.getTrader().getCity()=="Cambridge").collect(Collectors.summingInt((o1)-> o1.getValue()));
//		System.out.println(q5);
//		
//		Optional<Integer> q6 = transactions.stream().map((o1)->o1.getValue()).collect(Collectors.maxBy((o1,o2)-> o1.compareTo(o2)));
//		
//		System.out.println(q6);
//		
//		Optional<Integer> q7 = transactions.stream().map((o1)->o1.getValue()).collect(Collectors.minBy((o1,o2)-> o1.compareTo(o2)));
//		System.out.println(q7);
//		
		
		/*
For each trader, return the number of lowercase letters in the name (hint: look at the chars method on String).

Find the city String with the largest number of lowercase letters from all the cities in the transaction list. 
Experiment with returning an Optional<String> to account for the case of an  empty input list.
		 */
		
//		List<String> q8 = transactions.stream().map(o1 -> o1.getTrader().getName()+" "+o1.getTrader().getName().chars().mapToObj(c -> (char) c).collect(Collectors.summingInt(o2-> Character.isLowerCase(o2) ? 1 : 0))).distinct().collect(toList());
//		System.out.println(q8);
//		String test = "qQqQqQqQ";
//		Integer test1 = test.chars().mapToObj(c -> (char) c).collect(Collectors.summingInt(o -> Character.isLowerCase(o) ? 1 : 0));
//		System.out.println(test1);
//		
//		
//		Optional<String> q9 = transactions.stream()
//											.max(comparing(o-> o.getTrader().getCity().chars()
//																			.mapToObj(c->(char) c)
//																			.collect(Collectors.summingInt(o2-> Character.isLowerCase(o2) ? 1 : 0))))
//											.map(o1 -> o1.getTrader().getCity());
//		System.out.println(q9);
		
		
		Stream.iterate(new int[]{0, 1}, i-> new int[]{i[1],i[1]+i[0]})
	      .limit(20)
	      .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
		
											
		
		
//        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
//        List<Transaction> tr2011 = transactions.stream()
//                                               .filter(transaction -> transaction.getYear() == 2011)
//                                               .sorted(comparing(Transaction::getValue))
//                                               .collect(toList());
//        System.out.println(tr2011);
//        
//        // Query 2: What are all the unique cities where the traders work?
//        List<String> cities = 
//            transactions.stream()
//                        .map(transaction -> transaction.getTrader().getCity())
//                        .distinct()
//                        .collect(toList());
//        System.out.println(cities);
//
//        // Query 3: Find all traders from Cambridge and sort them by name.
//        
//        List<Trader> traders = 
//            transactions.stream()
//                        .map(Transaction::getTrader)
//                        .filter(trader -> trader.getCity().equals("Cambridge"))
//                        .distinct()
//                        .sorted(comparing(Trader::getName))
//                        .collect(toList());
//        System.out.println(traders);
//        
//        
//        // Query 4: Return a string of all traders’ names sorted alphabetically.
//        
//        String traderStr = 
//            transactions.stream()
//                        .map(transaction -> transaction.getTrader().getName())
//                        .distinct()
//                        .sorted()
//                        .reduce("", (n1, n2) -> n1 + n2);
//        System.out.println(traderStr);
//        
//        // Query 5: Are there any trader based in Milan?
//        
//        boolean milanBased =
//            transactions.stream()
//                        .anyMatch(transaction -> transaction.getTrader()
//                                                            .getCity()
//                                                            .equals("Milan")
//                                 );
//        System.out.println(milanBased);
//        
//        
//        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
//        transactions.stream()
//                    .map(Transaction::getTrader)
//                    .filter(trader -> trader.getCity().equals("Milan"))
//                    .forEach(trader -> trader.setCity("Cambridge"));
//        System.out.println(transactions);
//        
//        
//        // Query 7: What's the highest value in all the transactions?
//        int highestValue = 
//            transactions.stream()
//                        .map(Transaction::getValue)
//                        .reduce(0, Integer::max);
//        System.out.println(highestValue);      
    }
}
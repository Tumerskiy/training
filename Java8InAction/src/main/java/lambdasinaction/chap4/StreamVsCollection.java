package lambdasinaction.chap4;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class StreamVsCollection {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream().sorted((o1,o2) -> (o1.compareTo(o2)));;
        //List<String> re = s.sorted((o1,o2) -> ((Integer) (o1.length())).compareTo((Integer) (o2.length()))).collect(Collectors.toList());
        
        s.forEach(System.out::println);
        
        //System.out.println(re);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);
    }

}
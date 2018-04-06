package lambdasinaction.chap5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class TestNumeric{
	@Test
    public void testPythagoreanTriples(){
		Stream<int[]> pythagoreanTriples =
	               IntStream.rangeClosed(1, 100).boxed()
	                        .flatMap(a -> IntStream.rangeClosed(a, 100)
	                                               .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
	                                               .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));       

    	assert pythagoreanTriples.allMatch(i->i[0]*i[0]+i[1]*i[1]==i[2]*i[2]);
    }
}
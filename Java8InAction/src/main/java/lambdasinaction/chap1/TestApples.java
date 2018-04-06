package lambdasinaction.chap1;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import lambdasinaction.chap1.FilteringApples.Apple;

public class TestApples {
	@Test
	public void testFilterApple() {
		Apple greeny = new Apple(155, "green", 40);
		Apple tasty = new Apple(155, "red", 140);
		List<Apple> inventory = Arrays.asList(new Apple(80,"green", 100),
                greeny,
                tasty
                );
		List<Apple> result = Arrays.asList(tasty);
		List<Apple> tastyApples = FilteringApples.filterApples(inventory, FilteringApples::isTastyApple);
		assertEquals(result,tastyApples);
		
	}
	@Test
	public void testGreen() {
		Apple greeny = new Apple(155, "pink", 120);
		greeny.setColor("green");
		Apple reddy = new Apple(155,"red",120);
		assertEquals(FilteringApples.isGreenApple(reddy),false);	        
		assertEquals(FilteringApples.isGreenApple(greeny),true);
	}
	
	@Test
	public void testHeavy() {
		Apple greeny = new Apple(155, "green", 120);
		Apple reddy = new Apple(200,"red",120);
		List<Apple> inventory = Arrays.asList(greeny,
											reddy);
		
		reddy.setWeight(40);
		List<Apple> list = FilteringApples.filterHeavyApples(inventory);
		List<Apple> result = Arrays.asList(greeny);
		assertEquals(FilteringApples.isHeavyApple(reddy),false);	        
		assertEquals(FilteringApples.isHeavyApple(greeny),true);
		assertEquals(result,list);
		
		
	}
	
	@Test
	public void testApples() {
		Apple some1 = new Apple(155, "green", 120);
		Apple some2 = new Apple(155,"green", 400);
		some1.setTaste(400);
		assertEquals(some1.toString(),some2.toString());
		some2.setColor("mad");
		some1.setTaste(50);
		some1.setColor("mad");
		assertEquals(FilteringApples.isMadApple(some1),false);
		some1.setTaste(500);
		some1.setColor("green");
		assertEquals(FilteringApples.isMadApple(some1),false);
		assertEquals(FilteringApples.isMadApple(some2),true);
		
		
	}

}

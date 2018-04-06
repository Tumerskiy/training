package lambdasinaction.chap11;

import java.util.concurrent.Future;

public class AsyncShopClient {

    public static void main(String[] args) {
        AsyncShop shop1 = new AsyncShop("BestShop1");
        AsyncShop shop2 = new AsyncShop("BestShop2");
        AsyncShop shop3 = new AsyncShop("BestShop3");
        AsyncShop shop4 = new AsyncShop("BestShop4");
        long start = System.nanoTime();
        Future<Double> futurePrice1 = shop1.getPrice("myPhone1");
        Future<Double> futurePrice2 = shop2.getPrice("myPhone2");
        Future<Double> futurePrice3 = shop3.getPrice("myPhone3");
        Future<Double> futurePrice4 = shop4.getPrice("myPhone4");
        
        long incocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + incocationTime + " msecs");
        
        try {
            System.out.println("Price is " + futurePrice.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrivalTime + " msecs");
    }
}
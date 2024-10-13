package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private static final int PRICE = 40;
    private static final int NUM = 5;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testStore() {
        Flower[] flowers = new Flower[3];
        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = new Flower();
        }
        flowers[0].setColor(FlowerColor.RED);
        flowers[0].setType(FlowerType.CHAMOMILE);
        flowers[1].setColor(FlowerColor.GREEN);
        flowers[1].setType(FlowerType.CHAMOMILE);
        flowers[2].setColor(FlowerColor.BLUE);
        flowers[2].setType(FlowerType.CHAMOMILE);
        Store store = new Store();
        for (int i = 0; i < flowers.length; i++) {
            store.addFlower(flowers[i]);
        }
        FlowerSpec spec = new FlowerSpec(FlowerType.CHAMOMILE, FlowerColor.RED);
        ArrayList<Flower> flowers1 = store.search(spec);
        Assertions.assertEquals(flowers1.size(), 1);
    }

    @Test
    public void testAdd() {
        Store store = new Store();
        for (int i = 0; i < 5; i++) {
            store.addFlower(new Flower());
        }
        Assertions.assertEquals(store.getFlowers().size(), 5);
    }

    @Test
    public void testSearch() {
        Flower[] flowers = new Flower[3];
        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = new Flower();
        }
        flowers[0].setColor(FlowerColor.RED);
        flowers[0].setType(FlowerType.CHAMOMILE);
        flowers[1].setColor(FlowerColor.GREEN);
        flowers[1].setType(FlowerType.CHAMOMILE);
        flowers[2].setColor(FlowerColor.BLUE);
        flowers[2].setType(FlowerType.CHAMOMILE);
        Store store = new Store();
        for (int i = 0; i < flowers.length; i++) {
            store.addFlower(flowers[i]);
        }
        FlowerSpec spec = new FlowerSpec(FlowerType.ROSE, FlowerColor.RED);
        ArrayList<Flower> flowers1 = store.search(spec);
        Assertions.assertEquals(flowers1.size(), 0);
    }

    @Test
    public void testBucket() {
        Flower flower1 = new Flower();
        flower1.setType(FlowerType.ROSE);
        flower1.setColor(FlowerColor.RED);
        flower1.setPrice(MAX_PRICE);
        Flower flower2 = new Flower();
        flower2.setType(FlowerType.CHAMOMILE);
        flower2.setColor(FlowerColor.GREEN);
        flower2.setPrice(PRICE);
        FlowerPack flowerPack1 = new FlowerPack(flower1, NUM);
        FlowerPack flowerPack2 = new FlowerPack(flower2, NUM);
        ArrayList<FlowerPack> flowerPacks = new ArrayList<>();
        flowerPacks.add(flowerPack1);
        flowerPacks.add(flowerPack2);
        FlowerBucket bucket = new FlowerBucket(flowerPacks);
        Assertions.assertEquals(bucket.getPrice(), (PRICE + MAX_PRICE) * NUM);
    }

    @Test
    public void testPack() {
        Flower flower = new Flower();
        flower.setType(FlowerType.ROSE);
        flower.setColor(FlowerColor.RED);
        flower.setPrice(MAX_PRICE);
        int num = NUM;
        FlowerPack pack = new FlowerPack(flower, num);
        Assertions.assertEquals(pack.getPrice(), MAX_PRICE * num);
    }
}
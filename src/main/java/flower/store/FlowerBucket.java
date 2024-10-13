package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    private List<FlowerPack> flowers;
    public FlowerBucket() {
        flowers = new ArrayList<FlowerPack>();
    }
    public FlowerBucket(ArrayList<FlowerPack> flowers) {
        this.flowers = flowers;
    }
    public double getPrice() {
        double sum = 0;
        for (FlowerPack flower : flowers) {
            sum += flower.getPrice();
        }
        return sum;
    }
    public void add(FlowerPack flower) {
        flowers.add(new FlowerPack(flower));
    }
}

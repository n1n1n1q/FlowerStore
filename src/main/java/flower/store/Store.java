package flower.store;

import lombok.Getter;

import java.util.ArrayList;

public class Store {
    @Getter
    private ArrayList<Flower> flowers;
    public Store() {
        flowers = new ArrayList<>();
    }
    public void addFlower(Flower flower) {
        flowers.add(flower);
    }
    public ArrayList<Flower> search(FlowerSpec spec) {
        ArrayList<Flower> res = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getSpec().matches(spec)) {
                res.add(flower);
            }
        }
        return res;
    }
}

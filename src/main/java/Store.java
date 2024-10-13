import flower.store.Flower;
import flower.store.FlowerSpec;

import java.util.ArrayList;

public class Store {
    private ArrayList<Flower> flowers;
    public Store() {
        flowers = new ArrayList<>();
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

package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class FlowerPack {
    private Flower flowers;
    private int numFlowers = 0;
    public FlowerPack(FlowerPack anotherPack) {
        flowers = new Flower(anotherPack.flowers);
        numFlowers = anotherPack.numFlowers;
    }
    public double getPrice() {
        return flowers.getPrice() * numFlowers;
    }
}

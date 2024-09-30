package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
public class FlowerPack {
    private Flower flowers;
    private int numFlowers = 0;
    public FlowerPack() {}
    public FlowerPack(Flower flower, int amount) {
        flowers = new Flower(flower);
        numFlowers = amount;
    }
    public FlowerPack(FlowerPack anotherPack) {
        flowers = new Flower(anotherPack.flowers);
        numFlowers = anotherPack.numFlowers;
    }
    public double getPrice() {
        return flowers.getPrice() * numFlowers;
    }
}

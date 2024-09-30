package flower.store;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Flower {
    private FlowerColor color;
    private int sepalLength;
    private double price;
    private FlowerType type;

    public String getColor(){
        return color.toString();
    }
    public Flower(Flower flower){
        color = flower.color;
        sepalLength = flower.sepalLength;
        price = flower.price;
        type = flower.type;
    }
    public Flower(){
        sepalLength = 0;
        price = 0;
    }
}

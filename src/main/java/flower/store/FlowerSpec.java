package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FlowerSpec {
    private FlowerType type;
    private FlowerColor color;

    public Boolean matches(FlowerSpec spec) {
        return type.equals(spec.type) && color.equals(spec.color);
    }
}

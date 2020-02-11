package World;

import gfx.assets;

public class water extends square{
    public water(int index) {
        super(assets.water, index);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }
}

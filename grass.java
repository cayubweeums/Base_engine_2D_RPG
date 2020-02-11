package World;

import gfx.assets;

public class grass extends square{

    public grass(int index) {
        super(assets.grass, index);

    }

    @Override
    public boolean isWalkable() {
        return true;
    }

}

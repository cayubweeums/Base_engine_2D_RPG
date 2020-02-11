package World;

import gfx.assets;

public class house extends square{

    public house(int index) {
        super(assets.house, index);

    }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isSpawnPoint(){return false;}

}

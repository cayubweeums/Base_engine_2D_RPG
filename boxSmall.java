package World;

import gfx.assets;

public class boxSmall extends square{

    public boxSmall(int index) {
        super(assets.boxSmall, index);

    }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isSpawnPoint(){return true;}

}

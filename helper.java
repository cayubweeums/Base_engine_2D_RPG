package Main;

import Input.keyInput;
import World.map;
import gfx.playerView;

import javax.net.ssl.KeyManager;

public class helper {

    private mainGame mainG;
    private map map;

    public helper(mainGame mainG){
        this.mainG = mainG;
    }

    // TODO get and set methods
    public playerView getPlayerView(){
        return mainG.getPlayerView();
    }

    public keyInput getKeyInput(){
        return mainG.getKeyInput();
    }

    public int getW(){
        return mainG.w;
    }

    public int getH(){
        return mainG.h;
    }

    public mainGame getMainG() {
        return mainG;
    }

    public World.map getMap() {
        return map;
    }

    public void setMainG(mainGame mainG) {
        this.mainG = mainG;
    }

    public void setMap(World.map map) {
        this.map = map;
    }
}

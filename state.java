package States;

import Main.helper;
import Main.mainGame;

import java.awt.*;


public abstract class state {

    protected Main.helper helper1;

    public state(helper helper1){
        this.helper1 = helper1;
    }

    public abstract void update();

    public abstract void draw(Graphics g);


}

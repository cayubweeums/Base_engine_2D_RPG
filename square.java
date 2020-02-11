package World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class square {

    public static square[] squares = new square[10];
    public static square grass = new grass(0);
    public static square water = new water(1);
    public static square boxSmall = new boxSmall(2);
    public static square house = new house(3);

    public static final int SQUARE_W = 32;
    public static final int SQUARE_H = 32;

    protected BufferedImage b;
    public final int index;

    public square(BufferedImage b, int index){
        this.b = b;
        this.index = index;
        squares[index] = this;
    }

    public int getIndex(){
        return index;
    }

    public void update(){

    }

    public void draw(Graphics g, int x, int y){

        g.drawImage(b, x, y, SQUARE_W, SQUARE_H, null);

    }

    public boolean isWalkable(){
        return false;
    }

    public boolean isSpawnPoint(){return false;}

}

package gfx;

import java.awt.image.BufferedImage;

public class sprite {

    private BufferedImage spreadSheet;

    public sprite(BufferedImage spreadSheet){
        this.spreadSheet = spreadSheet;
    }

    public BufferedImage steal(int x, int y, int w, int h){
        return spreadSheet.getSubimage(x, y, w, h);
    }

}

package gfx;

import Entity.entity;
import Main.mainGame;

public class playerView {

    private float xOff;
    private float yOff;
    private mainGame mainG;

    public playerView(mainGame mainG, float xOff, float yOff){
        this.mainG = mainG;

        this.xOff = xOff;
        this.yOff = yOff;

    }

    public void lockPlayerView(entity e){
        xOff = e.getX() - mainG.w / 2 + e.getW() / 2;
        yOff = e.getY() - mainG.h /2 + e.getH() / 2;
    }

    public void translate(float xAdd, float yAdd){
        this.xOff += xAdd;
        this.yOff += yAdd;

    }

    public float getxOff() {
        return xOff;
    }

    public float getyOff() {
        return yOff;
    }

    public void setxOff(float xOff) {
        this.xOff = xOff;
    }

    public void setyOff(float yOff) {
        this.yOff = yOff;
    }

}

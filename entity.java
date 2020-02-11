package Entity;

import Main.helper;
import Main.mainGame;

import java.awt.*;

public abstract class entity {

    protected float x = 0;
    protected float y = 0;
    protected int w = 0;
    protected int h = 0;
    protected Rectangle edges;
    protected helper helper;


    public entity(helper helper, float x, float y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.helper = helper;
        edges = new Rectangle(0, 0, w, h);

    }

    public void removeAll(){
        for(entity e : helper.getMap().getEntityHelper().getObjects()) {
            helper.getMap().getEntityHelper().remove(e);
        }
    }


    public boolean checkCollide(float xOff, float yOff){
        for(entity e : helper.getMap().getEntityHelper().getObjects()){
            if(e.equals(this)){
                continue;
            }
            if(e.getEdges(0f,0f).intersects(getEdges(xOff, yOff))){
                return true;
            }
        }
        return false;
    }

    public Rectangle getEdges(float xOff, float yOff){
        return new Rectangle((int) (x + edges.x + xOff), (int) (y + edges.y + yOff), edges.width, edges.height);
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

}

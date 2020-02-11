package Entity;

import Main.helper;
import Main.mainGame;
import World.map;
import World.square;

import java.awt.*;

public abstract class characters extends entity {

    protected static final int DEFAULT_HP = 10;
    protected static final float DEFAULT_V = 3.0f;
    protected static final int DEFAULT_CHARACTER_W = 32;
    protected static final int DEFAULT_CHARACTER_H = 56;


    protected int hp;
    protected float velocity;
    protected float xMove;
    protected float yMove;

    private Graphics g;
    private entityHelper entityHelper;
    private entity entity;

    public characters(Main.helper helper, float x, float y, int w, int h) {
        super(helper, x, y, w, h);
        // pull this out to be set in a separate method
        hp = DEFAULT_HP;
        velocity = DEFAULT_V;
        xMove = 0;
        yMove = 0;
    }

    public void movement(){
        if(!checkCollide(xMove, 0f)) {
            xMove();
//        }else{
//            entity.removeAll();
//        }
        }
        if(!checkCollide(0f, yMove)) {
            yMove();
//        }else{
//            entity.removeAll();
//        }
        }
    }

    public void xMove(){

//        x += xMove;

        //direction right
        if(xMove > 0){
            int dx = (int) (x + xMove + edges.x + edges.width) / square.SQUARE_W;

            if(collideSquare(dx, (int) (y + edges.y) / square.SQUARE_H) &&
                collideSquare(dx, (int) (y + edges.y + edges.height) / square.SQUARE_H)){
                x += xMove;
            }
            //TODO if colliding with spawn point spawn enemy
//            if(doesSpawn(dx, (int) (y + edges.y) / square.SQUARE_H) &&
//                    doesSpawn(dx, (int) (y + edges.y + edges.height) / square.SQUARE_H)){
//                TODO draw enemy close to the player


//                enemy = new enemy(helper, x + 10, y + 10, DEFAULT_CHARACTER_W, DEFAULT_CHARACTER_H);
//                enemy.draw(g);

         //moving left
        }else{
            int dx = (int) (x + xMove + edges.x) / square.SQUARE_W;

            if(collideSquare(dx, (int) (y + edges.y) / square.SQUARE_H) &&
                    collideSquare(dx, (int) (y + edges.y + edges.height) / square.SQUARE_H)){
                x += xMove;
            }
            //TODO if colliding with spawn point spawn enemy
//            if(doesSpawn(dx, (int) (y + edges.y) / square.SQUARE_H) &&
//                    doesSpawn(dx, (int) (y + edges.y + edges.height) / square.SQUARE_H)){
//                TODO draw enemy close to the player


//                enemy = new enemy(helper, x + 10, y + 10, DEFAULT_CHARACTER_W, DEFAULT_CHARACTER_H);
//                enemy.draw(g);

        }
    }

    public void yMove() {
        if (yMove < 0) {
            int dy = (int) (y + yMove + edges.y) / square.SQUARE_H;
            if (collideSquare((int) (x + edges.x) / square.SQUARE_W, dy) &&
                    collideSquare((int) (x + edges.x + edges.width) / square.SQUARE_W, dy)) {
                y += yMove;
            }
            //TODO if colliding with spawn point spawn enemy
//            if (doesSpawn((int) (x + edges.x) / square.SQUARE_W, dy) &&
//                    doesSpawn((int) (x + edges.x + edges.width) / square.SQUARE_W, dy)) {
//                TODO draw enemy close to the player


//                enemy = new enemy(helper, x + 10, y + 10, DEFAULT_CHARACTER_W, DEFAULT_CHARACTER_H);
//                enemy.draw(g);
        } else {
            int dy = (int) (y + yMove + edges.y + edges.height) / square.SQUARE_H;
            if (collideSquare((int) (x + edges.x) / square.SQUARE_W, dy) &&
                    collideSquare((int) (x + edges.x + edges.width) / square.SQUARE_W, dy)) {
                y += yMove;
            }
            //TODO if colliding with spawn point spawn enemy
//            if (doesSpawn((int) (x + edges.x) / square.SQUARE_W, dy) &&
//                    doesSpawn((int) (x + edges.x + edges.width) / square.SQUARE_W, dy)) {
//                TODO draw enemy close to the player


//                enemy = new enemy(helper, x + 10, y + 10, DEFAULT_CHARACTER_W, DEFAULT_CHARACTER_H);
//                enemy.draw(g);
        }
    }



    protected boolean collideSquare(int x, int y) {
        return helper.getMap().getSquare(x, y).isWalkable();
    }

    protected boolean doesSpawn(int x, int y){
        return helper.getMap().getSquare(x, y).isSpawnPoint();
    }


    // TODO get set methods
    public int getHp() {
        return hp;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setVelocity(float velocity){
        this.velocity = velocity;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}

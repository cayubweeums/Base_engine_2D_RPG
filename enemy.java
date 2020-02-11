package Entity;

import Main.helper;
import gfx.assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.Random;

public class enemy extends staticEntity {
    private Hashtable<Integer, String> hashtable;
    private Random rand;
    private Image randomEnemy = randomEnemy();


    public enemy(Main.helper helper, float x, float y, int w, int h) {
        super(helper, x, y, characters.DEFAULT_CHARACTER_W, characters.DEFAULT_CHARACTER_H);
    }

    public Image randomEnemy(){
        rand = new Random();
        hashtable = new Hashtable<>();
        Image returnAsset = null;



        hashtable.put(3, "enemy1");
        hashtable.put(2, "enemy2");
        hashtable.put(1, "enemy3");

        int max = 3;
        int min = 1;
        int diff = max - min;
        Random rn = new Random();
        int i = rn.nextInt(diff + 1);
        i += min;

        if(hashtable.get(i).equals(validEnemies.enemy1)){
            returnAsset = assets.enemy1;
        }else if(hashtable.get(i).equals(validEnemies.enemy2)){
            returnAsset = assets.enemy2;
        }else{
            returnAsset = assets.enemy3;
        }

        return returnAsset;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(randomEnemy,(int) (x - helper.getPlayerView().getxOff()),(int) (y - helper.getPlayerView().getyOff()),w,h,null);
    }


//    public enemy(Main.helper helper, float x, float y, int w, int h) {
//        super(helper, x, y, w, h);
//
//        edges.x = 0;
//        edges.y = 10;
//        edges.width = 28;
//        edges.height = 30;
//
//    }
//
//    @Override
//    public void setxMove(float xMove) {
//        super.setxMove(0);
//    }
//
//    @Override
//    public void setyMove(float yMove) {
//        super.setyMove(0);
//    }
//
//    @Override
//    public void update() {
//
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        g.drawImage(assets.enemy1,(int) x,(int) y, w, h,null);
//
//
//    }
}

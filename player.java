package Entity;

import java.awt.*;

import Main.helper;
import Main.mainGame;
import gfx.assets;

public class player extends characters {


    public player(Main.helper helper, float x, float y) {
        super(helper, x, y, characters.DEFAULT_CHARACTER_W, characters.DEFAULT_CHARACTER_H);

        //custom entity hit box for specific demo character model
        edges.x = 0;
        edges.y = 10;
        edges.width = 28;
        edges.height = 30;

    }

    @Override
    public void update() {

        getKeyInput();
        movement();
        helper.getPlayerView().lockPlayerView(this);

//        if(game.getKeyInput().up){
//            y -= 3;
//        }else if(game.getKeyInput().down){
//            y += 3;
//        }else if(game.getKeyInput().left){
//            x -= 3;
//        }else if(game.getKeyInput().right){
//            x += 3;
//        }
    }



    @Override
    public void draw(Graphics g) {
        //TODO drawing the character to the screen
        g.drawImage(assets.character,(int) (x - helper.getPlayerView().getxOff()),(int) (y - helper.getPlayerView().getyOff()),w,h,null);

        // TODO drawing obvious hit box for testing
//        g.setColor(Color.red);
//        g.fillRect((int) (x + edges.x - helper.getPlayerView().getxOff()),(int) (y + edges.y
//                    - helper.getPlayerView().getyOff()), edges.width, edges.height);


    }

    public void getKeyInput(){
        xMove = 0;
        yMove = 0;

        if(helper.getKeyInput().up) {
            yMove = -velocity;
        }else if(helper.getKeyInput().down) {
            yMove = velocity;
        }else if(helper.getKeyInput().left) {
            xMove = -velocity;
        }else if(helper.getKeyInput().right) {
            xMove = velocity;
        }else if(helper.getKeyInput().spawn) {
            helper.getMap().spawnEnemy();
        }
    }
}

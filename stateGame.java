package States;

import java.awt.*;

import Entity.enemy;
import Entity.player;
import Main.helper;
import Main.mainGame;
import World.map;
import World.square;
import gfx.assets;

public class stateGame extends state{
//    private  Entity.enemy enemy;

//    private Entity.player player;
    private World.map map;

    public stateGame(helper helper){
        super(helper);

        map = new map("resources/maps/world", helper);
        helper.setMap(map);


//        player = new player(helper,250,350);


//        enemy = new enemy(helper, 200, 300, 32, 24);

//        map = new map("resources/maps/world", game);


    }

    @Override
    public void update() {
        map.update();
//        player.update();

    }

    @Override
    public void draw(Graphics g) {
//        test code
//        square.squares[0].draw(g,0,0);
        map.draw(g);
//        player.draw(g);


//        enemy.draw(g);
//        g.drawImage(assets.character,0,0,assets.characterWidth, assets.characterHeight,null);
    }
}

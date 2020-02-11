package Entity;

import Main.helper;

import java.awt.*;
import java.util.ArrayList;

public class entityHelper {

    private Main.helper helper;
    private player player;
    private ArrayList<entity> objects;

    public entityHelper(helper helper, player player){
        this.helper = helper;
        this.player = player;
        objects = new ArrayList<entity>();
        add(player);
    }

    public void add(entity e){
        objects.add(e);
    }

    public void remove(entity e){
        objects.removeIf(ent -> ent == e);
    }

    public void update(){
        for(int i = 0; i < objects.size(); i++){
            entity e = objects.get(i);
            e.update();
        }
//        player.update();

    }

    public void draw(Graphics g){
        for(entity e : objects){
            e.draw(g);
        }
//        player.draw(g);

    }

    public Entity.player getPlayer() {
        return player;
    }

    public ArrayList<entity> getObjects() {
        return objects;
    }
}

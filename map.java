package World;

import Entity.enemy;
import Entity.entityHelper;
import Entity.player;
import Main.helper;

import java.awt.*;

public class map {

    private helper helper;
    private int w;
    private int h;
    private int[][] mapLocal;
//    private Hashtable<Integer, Integer> mapLocal;
    private int xSpawn;
    private int ySpawn;
    private Entity.entityHelper entityHelper;


    public map(String fileLocal, helper helper){
        this.helper = helper;
        entityHelper = new entityHelper(helper, new player(helper,250,350));
        load(fileLocal);

        entityHelper.getPlayer().setX(xSpawn);
        entityHelper.getPlayer().setY(ySpawn);
    }

    public void spawnEnemy(){
        entityHelper.add(new enemy(helper, helper.getPlayerView().getxOff() + 50,helper.getPlayerView().getyOff() + 50, 29,30));
    }

    public void update(){

        entityHelper.update();

    }

    public void draw(Graphics g){
        int xS = (int) Math.max(0, helper.getPlayerView().getxOff() / square.SQUARE_W);
        int xE = (int) Math.min(w, (helper.getPlayerView().getxOff() + helper.getW()) / square.SQUARE_W + 1);
        int yS = (int) Math.max(0, helper.getPlayerView().getyOff() / square.SQUARE_H);
        int yE = (int) Math.min(h, (helper.getPlayerView().getyOff() + helper.getH()) / square.SQUARE_H + 1);


        for(int y = yS; y < yE; y++){
            for(int x = xS; x < xE; x++){
                getSquare(x, y).draw(g, (int) (x * square.SQUARE_W - helper.getPlayerView().getxOff()),
                        (int) (y * square.SQUARE_H - helper.getPlayerView().getyOff()));
            }
        }
        entityHelper.draw(g);
    }

    public square getSquare(int x, int y){

        if(x < 0 || y < 0 || x >= w || y >= h){
            return square.grass;
        }

        square s = square.squares[mapLocal[x][y]];
        if(s == null){
            return square.grass;
        }
        return s;
    }

    public Entity.entityHelper getEntityHelper() {
        return entityHelper;
    }


    private void load(String fileLocal){
        String mapFile = usefulMethods.loadMap(fileLocal);
        String[] nums = mapFile.split("\\s+");

        w = usefulMethods.parseInt(nums[0]);
        h = usefulMethods.parseInt(nums[1]);
        xSpawn = usefulMethods.parseInt(nums[2]);
        ySpawn = usefulMethods.parseInt(nums[3]);

        mapLocal = new int[w][h];
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                int i = x + y;
                mapLocal[x][y] = usefulMethods.parseInt(nums[(x+y * w) + 4]);
            }
        }
    }




    //implement has maps here instead of a double indexed array

}

package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class assets {

    public static final int worldWidth = 16;
    public static final int worldHeight = 16;

    public static final int characterWidth = 16;
    public static final int characterHeight = 28;

    public static final int enemy1Width = 12;
    public static final int enemy1Height = 16;

    public static final int enemy2Width = 15;
    public static final int enemy2Height = 16;

    public static final int enemy3Width = 29;
    public static final int enemy3Height = 30;

    public static BufferedImage character;
    public static BufferedImage enemy1;
    public static BufferedImage enemy2;
    public static BufferedImage enemy3;
    public static BufferedImage grass;
    public static BufferedImage water;
    public static BufferedImage boxSmall;
    public static BufferedImage house;


    public static void init() throws IOException {
        sprite worldSheet = new sprite(load.loadPic("/textures/Overworld.png"));
        sprite playerSheet = new sprite(load.loadPic("/textures/character.png"));
        sprite enemySheet = new sprite(load.loadPic("/textures/rpgcritter update formatted transparent.png"));


        character = playerSheet.steal(1,6,characterWidth,characterHeight);
        enemy1 = enemySheet.steal(97, 15, enemy1Width, enemy1Height);
        enemy2 = enemySheet.steal(144, 15, enemy2Width, enemy2Height);
        enemy3 = enemySheet.steal(1, 64, enemy3Width, enemy3Height);
        grass = worldSheet.steal(0,0,worldWidth,worldHeight);
        water = worldSheet.steal(0,16,worldWidth,worldHeight);
        boxSmall = worldSheet.steal(480,3,worldWidth,worldHeight);
        house = worldSheet.steal(99, 0, 73, 79);


    }

}

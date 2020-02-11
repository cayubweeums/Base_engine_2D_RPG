package Main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import Input.keyInput;
import States.state;
import States.*;
import gfx.playerView;

public class mainGame implements Runnable{

    private GUI scene;
    private Input.keyInput keyInput;
    private gfx.playerView playerView;
    private helper helper;

    public String t;
    public int w;
    public int h;

    private Thread mainThread;

    private boolean running = false;

    //Pre-rendered frames
    private BufferStrategy bs;
    private Graphics g;

    public state nowState;
    public state stateGame;



    public mainGame(String t, int w, int h){
        this.t = t;
        this.w = w;
        this.h = h;
        keyInput = new keyInput();
    }

    public synchronized void start(){
        if(!running){
            running = true;
            mainThread = new Thread(this);
            mainThread.start();
        }
        return;
    }

    public synchronized void stop() throws InterruptedException {
        if(!running){
            return;
        }
        running = false;
        mainThread.join();
    }

    @Override
    public void run() {

        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int fps = 60;

        // TODO fps count delete when finished
        long timer = 0;
        int updates = 0;
        // TODO fps count delete when finished

        //Standard tick allocated variables
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while(running){

            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                update();
                draw();
                updates ++;
                delta --;
            }
            if(timer >= 1000000000){
                System.out.println("FPS = " + updates);
                updates = 0;
                timer = 0;
            }

        }
        try {
            stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void init() throws IOException {
        scene = new GUI(t,w,h);
        scene.getFrame().addKeyListener(keyInput);
        gfx.assets.init();
        playerView = new playerView(this, 0, 0);
        helper = new helper(this);

        stateGame = new stateGame(helper);
        nowState = stateGame;
        stateMethods.setState(nowState);
    }

    private void update(){
        keyInput.update();

        if(stateMethods.getCurrentState() != null){
            stateMethods.getCurrentState().update();
        }
    }

    private void draw(){

        bs = scene.getSceneMain().getBufferStrategy();
        if(bs == null){
            scene.getSceneMain().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear screen
        g.clearRect(0,0,w,h);
        //draw

        if(stateMethods.getCurrentState() != null){
            stateMethods.getCurrentState().draw(g);
        }

        //end draw
        bs.show();
        g.dispose();
    }

    public keyInput getKeyInput(){
        return keyInput;
    }

    public gfx.playerView getPlayerView() {
        return playerView;
    }


}




// have cahracter move aoround like 2d map. when endmy comes up have it pop up scene builder window and do
// combat on the scene builder window and return the results back to the main game loop.

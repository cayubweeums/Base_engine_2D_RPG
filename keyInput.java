package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyInput implements KeyListener {

    private boolean[] inputs;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean spawn;

    public keyInput(){
        inputs = new boolean[256];
    }

    public void update(){
        up = inputs[KeyEvent.VK_W];
        down = inputs[KeyEvent.VK_S];
        left = inputs[KeyEvent.VK_A];
        right = inputs[KeyEvent.VK_D];
        spawn = inputs[KeyEvent.VK_1];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        inputs[keyEvent.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        inputs[keyEvent.getKeyCode()] = false;

    }
}

package Main;

import Main.GUI;
import Main.mainGame;
import States.*;

public class mainWindow extends GUI {

    public mainWindow(String t, int w, int h) {
        super(t, w, h);
    }

    public static void main(String[] args) {
        menu newMen = new menu();
        newMen.main(args);
    }

}

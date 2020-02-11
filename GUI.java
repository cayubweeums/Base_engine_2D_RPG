package Main;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private String t;
    public int w;
    public int h;

    private Canvas sceneMain = new Canvas();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public int getScreenHeight() {
        return screenSize.height;
    }

    public int getScreenWidth() {
        return screenSize.width;
    }

    public GUI(String t, int w, int h) {
        setLayout(new BorderLayout());
        setSize(w, h);
        setTitle(t);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(getScreenWidth() / 4,getScreenHeight() / 4);
        setVisible(true);

        sceneMain.setPreferredSize(new Dimension(w,h));
        sceneMain.setMaximumSize(new Dimension(w,h));
        sceneMain.setMinimumSize(new Dimension(w,h));
        sceneMain.setFocusable(false);


        add(sceneMain);
        pack();
    }

    public Canvas getSceneMain(){
        return sceneMain;
    }

    public JFrame getFrame(){
        return this;
    }

//    public void setFrame(String t, int w, int h) {
//        this.t = t;
//        this.w = w;
//        this.h = h;
//
//    }
}

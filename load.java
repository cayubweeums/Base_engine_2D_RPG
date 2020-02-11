package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class load {

    public static BufferedImage loadPic(String location) throws IOException {
        return ImageIO.read(load.class.getResource(location));
    }
}

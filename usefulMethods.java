package World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class usefulMethods {
    public static String loadMap(String fileLocal){
        StringBuilder sB = new StringBuilder();

        try{
            BufferedReader bR = new BufferedReader(new FileReader(fileLocal));
            String line;
            while((line = bR.readLine()) != null){
                sB.append(line).append("\n");
            }
            bR.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return sB.toString();
    }

    public static int parseInt(String num){
        try{
            return Integer.parseInt(num);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

}

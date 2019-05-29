


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.apache.commons.net.util.Base64;


public abstract class ImageProcess {
    

    
    //Gets File Path & Returns BASE64 String Value
    
    public static String toImageString(String path) throws FileNotFoundException, IOException {
   
        String imageString = "";
        try {
            File f = new File(path);
            try (FileInputStream fis = new FileInputStream(f)) {
                byte byteArray[] = new byte[(int) f.length()];
                fis.read(byteArray);
                imageString = Base64.encodeBase64String(byteArray);
                fis.close();
            }
        } catch (IOException iOException) {
            
            return "";
        }
        
        
        return imageString;
    }
    
    //Returns A BufferedImage from BASE64 String.
    
    public static BufferedImage toBufferedImage(String imgString) throws IOException {
        
        BufferedImage bufferedImage = null;
        try {
            byte[] byteArray = Base64.decodeBase64(imgString);
            
            try (InputStream in = new ByteArrayInputStream(byteArray)) {
                bufferedImage = ImageIO.read(in);
            }
            
        } catch (IOException iOException) {
            
            return null;
        }
        
        return bufferedImage;
    }
    
  
}
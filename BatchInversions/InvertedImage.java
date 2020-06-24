
/**
 * Write a description of InvertedImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class InvertedImage {

    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels())
        {
            Pixel inP = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255 - inP.getRed());
            pixel.setGreen(255 - inP.getGreen());
            pixel.setBlue(255 - inP.getBlue());
        }
        return outImage;
    }
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource i = new ImageResource(f);
            String fname = i.getFileName();
            i = makeGray(i);
            String newName = "inverted-" + fname;
            i.setFileName(newName);
            i.draw();
            i.save();
        }
    }
}

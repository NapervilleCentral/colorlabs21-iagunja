
/**
 * Uses loops to make color changes to an unchanged original picture
 * 
 * @author (Imaan Gunja) 
 * @version (11-10-2025)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class ColorLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
          /**/
         String fileName = FileChooser.pickAFile();
         Picture pictObj = new Picture(fileName);
         pictObj.explore();
         
         //relative path
         Picture opic = new Picture("images\\beach.jpg");
         //change with selfie picture
         Picture pic1 = new Picture("images/beach.jpg");
         Picture pic2 = new Picture("images/beach.jpg");
         Picture pic3 = new Picture("images/beach.jpg");
         Picture pic4 = new Picture("images/beach.jpg");
         
         opic.explore();
         
         Pixel[] beachPixels;
         beachPixels = pic1.getPixels();
         
         //CHANGE GREEN
         int changeGreen;
         for (Pixel spot1 : beachPixels) {
             changeGreen = spot1.getGreen();
             changeGreen = (int)(changeGreen * 1.5);
             spot1.setGreen(changeGreen);
         }
         pic1.explore();
         
         //NEGATE
         
         //GRAYSCALE
         int aRed, aBlue, aGreen, avgColor;
         for (Pixel spot1 : beachPixels) {
             aRed = spot1.getRed();
             aBlue = spot1.getBlue();
             aGreen = spot1.getGreen();
             
             avgColor = ((aRed + aBlue + aGreen) / 3);

         }
    }//main       
}//class

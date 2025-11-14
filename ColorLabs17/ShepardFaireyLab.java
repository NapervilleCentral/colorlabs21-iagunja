
 
/**
 * Changes colors and shading of a picture of myself in order to reach the optimal color
 * picture and coolest looking shading
 * Shepard Fairey Lab
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class ShepardFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
         //relative path
         Picture opic = new Picture("images\\imaan.jpg");
         //change with selfie picture
         Picture meGray = new Picture("images/imaan.jpg");
         Picture me1 = new Picture("images/imaan.jpg");
         Picture me2 = new Picture("images/imaan.jpg");
         
         opic.explore();
         
         //GRAYSCALE
         Pixel[] mePixelsGray;
         mePixelsGray = meGray.getPixels();
         
         int gRed, gBlue, gGreen, avgColor;
         for (Pixel spot1 : mePixelsGray) {
             gRed = spot1.getRed();
             gBlue = spot1.getBlue();
             gGreen = spot1.getGreen();
             
             avgColor = (int)((gRed + gBlue + gGreen) / 3);
             
             Color gray = new Color(avgColor, avgColor, avgColor);
             
             spot1.setColor(gray);
         }
         meGray.explore();
         
         /**
          * method 1 change
          * 
          */
         
         Pixel[] mePixels1;
         mePixels1 = me1.getPixels();
         
         int sRed;
         for (Pixel spot1 : mePixels1) {
             sRed = spot1.getRed();
             
             Color darkBlue = new Color(0, 76, 153);//dark blue
             Color red = new Color(204, 0, 0);//red
             Color lightBlue = new Color(204, 229, 255);//light blue
             Color offWhite = new Color(230, 220, 199);//off white
             
             if (sRed >= 0 && sRed <= 63) {
                 spot1.setColor(darkBlue);
             }
             if (sRed > 63 && sRed <= 127) {
                 spot1.setColor(red);
             }
             if (sRed > 127 && sRed <= 191) {
                 spot1.setColor(lightBlue);
             }
             if (sRed > 191 && sRed <= 255) {
                 spot1.setColor(offWhite);
             }
         }
         me1.explore();
         
         /**
          * method 2 change
          * 
          */
         
         Pixel[] mePixels2;
         mePixels2 = me2.getPixels();
         
         /**
          * custom color palette
          */

         
    }//main       
}//class

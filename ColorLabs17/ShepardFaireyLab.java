
 
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
         Picture me3 = new Picture("images/imaan.jpg");
         
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
         meGray.write("images/imaanGray.jpg");
         meGray.explore();
         
         /**
          * method 1 change
          * 
          */
         
         Pixel[] mePixels1;
         mePixels1 = me1.getPixels();
         
         int sRed, sBlue, sGreen, avg1;
         for (Pixel spot1 : mePixels1) {
             sRed = spot1.getRed();
             sBlue = spot1.getBlue();
             sGreen = spot1.getGreen();
             avg1 = (sRed + sBlue + sGreen) / 3;
             
             Color gray1 = new Color(avg1, avg1, avg1);
             
             spot1.setColor(gray1);
             
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
         
         int s = 255;
         int b = 0;
         int sRed2, sBlue2, sGreen2, avg2;
         for (Pixel spot1 : mePixels2) {
             sRed2 = spot1.getRed();
             sBlue2 = spot1.getBlue();
             sGreen2 = spot1.getGreen();
             avg2 = (sRed2 + sBlue2 + sGreen2) / 3;
             
             Color gray2 = new Color(avg2, avg2, avg2);
             
             spot1.setColor(gray2);
         
             if (spot1.getRed() < s) {
                 s = spot1.getRed();
             }
             if (spot1.getRed() > b) {
                 b = spot1.getRed();
             }
         }//main   
         
         double interval = (double)(b - s) / 4.0;
         
         Color darkBlue = new Color(0, 76, 153);//dark blue
         Color red = new Color(204, 0, 0);//red
         Color lightBlue = new Color(204, 229, 255);//light blue
         Color offWhite = new Color(230, 220, 199);//off white
         
         int grayVal;
         
         for (Pixel spot1 : mePixels2) {
             grayVal = spot1.getRed();
             
             if (grayVal >= s && grayVal < s + interval) {
                 spot1.setColor(darkBlue);
             }
             if (grayVal >= s + interval && grayVal < s + 2 * interval) {
                 spot1.setColor(red);
             }
             if (grayVal >= s + 2 * interval && grayVal < s + 3 * interval) {
                 spot1.setColor(lightBlue);
             }
             if (grayVal >= s + 3 * interval && grayVal < s + 4 * interval) {
                 spot1.setColor(offWhite);
             }
         }
         me2.explore();
         
         /**
             * custom color palette
         */
        
         Pixel[] mePixels3;
         mePixels3 = me3.getPixels();
         
         int sRed3, sBlue3, sGreen3, avg3;
         for (Pixel spot1 : mePixels3) {
             sRed3 = spot1.getRed();
             sBlue3 = spot1.getBlue();
             sGreen3 = spot1.getGreen();
             avg3 = (sRed3 + sBlue3 + sGreen3) / 3;
             
             Color gray3 = new Color(avg3, avg3, avg3);
             
             spot1.setColor(gray3);
             
             Color pink = new Color(255, 226, 241);//light pink
             Color yellow = new Color(255, 253, 205);//light yellow
             Color blue = new Color(207, 241, 252);//light blue
             Color cream = new Color(255, 255, 243);//cream
             
             if (sRed3 >= 0 && sRed3 <= 63) {
                 spot1.setColor(pink);
             }
             if (sRed3 > 63 && sRed3 <= 127) {
                 spot1.setColor(cream);
             }
             if (sRed3 > 127 && sRed3 <= 191) {
                 spot1.setColor(blue);
             }
             if (sRed3 > 191 && sRed3 <= 255) {
                 spot1.setColor(yellow);
             }
         }
         me3.explore();
         me3.write("images/SFtryFinal.jpg");
    }//class
}

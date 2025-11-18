
 
/**
 * Changes colors and shading of a picture of myself in order to reach the optimal color
 * picture and coolest looking shading
 * Shepard Fairey Lab
 * @author (Imaan Gunja) 
 * @version (11/14/2025)
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
         
         //intializes the red, blue, and green variables to be made gray
         //creates a variable for the number of the average color (to make gray)
         int gRed, gBlue, gGreen, avgColor;
         for (Pixel spot1 : mePixelsGray) {
             //gets the red, blue, and green values at each pixel
             gRed = spot1.getRed();
             gBlue = spot1.getBlue();
             gGreen = spot1.getGreen();
             
             //finds the value for the average grayscale value
             avgColor = (int)((gRed + gBlue + gGreen) / 3);
             
             //creates a new color as gray
             Color gray = new Color(avgColor, avgColor, avgColor);
             
             //sets all of the pixels in the image to the newly created gray color
             spot1.setColor(gray);
         }
         //writes the grayscale image to the images folder
         meGray.write("images/imaanGray.jpg");
         //displays the grayscaled picture
         meGray.explore();
         
         /**
          * method 1 change
          * 
          */
         
         //accesses the pixels in the first copy of my picture
         Pixel[] mePixels1;
         mePixels1 = me1.getPixels();
         
         //intializes variables for grayscaling
         int sRed, sBlue, sGreen, avg1;
         //runs for each pixel in the first copy of my picture
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
             
             //makes the pixel dark blue if its grayscale value is between 0 and 63
             if (sRed >= 0 && sRed <= 63) {
                 spot1.setColor(darkBlue);
             }
             //makes the pixel red if its grayscale value is between 63 and 127
             if (sRed > 63 && sRed <= 127) {
                 spot1.setColor(red);
             }
             //makes the pixel light blue if its grayscale value is between 127 and 191
             if (sRed > 127 && sRed <= 191) {
                 spot1.setColor(lightBlue);
             }
             //makes the pixel off white if its grayscale value is between 191 and 255
             if (sRed > 191 && sRed <= 255) {
                 spot1.setColor(offWhite);
             }
         }
         //prints the method 1 version of my picture
         me1.explore();
         
         /**
          * method 2 change
          * 
          */
         
         //accesses the pixels in the second copy of my picture
         Pixel[] mePixels2;
         mePixels2 = me2.getPixels();
         
         //intitializes variables for the min and max values for the pixels
         int s = 255;
         int b = 0;
         //intializes red, blue, green, and average variables for grayscaling
         int sRed2, sBlue2, sGreen2, avg2;
         //runs for each pixel in the second copy of my picture
         for (Pixel spot1 : mePixels2) {
             sRed2 = spot1.getRed();
             sBlue2 = spot1.getBlue();
             sGreen2 = spot1.getGreen();
             avg2 = (sRed2 + sBlue2 + sGreen2) / 3;
             
             Color gray2 = new Color(avg2, avg2, avg2);
             
             spot1.setColor(gray2);
             
             //makes the checked pixel's value the max value if it less than 255
             //replaces as necessary when the loop runs again
             if (spot1.getRed() < s) {
                 s = spot1.getRed();
             }
             //makes the checked pixel's value the min value if it is more than 0
             //replaces as necessary when the loop runs again
             if (spot1.getRed() > b) {
                 b = spot1.getRed();
             }
         }//main   
         
         //creates 4 equal sized intervals where every value is greater than 0 and less than 255
         double interval = (double)(b - s) / 4.0;
         
         Color darkBlue = new Color(0, 76, 153);//dark blue
         Color red = new Color(204, 0, 0);//red
         Color lightBlue = new Color(204, 229, 255);//light blue
         Color offWhite = new Color(230, 220, 199);//off white
         
         //initializes a variable to check the grayscale values
         int grayVal;
         //runs for each pixel in the second copy of my picture
         for (Pixel spot1 : mePixels2) {
             grayVal = spot1.getRed();
             
             //changes the color of the pixels depending on what range their grayscale values fall into
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
         //displays the copy of my picture with the method 2 requirements
         me2.explore();
         
         /**
             * custom color palette (pink, yellow, blue, cream)
         */
         
         //accesses the pixels in the third copy of my picture
         Pixel[] mePixels3;
         mePixels3 = me3.getPixels();
         
         //intializes red, blue, green, and average variables to be grayscaled
         int sRed3, sBlue3, sGreen3, avg3;
         //runs for each pixel in the third copy of my picture
         for (Pixel spot1 : mePixels3) {
             sRed3 = spot1.getRed();
             sBlue3 = spot1.getBlue();
             sGreen3 = spot1.getGreen();
             avg3 = (sRed3 + sBlue3 + sGreen3) / 3;
             
             Color gray3 = new Color(avg3, avg3, avg3);
             
             spot1.setColor(gray3);
             
             //creates my own color scheme and pattern
             Color pink = new Color(255, 226, 241);//light pink
             Color yellow = new Color(255, 253, 205);//light yellow
             Color blue = new Color(207, 241, 252);//light blue
             Color cream = new Color(255, 255, 243);//cream
             
             //makes each pixel the respective colors based on which range their grayscale value falls into
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
         //displays the third copy of my picture with the changed colors
         me3.explore();
         //writes this third copy of my picture with the changed colors to the images folder to be saved and compared to my other attempts
         me3.write("images/SFtryFinal.jpg");
    }//class
}

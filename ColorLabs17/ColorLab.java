
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
         Picture pic5 = new Picture("images/beach.jpg");
         Picture pic6 = new Picture("images/beach.jpg");
         
         opic.explore();
         
         //CHANGE GREEN
         Pixel[] bPixels1;
         bPixels1 = pic1.getPixels();
         
         int changeGreen;
         for (Pixel spot1 : bPixels1) {
             changeGreen = spot1.getGreen();
             changeGreen = (int)(changeGreen * 1.5);
             spot1.setGreen(changeGreen);
         }
         pic1.explore();
         
         //GRAYSCALE
         Pixel[] bPixels2;
         bPixels2 = pic2.getPixels();
         
         int aRed, aBlue, aGreen, avgColor;
         for (Pixel spot1 : bPixels2) {
             aRed = spot1.getRed();
             aBlue = spot1.getBlue();
             aGreen = spot1.getGreen();
             
             avgColor = (int)((aRed + aBlue + aGreen) / 3);
             int gRed = avgColor;
             int gBlue = avgColor;
             int gGreen = avgColor;

             Color gray = new Color(gRed, gBlue, gGreen);
             
             spot1.setColor(gray);
         }
         pic2.explore();
         
         //NEGATE
         Pixel[] bPixels3;
         bPixels3 = pic3.getPixels();
         
         int pRed, pBlue, pGreen;
         for (Pixel spot1 : bPixels3) {
             pRed = spot1.getRed();
             pBlue = spot1.getBlue();
             pGreen = spot1.getGreen();
             
             int nRed = 255 - pRed;
             int nBlue = 255 - pBlue;
             int nGreen = 255 - pGreen;
             
             Color negColor = new Color(nRed, nBlue, nGreen);
             
             spot1.setColor(negColor);
         }
         pic3.explore();
         
         //DARKEN
         Pixel[] bPixels4;
         bPixels4 = pic4.getPixels();
         
         int NRed, NBlue, NGreen;
         for (Pixel spot1 : bPixels4) {
             NRed = spot1.getRed();
             NBlue = spot1.getBlue();
             NGreen = spot1.getGreen();
             
             int dRed = (int)(NRed / 2);
             int dBlue = (int)(NBlue / 2);
             int dGreen = (int)(NGreen / 2);
             
             Color darkColor = new Color(dRed, dBlue, dGreen);
             
             spot1.setColor(darkColor);
         }
         pic4.explore();
         
         //CHANGE OBJECT COLOR
         Pixel[] bPixels5;
         bPixels5 = pic5.getPixels();
         
         int changeSky;
         for (Pixel spot1 : bPixels5) {
             
         }
    }//main       
}//class

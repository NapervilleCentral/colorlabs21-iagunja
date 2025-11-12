
/**
 * Write a description of class SheparFaireyLab here.
 * 
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
         Picture opic = new Picture("images\\jenny-red.jpg");
         //change with selfie picture
         Picture meGray = new Picture("images/jenny-red.jpg");
         Picture me1 = new Picture("images/jenny-red.jpg");
         Picture me2 = new Picture("images/jenny-red.jpg");
         
         opic.explore();
         
         /**
          * method 1 change
          * 
          */
         
         Pixel[] mePixelsGray;
         mePixelsGray = meGray.getPixels();
         
         /**
          * method 2 change
          * 
          */
         
         /**
          * custom color palette
          */

         
    }//main       
}//class

import java.awt.*;
import java.util.*;
import java.util.List;

/**
* Write a description of class PosterProjectMain here.
* 1 Copyed orginal
* 2 Mirror
*
* @author (Imaan Gunja)
* @version (Poster Project Main)
*/
public class PosterProjectMain
{
    public static void main(String[] args)
    {
        Picture apic = new Picture("images\\docMcStuffinsSIZED.jpg");
        Picture canvas = new Picture("images\\Canvas1.jpg");
        Picture temple = new Picture("images\\temple.jpg");
        //makes an array of pixels--GIVEN YOU NEED THIS
        Pixel[] pixels;
        //gets pixels from picture and assigns to pixels array
        pixels = apic.getPixels();//GET ALL THE PIXELS
        for (Pixel spot : pixels)
        {
            //System.out.println( spot );
            spot.setRed((int)(spot.getRed() *.1));
        }
        apic.explore();//method - does something
        copyToCanvas(apic,canvas);
        canvas.explore();
        
        temple.explore();
        mirrorTemple(temple);
        temple.explore();
    }
    
    /**
    * copy from source to target
    * position of int x, y for placement on the target
    */
    public static void copyToCanvas(Picture sourcePic, Picture targetPic)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        //width of the source must be <= to the canvas I am
        //going to copy to
        for (int sourceX = 0, targetX = 100; sourceX<sourcePic.getWidth(); sourceX++, targetX ++)
        {
            for (int sourceY = 0, targetY = 100; sourceY<sourcePic.getHeight(); sourceY++, targetY ++)
            {
                //set the target pix color of the source pix
                sourcePix = sourcePic.getPixel(sourceX,sourceY);
                targetPix = targetPic.getPixel(targetX,targetY);
                targetPix.setColor(sourcePix.getColor());
            }//loop
        }//loop
    }//end of copyKatie
    
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int y = 0; y < 159; y++)
        {
            for (int x = 0; x < source.getWidth(); x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(width - 1 - x, y);
                
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
}

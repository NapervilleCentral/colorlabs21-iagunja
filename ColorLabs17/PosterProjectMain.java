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
        Picture original = new Picture("images\\docMcStuffinsSIZED.jpg");
        Picture canvas = new Picture("images\\Canvas1.jpg");
        Picture temple = new Picture("images\\temple.jpg");
        
        copyToCanvasCollage(original, canvas, 0, 0);
        
        Picture gray = new Picture("images\\docMcStuffinsSIZED.jpg");
        grayscale(gray);
        copyToCanvasCollage(gray, canvas, 667, 0);
        
        Picture sepia = new Picture("images\\docMcStuffinsSIZED.jpg");
        sepiaTint(sepia);
        copyToCanvasCollage(sepia, canvas, 1333, 0);
        
        Picture negated = new Picture("images\\docMcStuffinsSIZED.jpg");
        negate(negated);
        copyToCanvasCollage(negated, canvas, 0, 500);
        
        Picture recursive = new Picture("images\\docMcStuffinsSIZED.jpg");
        recurse(recursive, 0, 0, 667, 500);
        copyToCanvasCollage(recursive, canvas, 667, 500);
        
        Picture mirrored = new Picture("images\\docMcStuffinsSIZED.jpg");
        mirror(mirrored);
        copyToCanvasCollage(mirrored, canvas, 1333, 500);
        
        //makes an array of pixels--GIVEN YOU NEED THIS
        Pixel[] pixels;
        //gets pixels from picture and assigns to pixels array
        pixels = original.getPixels();//GET ALL THE PIXELS
        for (Pixel spot : pixels)
        {
            //System.out.println( spot );
            spot.setRed((int)(spot.getRed() *.1));
        }
        
        canvas.explore();
        /*original.explore();//method - does something
        copyToCanvas(original, canvas);
        canvas.explore();
        
        temple.explore();
        mirrorVertical(temple);
        temple.explore();*/
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
        for (int sourceX = 0, targetX = 100; sourceX < sourcePic.getWidth(); sourceX++, targetX ++)
        {
            for (int sourceY = 0, targetY = 100; sourceY < sourcePic.getHeight(); sourceY++, targetY ++)
            {
                //set the target pix color of the source pix
                sourcePix = sourcePic.getPixel(sourceX,sourceY);
                targetPix = targetPic.getPixel(targetX,targetY);
                targetPix.setColor(sourcePix.getColor());
            }//loop
        }//loop
    }//end of copyToCanvas
    
    /**
    * copy from source to target
    * position of int x, y for placement on the target
    */
    public static void copyToCanvasCollage(Picture sourcePic, Picture targetPic, int x, int y)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        //width of the source must be <= to the canvas I am
        //going to copy to
        for (int sourceX = 0, targetX = 0; sourceX < sourcePic.getWidth(); sourceX++, targetX ++)
        {
            for (int sourceY = 0, targetY = 0; sourceY < sourcePic.getHeight(); sourceY++, targetY ++)
            {
                //set the target pix color of the source pix
                sourcePix = sourcePic.getPixel(sourceX,sourceY);
                targetPix = targetPic.getPixel(targetX + x,targetY + y);
                targetPix.setColor(sourcePix.getColor());
            }//loop
        }//loop
    }//end of copyToCanvas
    
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
    
    public static void grayscale(Picture source)
    {
        Pixel[] pixels = source.getPixels();
        
        for (Pixel p : pixels)
        {
            int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
            
            p.setRed(avg);
            p.setGreen(avg);
            p.setBlue(avg);
        }
    }
    
    public static void sepiaTint(Picture source)
    {
        grayscale(source);
        
        Pixel[] pixels = source.getPixels();
        
        for (Pixel p : pixels)
        {
            int red = p.getRed();
            int green = p.getGreen();
            int blue = p.getBlue();
            
            if (red < 60)
            {
                red = (int)(red * 0.9);
                green = (int)(green * 0.9);
                blue = (int)(blue * 0.9);
            }
            else if (red < 190)
            {
                red = (int)(red * 1.2);
                green = (int)(green * 1.1);
                blue = (int)(blue * 0.8);
            }
            else
            {
                red = (int)(red * 1.1);
                green = (int)(green * 1.05);
                blue = (int)(blue * 0.9);
            }
            
            p.setRed(limitColor(red));
            p.setGreen(limitColor(green));
            p.setBlue(limitColor(blue));
        }
    }
    
    public static void negate(Picture source)
    {
        Pixel[] pixels = source.getPixels();
        
        for (Pixel p : pixels)
        {
            p.setRed(255 - p.getRed());
            p.setGreen(255 - p.getGreen());
            p.setBlue(255 - p.getBlue());
        }
    }
    
    public static void recurse(Picture source, int x, int y, int w, int h)
    {
        if (w < 20 || h < 20)
        {
            return;
        }
        
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
            Pixel sourcePix = source.getPixel((int)(col * (source.getWidth() / (double)w)),(int)(row * (source.getHeight() / (double)h)));
            source.getPixel(x + col, y + row).setColor(sourcePix.getColor());
            }
        }
        recurse(source, x + 10, y + 10, w / 2, h / 2);
    }
    
    public static void posterize(Picture source, int levels)
    {
        Pixel[] pixels = source.getPixels();
        
        int step = 256 / levels;
        
        for (Pixel p : pixels)
        {
            int red = (p.getRed() / step) * step;
            int green = (p.getGreen() / step) * step;
            int blue = (p.getBlue() / step) * step;
            
            p.setRed(limitColor(red));
            p.setGreen(limitColor(green));
            p.setBlue(limitColor(blue));
        }
    }
    
    public static void mirror(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width / 2;
        
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int y = 0; y < source.getHeight(); y++)
        {
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(width - 1 - x, y);
                
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    public static int limitColor(int value)
    {
        if (value < 0)
        {
            return 0;
        }
        else if (value > 255)
        {
            return 255;
        }
        else
        {
            return value;
        }
    }
}

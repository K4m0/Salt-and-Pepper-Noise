import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
@SuppressWarnings("unused")
public class Main  {
	
	static BufferedImage image2;
	 static File f = null;
	public static void main(String[] args) {
		try
		{
			//Se carga la imagen
			BufferedImage image1 = ImageIO.read(new File("/Users/jpulidom/workspace/RuidoS&P/src/Images/Homero.jpg"));
			int width = image1.getWidth();
			int height = image1.getHeight();
			
			//Se convierte a Blanco y Negro
			for(int i=0; i<height; i++){
		         
	            for(int j=0; j<width; j++){
	            
	               Color c = new Color(image1.getRGB(j, i));
	               int red = (int)(c.getRed() * 0.299);
	               int green = (int)(c.getGreen() * 0.587);
	               int blue = (int)(c.getBlue() *0.114);
	               int rgb = range(red+green+blue,8);
	               Color newColor = new Color(rgb,rgb,rgb);
	               
	               image1.setRGB(j,i,newColor.getRGB());
	            }
	         }
			
			try{
			      f = new File("/Users/jpulidom/workspace/RuidoS&P/src/Images/saved.jpg");
			      ImageIO.write(image1, "jpg", f);
			    }catch(IOException e){
			      System.out.println(e);
			    }

		}
		catch(IOException e)
		{
			System.out.print("No");
		}		
		
	}
	
	public static int range(int n, double prob) {
		double res = ((100 * prob)/10);
		
		int[]array = new int[(int)res];
		array[0]= 1;
		array[1]=255;
		
		for (int i = 2 ; i <= res - 2; i++)
		{
			array[i] = n;
		}
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}
	
}

	


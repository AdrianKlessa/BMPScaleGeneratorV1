package bitmapGenerator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {

		if(args.length!=2) {
			//Too few arguments
			System.out.println("ERROR: Wrong argument count. Please provide a letter associated with one of the RGB components and an integer in the range <0;255> seperated by a space");
		}else {
			//Assigning the arguments to a variable
			String fixedComponent= args[0];
			Integer fixedValue = Integer.parseInt(args[1]);
			System.out.println(fixedComponent);
			System.out.println(fixedValue);
			
			//Checking the first argument
			if((!fixedComponent.equals("R"))&&(!fixedComponent.equals("G"))&&(!fixedComponent.equals("B"))) {
				System.out.println("The first argument is wrong. Please provide either 'R' 'G' or 'B'");
				
			}else if(fixedValue<0||fixedValue>255) {  //Checking the second argument
				System.out.println("The second argument is wrong. Please provide an integer between 0 and 255 (inclusive)");
			}else {
				//Everything seems ok
				//Printing the arguments for testing purposes
				System.out.println(fixedComponent);
				System.out.println(fixedValue);
				
				//Creating a new buffered image and color data holders
				BufferedImage theImage = new BufferedImage(256,256, BufferedImage.TYPE_3BYTE_BGR);
				Color currentColor;
				int rgbValue;
				if(fixedComponent.equals("R")) {
					for(int x=0; x<256; x++) {
						for(int y=0; y<256; y++) {
							currentColor = new Color(fixedValue,x,y);
							rgbValue=currentColor.getRGB();
							theImage.setRGB(x, y, rgbValue);
						}
					}
				}else if(fixedComponent.equals("G")) {
					for(int x=0; x<256; x++) {
						for(int y=0; y<256; y++) {
							currentColor = new Color(x,fixedValue,y);
							rgbValue=currentColor.getRGB();
							theImage.setRGB(x, y, rgbValue);
						}
					}
					
				
				}else if(fixedComponent.equals("B")) {
					for(int x=0; x<256; x++) {
						for(int y=0; y<256; y++) {
							currentColor = new Color(x,y,fixedValue);
							rgbValue=currentColor.getRGB();
							theImage.setRGB(x, y, rgbValue);
						}
					}
				}
				
				//Created the image, now's the time to save it
				File output = new File("output.bmp");
				try {
					ImageIO.write(theImage,"bmp", output);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}

}

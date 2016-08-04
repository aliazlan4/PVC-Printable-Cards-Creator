import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws IOException {
		int xPos[] = {99, 3259, 99, 3259, 99, 3259, 99, 3259};
		int yPos[] = {559, 559, 2769, 2769, 4952, 4952, 7096, 7096};
		
		BufferedImage image = new BufferedImage(6320,9354, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect ( 0, 0, image.getWidth(), image.getHeight() );
		
		File[] allFiles = new File("cards").listFiles();
		
		for(int i=0; i < allFiles.length; i++){
			if(i != 0 && i%8 == 0){
				ImageIO.write(image,"JPG",new File("printables/" + (i/8) + ".jpg"));
				g2d.setColor(Color.WHITE);
				g2d.fillRect ( 0, 0, image.getWidth(), image.getHeight() );
			}
			
			BufferedImage temp = ImageIO.read(allFiles[i]);
			g2d.drawImage(temp, xPos[i%8] + temp.getWidth(), yPos[i%8], - temp.getWidth(), temp.getHeight(), null);
			
			if(i == allFiles.length-1)
				ImageIO.write(image,"JPG",new File("printables/" + ((i/8) + 1) + ".jpg"));
		}
		
		System.out.println("done!");
	}

}

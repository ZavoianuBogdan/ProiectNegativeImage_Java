package B;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagine2 extends Pixel2 {
	
	//clasa Imagine2, pe langa red,green,blue care acum descriu intensitatea culorilor din poza,
	//	mai are si atribute care caracterizeaza imaginea

	private int height,width;
	
	private int[][] R, G, B;//matricele de intensitatea pentru fiecare pixel, fiecare culoare RGB 
	
	public Imagine2(String nume) {
	
	//se citeste o imagine si se creeaza matricele de culori + atributele asociate
		
	BufferedImage img = null;
    //se incearca citirea imaginii

        try {
            img = ImageIO.read(new File(nume));
        } catch (IOException e) {

        }
		//se seteaza corespunzator atributele, conform datelor citite
        this.setHeight(img.getHeight());
        this.setWidth(img.getWidth());
        
        //sunt create matricele de pixeli
        this.R=new int[this.getHeight()][this.getWidth()];
        this.G=new int[this.getHeight()][this.getWidth()];
        this.B=new int[this.getHeight()][this.getWidth()];
        
        int rgb;
        
        System.out.println("Am citit o imagine de dimensiunea: "+this.height  + "x" +  this.width);

      //se citesc culorile din poza
        
        for (int h = 1; h<this.getHeight(); h++)
        {
            for (int w = 1; w<this.getWidth(); w++)
            {
                rgb = img.getRGB(w, h);
                this.R[h][w] = (rgb >> 16 ) & 0x000000FF;
                this.G[h][w] = (rgb >> 8 ) & 0x000000FF;
                this.B[h][w] = (rgb) & 0x000000FF;
            }
        }
	}
	
	public void prelucrare(String nume,String adresa) {
		
		//pentru prelucrare vom creea o noua imagine
		
		File f = null;
		BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		int rgb;    
		
		//ne folosim de matricele de culoare pentru prelucrare

		for (int h = 1; h < this.getHeight(); h++)
        {
            for (int w = 1; w < this.getWidth(); w++)
            {
                rgb = ((255-R[h][w])<<16) | ((255-G[h][w])<<8) | (255-B[h][w]);
                img.setRGB(w,h,rgb);
            }
        }
        
		//incercam creerea imaginii rezultat
        try {
        	final long start = System.currentTimeMillis();
        	f = new File(adresa+"\\"+nume);
        	ImageIO.write(img,"jpg",f);
			final long end = System.currentTimeMillis();
			System.out.println("\nPentru crearea pozei rezultat, timpul de executie a fost : " + (end - start)+" ms\n");
			
        }catch(IOException e) {
        	System.out.println(e);
        }
        System.out.println("Am inversat imaginea! Rezultatul se gaseste in fisierul: "+nume);
	}

	protected int getHeight() {
		return height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	protected int getWidth() {
		return width;
	}

	protected void setWidth(int width) {
		this.width = width;
	}
	
	//ca bonus al programului, cele 3 atribute ale pixelului au fost gandite sa aiba functionalitate
	//	si in clasa imagine2, ele indicand intensitatea culorilor RGB din poza
	
	public void procentCulori() {
			
		double sumaR = 0, sumaG = 0, sumaB = 0;
		
		//realiez acest procent de intensitate ca raport al sumei din maximul posibil
		
		for (int h = 1; h < this.getHeight(); h++)
        {
            for (int w = 1; w < this.getWidth(); w++)
            {
                sumaR += this.R[h][w];
                sumaG += this.G[h][w];
                sumaB += this.B[h][w];
            }
        }
		//calculam valoarea intensitatii pentru fiecare culoare dupa calculul sumei
		int nrPixeli = this.getWidth() * this.getHeight();
		sumaR /= (nrPixeli * 255);sumaR *= 100;
		sumaG /= (nrPixeli * 255);sumaG *= 100;
		sumaB /= (nrPixeli * 255);sumaB *= 100;
		
		this.setRed((int)sumaR);
		this.setGreen((int)sumaG);
		this.setBlue((int)sumaB);
		
		System.out.println("Intensitatea culorilor din poza in procente este: ");
		System.out.println("Rosu: "+sumaR+"%");
		System.out.println("Verde: "+sumaG+"%");
		System.out.println("Albastru: "+sumaB+"%");		
	}
}


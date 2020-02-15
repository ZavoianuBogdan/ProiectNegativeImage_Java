package B;

public class Pixel2 implements PixelInterface {
private int red,green,blue;//cele 3 caracteristici ale unui pixel		
	
	//constructori cu si fara parametrii
	public Pixel2() {
		this(0,0,0);
	}
	
	public Pixel2(int r,int g,int b) {
		this.setRed(r);
		this.setGreen(g);
		this.setBlue(b);
	}

	//suprascrierea metodelor din interfata
	@Override
	public void afisare() {
		System.out.println("Afisam un Pixel cu urmatoarele caracteristici:");
		System.out.println("Red: "+this.getRed()+"\nGreen: "+this.getGreen()+"\nBlue: "+this.getBlue());
	}
	@Override
	public void prelucrare() {
		setRed(255-this.getRed());
		setGreen(255-this.getGreen());
		setBlue(255-this.getBlue());
		}
	
	//GET & SET pentru cele 3 atribute
	protected int getRed() {
		return red;
	}

	protected void setRed(int red) {
		this.red = red;
	}

	protected int getGreen() {
		return green;
	}

	protected void setGreen(int green) {
		this.green = green;
	}

	protected int getBlue() {
		return blue;
	}

	protected void setBlue(int blue) {
		this.blue = blue;
	}
}

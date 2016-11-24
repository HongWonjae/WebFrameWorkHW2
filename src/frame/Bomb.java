package frame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bomb implements Runnable {
	private int x;
	private int y;
	private int power;

	private ImageIcon[] bombIcon = new ImageIcon[2];
	private Image image;

	public Bomb(int x, int y, int power) {
		bombIcon[0] = new ImageIcon("Images/BomberBombs/1.gif");
		bombIcon[1] = new ImageIcon("Images/BomberBombs/2.gif");
		image = bombIcon[0].getImage();

		this.x = x;
		this.y = y;
		this.power = power;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int x = 0;
		while (true) {

			try {
				image = bombIcon[x % bombIcon.length].getImage();
				x++;
				Thread.sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

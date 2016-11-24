package frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Bomberman {
	private int x;
	private int y;

	private int power = 2;
	private int bombCount = 1;

	private boolean UP = false;
	private boolean DOWN = false;
	private boolean LEFT = false;
	private boolean RIGHT = false;
	private boolean SPACE = false;

	private int oneRowLength;
	private int oneColumnLength;
	private int[][] array;

	private ImageIcon upIcon = new ImageIcon("Images/Bombermans/Player 2/01.gif");
	private ImageIcon downIcon = new ImageIcon("Images/Bombermans/Player 2/11.gif");
	private ImageIcon leftIcon = new ImageIcon("Images/Bombermans/Player 2/21.gif");
	private ImageIcon rightIcon = new ImageIcon("Images/Bombermans/Player 2/31.gif");

	private Image image = downIcon.getImage();

	private List<Bomb> bombs = new ArrayList<Bomb>();

	public Bomberman(int[][] array, int oneRowLength, int oneColumnLength) {
		this.x = oneRowLength;
		this.y = oneColumnLength;

		this.array = array;
		this.oneRowLength = oneRowLength;
		this.oneColumnLength = oneColumnLength;
	}

	public boolean isUP() {
		return UP;
	}

	public boolean isDOWN() {
		return DOWN;
	}

	public boolean isLEFT() {
		return LEFT;
	}

	public boolean isRIGHT() {
		return RIGHT;
	}

	public boolean isSPACE() {
		return SPACE;
	}

	public void setUP(boolean uP) {
		UP = uP;
		if (isUP() && getY() > 0) {
			y -= oneColumnLength;
			image = upIcon.getImage();
			move();
		}
	}

	public void setDOWN(boolean dOWN) {
		DOWN = dOWN;
		if (isDOWN() && getY() < oneColumnLength * (array.length - 1)) {
			y += oneColumnLength;
			image = downIcon.getImage();
			move();
		}
	}

	public void setLEFT(boolean lEFT) {
		LEFT = lEFT;
		if (isLEFT() && getX() > 0) {
			x -= oneRowLength;
			image = leftIcon.getImage();
			move();
		}

	}

	public void setRIGHT(boolean rIGHT) {
		RIGHT = rIGHT;
		if (isRIGHT() && getX() < oneRowLength * (array[0].length - 1)) {
			x += oneRowLength;
			image = rightIcon.getImage();
			move();
		}

	}

	public void setSPACE(boolean sPACE) {
		SPACE = sPACE;
		if (isSPACE()) {
			Bomb bomb = new Bomb(getX(), getY(), power);
			bombs.add(bomb);
			Thread th = new Thread(bomb);
			th.start();
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void move() {
		System.out.println("(" + getX() + ", " + getY() + ")");
	}

	public List<Bomb> getBombs() {
		return bombs;
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return image;
	}
}

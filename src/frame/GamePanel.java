package frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon floor = new ImageIcon("Images/BomberFloors/2.gif");
	private ImageIcon wall = new ImageIcon("Images/BomberWalls/2.gif");
	private ImageIcon block = new ImageIcon("Images/BomberBricks/2.gif");

	private int[][] array;

	private int oneRowLength;
	private int oneColumnLength;

	private Bomberman bomberman;

	// double buffering
	private Image dbImage;
	private Graphics dbg;

	public GamePanel(int[][] array, int oneRowLength, int oneColumnLength) {
		// TODO Auto-generated constructor stub
		this.array = array;
		this.oneRowLength = oneRowLength;
		this.oneColumnLength = oneColumnLength;

		bomberman = new Bomberman(array, oneRowLength, oneColumnLength);

		this.addKeyListener(this);
		this.setFocusable(true);

		Thread th = new Thread(this);
		th.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		dbImage = createImage(MyFrame.MY_WIDTH, MyFrame.MY_HEIGHT);
		dbg = dbImage.getGraphics();

		update(g);

	}

	public void update(Graphics g) {
		drawBackground();
		drawCharacter();
		drawBomb();
		g.drawImage(dbImage, 0, 0, this);
	}

	private void drawBackground() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1)
					drawFloor(i, j);
				else if (array[i][j] == 2)
					drawWall(i, j);
				else if (array[i][j] == 3)
					drawBlock(i, j);
			}
		}
	}

	private void drawFloor(int i, int j) {
		dbg.drawImage(floor.getImage(), j * oneRowLength, i * oneColumnLength, oneRowLength, oneColumnLength, null);
	}

	private void drawWall(int i, int j) {
		dbg.drawImage(wall.getImage(), j * oneRowLength, i * oneColumnLength, oneRowLength, oneColumnLength, null);
	}

	private void drawBlock(int i, int j) {
		dbg.drawImage(block.getImage(), j * oneRowLength, i * oneColumnLength, oneRowLength, oneColumnLength, null);
	}

	private void drawCharacter() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				// if (array[bomberman.getY() /
				// oneColumnLength][bomberman.getX() / oneRowLength] == 1) {
				dbg.drawImage(bomberman.getImage(), bomberman.getX(), bomberman.getY(), oneRowLength, oneColumnLength,
						null);

			}
		}
	}

	private void drawBomb() {
		// for (int i = 0; i < array.length; i++) {
		// for (int j = 0; j < array[i].length; j++) {
		// if (array[bomberman.getY() / oneColumnLength][bomberman.getX() /
		// oneRowLength] == 1) {
		List<Bomb> bombs = bomberman.getBombs();

		if (!bombs.isEmpty())
			for (int i = 0; i < bombs.size(); i++) {
				dbg.drawImage(bombs.get(i).getImage(), bombs.get(i).getX(), bombs.get(i).getY(), oneRowLength,
						oneColumnLength, null);
			}
		// }

		// }
		// }
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				repaint();
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			bomberman.setUP(true);
			System.out.println("Press UP");
			break;
		case KeyEvent.VK_DOWN:
			bomberman.setDOWN(true);
			System.out.println("Press DOWN");
			break;
		case KeyEvent.VK_LEFT:
			bomberman.setLEFT(true);
			System.out.println("Press LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			bomberman.setRIGHT(true);
			System.out.println("Press RIGHT");
			break;
		case KeyEvent.VK_SPACE:
			bomberman.setSPACE(true);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			bomberman.setUP(false);

			break;
		case KeyEvent.VK_DOWN:
			bomberman.setDOWN(false);

			break;
		case KeyEvent.VK_LEFT:
			bomberman.setLEFT(false);

			break;
		case KeyEvent.VK_RIGHT:
			bomberman.setRIGHT(false);

			break;
		case KeyEvent.VK_SPACE:
			bomberman.setSPACE(false);
			break;

		}

	}

}

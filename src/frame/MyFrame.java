package frame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	// public static final int MY_WIDTH = (int) screen.getWidth();
	// public static final int MY_HEIGHT = (int) screen.getHeight()-25;

	public static final int MY_WIDTH = 300;
	public static final int MY_HEIGHT = 300;

	private int[][] array;

	private int oneRowLength;
	private int oneColumnLength;

	private ImageIcon logo = new ImageIcon("Images/Bomberman.gif");

	public MyFrame() {
		// TODO Auto-generated constructor stub

		super("Net-BomberMan by GT and WJ");

		this.setSize(MY_WIDTH + 5, MY_HEIGHT + 25);
		// this.setLocation(10, 10);

		this.setAlwaysOnTop(true);
		this.setIconImage(logo.getImage());

		initMapSource();

		Container c = this.getContentPane();
		GamePanel gamePanel = new GamePanel(array, oneRowLength, oneColumnLength);
		c.add(gamePanel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void initMapSource() {
		try {
			int i = 0;
			int j = 0;

			FileInputStream in = new FileInputStream("resources/map1.txt");
			Scanner rowsc = new Scanner(in);
			rowsc.useDelimiter("\n");
			String rowTmp = rowsc.next();

			in = new FileInputStream("resources/map1.txt");
			Scanner columnsc = new Scanner(in);
			columnsc.useDelimiter("\n");
			List<String> temp = new ArrayList<String>();
			while (columnsc.hasNext()) {
				temp.add(columnsc.nextLine());
			}

			System.out.println("init " + rowTmp.length() / 2 + " by " + temp.size());

			array = new int[rowTmp.length() / 2][temp.size()];

			oneRowLength = MyFrame.MY_WIDTH / array.length;
			oneColumnLength = MyFrame.MY_HEIGHT / array[0].length;

			in = new FileInputStream("resources/map1.txt");
			Scanner sc = new Scanner(in);
			while (sc.hasNext()) {
				array[i][j++] = sc.nextInt();
				if (j == array[i].length) {
					i++;
					j = 0;
				}
			}
			try {
				rowsc.close();
				columnsc.close();
				sc.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

}

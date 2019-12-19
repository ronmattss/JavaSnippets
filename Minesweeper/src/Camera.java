import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;
import java.util.*;
import java.util.List;

import javax.tools.Tool;

public class Camera extends Frame {

	/**
		 * 
		 */
	private static final long serialVersionUID = -3677449073295483313L;
// INSTANCE VARIABLE AREA 
// All common variables are placed here
// Variables declared here becomes common to any location of the program

	final int xOrigin = 20; // x offsetting
	final int yOrigin = 40; // y offsetting

	final int gridHeight = 40; // Height of smallest grid cell
	final int gridWidth = 40; // Width of smallest grid cell

	final int noColumn = 8; // No. of columns
	public int noMines = 10;
	ArrayList<Integer> blackCells = new ArrayList<>(); // this lists all the cells with mines
	ArrayList<Boolean> checkFlags = new ArrayList<>(); // checks if mines are flagged
	List<Integer> visitedCell = new ArrayList<>(); // Debugging purposes, visits every cell
	List<Cell> cells = new ArrayList<Cell>(64); // stores all cells in a list

	MyGame game;

// The instance variable representing the whole game

	// All images to be displayed must be represented by an Image variable.
	// define below all the images to be displayed.
	Image board = Toolkit.getDefaultToolkit().getImage("res/grid.gif");
	// Image b = Toolkit.getDefaultToolkit().get
	Image blackchip = Toolkit.getDefaultToolkit().getImage("res/blackchip.gif");
	Image whiteCell = Toolkit.getDefaultToolkit().getImage("res/cell.gif");
	Image one = Toolkit.getDefaultToolkit().getImage("res/one.png");
	Image two = Toolkit.getDefaultToolkit().getImage("res/two.png");
	Image three = Toolkit.getDefaultToolkit().getImage("res/three.png");
	Image four = Toolkit.getDefaultToolkit().getImage("res/four.png");
	Image five = Toolkit.getDefaultToolkit().getImage("res/five.png");
	Image six = Toolkit.getDefaultToolkit().getImage("res/six.png");
	Image seven = Toolkit.getDefaultToolkit().getImage("res/seven.png");
	Image eight = Toolkit.getDefaultToolkit().getImage("res/eight.png");
	Image safe = Toolkit.getDefaultToolkit().getImage("res/safe.png");
	Image flag = Toolkit.getDefaultToolkit().getImage("res/flag.png");

// Constructor
	Camera() {
		setTitle("Mine Sweeper");
		setSize(350, 400);
		setLayout(null);
		setVisible(true);
		setResizable(false);

		// Sets the whole game
		for (int i = 0; i < 64; i++) {
			Cell c = new Cell();
			c.setCell(i);
			c.setFlagged(false);
			c.setMine(false);
			cells.add(c);
		}
		// randomly sets mines on the board
		// there is a bug that hidden cells can be occupied
		for (int i = 0; i < noMines; i++) {
			Random rand = new Random();
			int r = rand.nextInt(64);
			blackCells.add(r);
			cells.get(checkCells(r)).setMine(true);
			checkFlags.add(cells.get(checkCells(r)).isFlagged());
			System.out.println("Mines Placed AT: " + r);
		}

		validate();
		repaint();
	}

	Camera(MyGame g) {
		game = g;
	}

	// Draw Mines
	// cover with whiteCells
	// if cellwithMines is pressed game over then draw all blackcells
	// if cellwithoutMines is pressed then if there is a mineNear draw cell with
	// number else clear mines

// PAINT METHOD
// draws graphic elements on the screen
// this is usually the place where you scan the gameboard array
// this method may be overriden in the UserIO.java
// this method is called whenever the repaint() method is called
// repaint() is also called whenever there are changes added to the frame
// i.e. resizing, minimizing, maximizing windows, etc.

	public void paint(Graphics g) {
		// DRAW Grid Workspace
		// g.drawImage(board, xOrigin, yOrigin, this);
//		drawChange(cell, mine);
		drawWhiteCells();
		System.out.println("cells size: " + cells.size());
		// drawChange(cCell, mine);
		// Redraws the whole canvas when clicking
		if (!cells.isEmpty()) {
			for (int i = 0; i < cells.size(); i++) {
				if (cells.get(i).isClicked() == true
						&& (cells.get(i).isLoss() == true && cells.get(i).isMine() == true)) {

					for (int j = 0; j < cells.size(); j++) {
						if ((cells.get(j).isMine() == true)) {
							g.drawImage(blackchip, xLoc(j), yLoc(j), this);
						} else {
							drawChange(cells.get(j).getCell(), cells.get(j).getNearbyMines());
						}
					}

				} else if (cells.get(i).isClicked() == true && cells.get(i).isFlagged() == false) {
					drawChange(cells.get(i).getCell(), cells.get(i).getNearbyMines());
				}
				if (cells.get(i).isFlagged() == true && cells.get(i).isClicked()) {
					g.drawImage(flag, xLoc(i), yLoc(i), this);
				}

			}

		}

		//
		// g.drawImage(blackchip,xLoc(9),yLoc(9),this); // example only; draw a
		// blackchip in array 9
		// g.drawImage(blackchip,xLoc(15),yLoc(15),this); // example only; draw a
		// blackchip in array 15
		// drawBlackCells(g); //used in debugging mine locations

	}

	// Randomly assign mines in the board

	// debugging only function
	// checks duplicates
	int checkLocation(int n) {
		int x = -203;
		for (int i = 0; i < blackCells.size(); i++) {
			if (n == blackCells.get(i))
				;
			x = blackCells.get(i);

		}
		return x;

	}
	
	// debugging only function
	// checks duplicates

	int checkDuplicateCells(int n) {
		int x = -203;
		for (int i = 0; i < cells.size(); i++) {
			if (n == cells.get(i).getCell())
				x = cells.get(i).getCell();

		}
		return x;

	}

	//debugging only function
	// checks duplicates
	int checkCells(int n) {
		int x = -203;
		for (int i = 0; i < cells.size(); i++) {
			if (n == cells.get(i).getCell())
				x = i;

		}
		return x;

	}

	// DEBUG: show where mines are located
	public void drawBlackCells() {
		Graphics g = getGraphics();
		for (int i = 0; i < noMines; i++) {
			g.drawImage(blackchip, xLoc(blackCells.get(i)), yLoc(blackCells.get(i)), this);
		}
	}

	//draws white cells
	public void drawWhiteCells() {
		Graphics g = getGraphics();
		for (int i = 0; i < 64; i++) {
			g.drawImage(whiteCell, xLoc(i), yLoc(i), this);
		}
	}
	
	// switch for managing images to show
	public Image countImage(int count) {
		switch (count) {
		case 0:
			return safe;
		case 1:
			return one;
		case 2:
			return two;
		case 3:
			return three;
		case 4:
			return four;
		case 5:
			return five;
		case 6:
			return six;
		case 7:
			return seven;
		case 8:
			return eight;

		default:
			return whiteCell;

		}
	}

	// draw when something is changed, called in the paint method
	public void drawChange(int cell, int count) {

		Graphics g = getGraphics();
		g.drawImage(countImage(count), xLoc(cell), yLoc(cell), this);
	}

	// DEBUG: draw white Cells;
	public void paintCell(int cell) {
		Graphics g = getGraphics();
		g.drawImage(whiteCell, xLoc(cell), yLoc(cell), this);
	}

	public int cellPosition(int x, int y) { // Method to get the array pointer given x and y coordinates (mouse)
		System.out.println("x: " + (x / gridWidth));
		System.out.println("y: " + (y / gridHeight));
		int cell = (y / gridHeight) * noColumn + (x / gridWidth);
		System.out.println("Cell: " + cell);
		return cell;
	}

	public int xLoc(int cellPosition) { // Method to get the X coordinate given the array pointer
		int x = (cellPosition % noColumn) * gridWidth + xOrigin;
		return x;
	}

	public int yLoc(int cellPosition) { // Method to get the Y coordinate given the array pointer
		int y = (cellPosition / noColumn) * gridHeight + yOrigin;
		return y;
	}

	public static void main(String[] arg) {

		new Canvas();

	}

}
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class UserIO extends Camera implements MouseListener, MouseMotionListener, KeyListener {

	/**
	 * 
	 */

	private static final long serialVersionUID = -5249317551449069956L;

	MyGame game;

	UserIO() {

		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);

	}

	UserIO(MyGame g) {
		game = g;

		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}

// MouseListener Abstract Methods

	/*
	 * Count all the mines in the 8 adjacent cells
	 * 
	 * N.W N N.E \ | / \ | / W----Cell----E / | \ / | \ S.W S S.E
	 * 
	 * Cell-->Current Cell (row, col) N --> North (row-1, col) S --> South (row+1,
	 * col) E --> East (row, col+1) W --> West (row, col-1) N.E--> North-East
	 * (row-1, col+1) N.W--> North-West (row-1, col-1) S.E--> South-East (row+1,
	 * col+1) S.W--> South-West (row+1, col-1)
	 */

	// Recursive function check nearest cells

	// populates grid with Cells
	public void populateGrid() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				checkAdjacentCells(j, i);
			}
		}
		System.out.println(cells.get(23).getNearbyMines());
	}

	// flags individual cells
	public void flag(int x, int y) {
		int currCell = cell(x, y);
	//	cells.get(currCell).setClicked(true);
	//	cells.get(currCell).setFlagged(true);
		if (cells.get(currCell).isFlagged() == true) {
			cells.get(currCell).setFlagged(false);
			cells.get(currCell).setClicked(false);
			repaint();
		}
		else
		{
			cells.get(currCell).setFlagged(true);
			cells.get(currCell).setClicked(true);
			repaint();
		}
		repaint();

	}

	// method that draws the canvas on click
	// 3 x 3 radius per cell
	public void draw(int x, int y) {
		
		//  coordinates converted to individual cells
		int currCell = cell(x, y);
		Cell cell = new Cell();
		int tempX = x;
		int tempY = y - 1;
		int w = cell((x - 1), y);
		int e = cell((x + 1), y);
		int s = cell((x), y + 1);
		int n = cell((x), (y - 1));
		int sw = cell((x - 1), (y + 1));
		int nw = cell((x - 1), (y - 1));
		int se = cell((x + 1), (y + 1));
		int ne = cell((x + 1), (y - 1));

		cells.get(currCell).setClicked(true);
		if (cells.get(currCell).isMine() == true && cells.get(currCell).isFlagged() == false) {
			cells.get(currCell).setLoss(true);
			repaint();
		}
		
		//checks the N S W E... coordinates of the current cell
		if (n >= 0 && (tempY) > -1 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(n).isMine() == true) {

			} else {
				cells.get(n).setClicked(true);

			}
		}
		tempY = y + 1;
		if (s < 65 && (y + 1) < 8 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(s).isMine() == true) {

			} else {
				cells.get(s).setClicked(true);
			}

		}
		tempX = x - 1;
		tempY = y;
		if (w > -1 && tempX > -1 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(w).isMine() == true) {

			} else {
				cells.get(w).setClicked(true);
			}

		}
		tempX = x + 1;
		tempY = y;
		if (e < 65 && tempX < 8 && tempY < 65 && tempY < 65 && n < 65) {
			if (cells.get(e).isMine() == true) {

			} else {
				cells.get(e).setClicked(true);
			}

		}
		tempX = x - 1;
		tempY = y + 1;
		if (sw > -1 && sw < 64 && tempX > -1 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(sw).isMine() == true) {

			} else {
				cells.get(sw).setClicked(true);
			}

		}
		tempX = x + 1;
		tempY = y + 1;
		if (se > -1 && tempX < 8 && n < 65) {
			if (cells.get(se).isMine() == true) {

			} else {
				cells.get(se).setClicked(true);
			}

		}
		tempX = x + 1;
		tempY = y - 1;
		if (ne > -1 && tempX < 8 && n < 65) {
			if (cells.get(ne).isMine() == true) {

			} else {
				cells.get(ne).setClicked(true);
			}

		}
		tempX = x - 1;
		tempY = y - 1;
		if (nw > -1 && tempX > -1 && n < 65) {
			if (cells.get(nw).isMine() == true) {

			} else {
				cells.get(nw).setClicked(true);
			}

		}

		cells.get(currCell).setClicked(true);

		repaint();
	}
	
	
	// Checks adjacent Cells on the board, 
	public void checkAdjacentCells(int x, int y) {
		// base formula for checking adjacent cells using compass terms
		int currCell = cell(x, y);
		Cell cell = new Cell();
		int tempX = x;
		int tempY = y - 1;
		int w = cell((x - 1), y);
		int e = cell((x + 1), y);
		int s = cell((x), y + 1);
		int n = cell((x), (y - 1));
		int sw = cell((x - 1), (y + 1));
		int nw = cell((x - 1), (y - 1));
		int se = cell((x + 1), (y + 1));
		int ne = cell((x + 1), (y - 1));
		int mines = 0;
		visitedCell.add(currCell);
		cell.setCell(currCell);
		// cell.setFlagged(true);
		// checkNorth

		// if (checkCell(currCell) == false && checkIfVisited(currCell) != currCell) {
		// drawBlackCells();
		// }
		if (n >= 0 && (tempY) > -1 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(n).isMine() == true) {
				mines++;
			} else {

			}
		}
		tempY = y + 1;
		if (s < 65 && (y + 1) < 8 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(s).isMine() == true) {
				mines++;
			} else {
				// checkAdjacentCells(tempX, tempY);
			}

		}
		tempX = x - 1;
		tempY = y;
		if (w > -1 && tempX > -1 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(w).isMine() == true) {
				mines++;
			} else {
				// checkAdjacentCells(tempX, tempY);
			}

		}
		tempX = x + 1;
		tempY = y;
		if (e < 65 && tempX < 8 && tempY < 65 && tempY < 65 && n < 65) {
			if (cells.get(e).isMine() == true) {
				mines++;
			} else {
				// checkAdjacentCells(tempX, tempY);
			}

		}
		tempX = x - 1;
		tempY = y + 1;
		if (sw > -1 && sw < 64 && tempX > -1 && tempX < 8 && tempY < 65 && n < 65) {
			if (cells.get(sw).isMine() == true) {
				mines++;
			} else {
				// checkAdjacentCells(tempX, tempY);
			}

		}
		tempX = x + 1;
		tempY = y + 1;
		if (se > -1 && se < 64 && tempX < 8 && n < 64) {
			if (cells.get(se).isMine() == true) {
				mines++;
			} else {
				// checkAdjacentCells(tempX, tempY);
			}

		}
		tempX = x + 1;
		tempY = y - 1;
		if (ne > -1 && tempX < 8 && n < 65) {
			if (cells.get(ne).isMine() == true) {
				mines++;
			} else {
				// checkAdjacentCells(tempX, tempY);
			}

		}
		tempX = x - 1;
		tempY = y - 1;
		if (nw > -1 && tempX > -1 && n < 65) {
			if (cells.get(nw).isMine() == true) {
				mines++;
			} else {
				// checkAdjacentCells(tempX, tempY);
			}

		}
		cells.get(cell.getCell()).setNearbyMines(mines);
		System.out.println("current Cell: " + cells.get(currCell).getCell());
		System.out.println("current x y :" + x + " " + y + " adjacent Mines: " + cells.get(currCell).getNearbyMines());
		System.out.println("N cell x y:" + n + " " + x + " " + (y - 1));
		System.out.println("S cell x y:" + s + " " + x + " " + (y + 1));
		System.out.println("E cell x y:" + e + " " + (x + 1) + " " + (y));
		System.out.println("W cell x y:" + w + " " + (x - 1) + " " + (y + 1));
		System.out.println("NE cell x y:" + ne + " " + (x + 1) + " " + (y - 1));
		System.out.println("NW cell x y:" + nw + " " + (x - 1) + " " + (y - 1));
		System.out.println("SE cell x y:" + se + " " + (x + 1) + " " + (y + 1));
		System.out.println("SW cell x y:" + sw + " " + (x - 1) + " " + (y));
		// currX = x;
		// currY = y;

		// drawChange(s, mines);
		// drawChange(e, mines);
		// drawChange(w, mines);
//		cell =currCell;
//		mine = mines;
		// drawChange(currCell, mines);
		// mine = cells.get(currCell).getNearbyMines();
		// cCell = cells.get(currCell).getCell();
		// repaint();
	}

	public Boolean checkCell(int cell) {
		Boolean clear = true;
		for (int i = 0; i < blackCells.size(); i++) {
			if (cell == blackCells.get(i)) {
				return false;
			}
		}
		return clear;
	}

	public int checkIfVisited(int cell) {
		for (int i = 0; i < visitedCell.size(); i++) {
			if (cell == visitedCell.get(i)) {
				return visitedCell.get(i);
			} else {

			}
		}
		return -5;
	}

	public int getRow(int x) {
		return x / gridWidth;
	}

	public int getColumn(int y) {
		return y / gridHeight;
	}

	public int cell(int x, int y) { // Method to get the array pointer given x and y coordinates (mouse)
		// System.out.println("x: " + (x / gridWidth));
		// System.out.println("y: " + (y / gridHeight));
		int cell = (y * noColumn + x);
		// System.out.println("Cell: " + cell);
		return cell;
	}

	public void mouseClicked(MouseEvent evt) {
	}

	public void mousePressed(MouseEvent evt) {

	}
	
// this is where magic happens
	public void mouseReleased(MouseEvent evt) {

		int xLoc = evt.getX();
		int yLoc = evt.getY();

		int xRel = evt.getX() - xOrigin;
		int yRel = evt.getY() - yOrigin;
		int x = getRow(xRel);
		int y = getColumn(yRel);
		int cellLocation = cellPosition(xRel, yRel);
		System.out.println("mouse is pressed " + x + evt.getButton());

		System.out.println("mouse is pressed " + y);
		System.out.println(cellPosition(xRel, yRel));
		System.out.println("pressed cell: " + cellPosition(xRel, yRel));
		// checkAdjacentCells(x, y);
		Boolean cellStatus = checkCell(cellLocation);
		if(evt.getButton() == 1)
		{
			draw(x, y);
		}
		else if (evt.getButton() == 3){
			flag(x, y);
		}
		
		
		
		if (cellStatus == true) {
			// paintCell(cellLocation);

			System.out.println("Cell: " + cellLocation + " clear");
		} else {
			drawBlackCells();
			System.out.println("Cell: " + cellLocation + " Has Mine");
		}
		
		
//		repaint();
	}

	public void mouseEntered(MouseEvent evt) {
		 System.out.println("Press x to exit and r to restart");
	}

	public void mouseExited(MouseEvent evt) {
		// System.out.println("Mouse exit");
		// System.out.println("Blackcells" + blackCells.size());

	}

// MouseMotionListener Abstract Methods

	public void mouseDragged(MouseEvent evt) {

	}

	public void mouseMoved(MouseEvent evt) {
//
		int xLoc = evt.getX();
		// int yLoc = evt.getY();

		// int xRel = evt.getX() - xOrigin;
		// int yRel = evt.getY() - yOrigin;
		// System.out.println("mouse is moved " + xLoc + "," + yLoc);

		// System.out.println("mouse is moved " + xRel + "," + yRel);
//		System.out.println(cellPosition(xRel, yRel));
		// System.out.println(cells.get(cellPosition(xRel, yRel)).isMine());

	}

// Keylistener Abstract Method
	
	public void keyReleased(KeyEvent evt) {
		System.out.println(evt.getKeyCode());
	}
	// Press these keys to exit or restart
	public void keyPressed(KeyEvent evt) {
		char x = evt.getKeyChar();
		String y[] = {Character.toString(x)};
		if(x == 'r')
		{
			this.dispose();
			MyGame.main(y);
		}
		else if(x == 'x')
		{
			this.dispose();
		}

	}

	public void keyTyped(KeyEvent evt) {

	}

// User Methods

	public static void main(String[] arg) {
		new UserIO();
	}

}

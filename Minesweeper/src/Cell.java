import java.util.*;

public class Cell {
	private int cell;
	private int nearbyMines = 0;
	private boolean isMine = false;
	private boolean isLoss = false;
	private boolean isFlagged = false;
	private boolean isClicked = false;

	public int getCell() {
		return cell;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	public int getNearbyMines() {
		return nearbyMines;
	}

	public void setNearbyMines(int nearbyMines) {
		this.nearbyMines = nearbyMines;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public boolean isLoss() {
		return isLoss;
	}

	public void setLoss(boolean isLoss) {
		this.isLoss = isLoss;
	}

}

package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
	private static final int SIDE = 9;
	private static final String MINE = "\uD83D\uDCA3";
	private static final String FLAG = "\uD83D\uDEA9";
	private GameObject[][] gameField = new GameObject[SIDE][SIDE];
	private int countMinesOnField;
	private int countClosedTiles = SIDE * SIDE;
	private int countFlags;
	private boolean isGameStopped;
	private int score;
	
	@Override
	public void initialize() {
		setScreenSize(SIDE, SIDE);
		createGame();
	}
	
	private void createGame() {
		for (int y = 0; y < SIDE; y++) {
			for (int x = 0; x < SIDE; x++) {
				setCellValue(x, y, "");
			}
		}
		for (int y = 0; y < SIDE; y++) {
			for (int x = 0; x < SIDE; x++) {
				boolean isMine = getRandomNumber(10) < 1;
				if (isMine) {
					countMinesOnField++;
				}
				gameField[y][x] = new GameObject(x, y, isMine);
				setCellColor(x, y, Color.ORANGE);
			}
		}
		countFlags = countMinesOnField;
		countMineNeighbors();
	}
	
	private void countMineNeighbors() {
		int count = 0;
		for (int y = 0; y < SIDE; y++) {
			for (int x = 0; x < SIDE; x++) {
				if (!gameField[y][x].isMine) {
					for (GameObject obj : getNeighbors(gameField[y][x])) {
						if (obj.isMine) {
							count++;
						}
					}
					gameField[y][x].countMineNeighbors = count;
					count = 0;
				}
			}
		}
	}
	
	private List<GameObject> getNeighbors(GameObject gameObject) {
		List<GameObject> result = new ArrayList<>();
		for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
			for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
				if (y < 0 || y >= SIDE) {
					continue;
				}
				if (x < 0 || x >= SIDE) {
					continue;
				}
				if (gameField[y][x] == gameObject) {
					continue;
				}
				result.add(gameField[y][x]);
			}
		}
		return result;
	}
	
	@Override
	public void onMouseLeftClick(int x, int y) {
		if (!isGameStopped) {
			openTile(x, y);
			return;
		}
		if (isGameStopped) {
			restart();
		}
	}
	
	private void openTile(int x, int y) {
		if (!gameField[y][x].isOpen && !gameField[y][x].isFlag && !isGameStopped) {
			gameField[y][x].isOpen = true;
			countClosedTiles--;
			setCellColor(x, y, Color.GREEN);
			if (gameField[y][x].isMine) {
				setCellValueEx(x, y, Color.RED, MINE);
				gameOver();
			}
			if (!gameField[y][x].isMine) {
				setCellNumber(x, y, gameField[y][x].countMineNeighbors);
				score += 5;
				setScore(score);
				if (countClosedTiles == countMinesOnField) {
					win();
				}
			}
			if (!gameField[y][x].isMine && gameField[y][x].countMineNeighbors == 0) {
				setCellValue(x, y, "");
				for (GameObject obj : getNeighbors(gameField[y][x])) {
					if (!obj.isOpen && !obj.isMine) {
						openTile(obj.x, obj.y);
					}
				}
			}
		}
	}
	
	@Override
	public void onMouseRightClick(int x, int y) {
		markTile(x, y);
	}
	
	private void markTile(int x, int y) {
		if (!isGameStopped) {
			if (!gameField[y][x].isFlag && !gameField[y][x].isOpen && countFlags != 0) {
				gameField[y][x].isFlag = true;
				countFlags--;
				setCellValue(x, y, FLAG);
				setCellColor(x, y, Color.YELLOW);
				return;
			}
			if (gameField[y][x].isFlag) {
				gameField[y][x].isFlag = false;
				countFlags++;
				setCellValue(x, y, "");
				setCellColor(x, y, Color.ORANGE);
			}
		}
	}
	
	private void gameOver() {
		isGameStopped = true;
		showMessageDialog(Color.AZURE, "Фсё, пиздец!", Color.RED, 25);
	}
	
	private void win() {
		isGameStopped = true;
		showMessageDialog(Color.AZURE, "Фсё, домой!", Color.GREEN, 25);
	}
	
	private void restart() {
		isGameStopped = false;
		countClosedTiles = SIDE * SIDE;
		countMinesOnField = 0;
		score = 0;
		setScore(score);
		createGame();
	}
}
package com.javarush.task.task35.task3513;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class Model {
	private static final int FIELD_WIDTH = 4;
	private Tile[][] gameTiles;
	protected int score = 0;
	protected int maxTile = 0;
	private Stack<Tile[][]> previousStates = new Stack<>();
	private Stack<Integer> previousScores = new Stack<>();
	private boolean isSaveNeeded = true;
	
	public Model() {
		resetGameTiles();
	}
	
	public Tile[][] getGameTiles() {
		return gameTiles;
	}
	
	private void addTile() {
		List<Tile> emptyTiles = getEmptyTiles();
		if (!emptyTiles.isEmpty()) {
			int randomTile = (int) (emptyTiles.size() * Math.random());
			emptyTiles.get(randomTile).value = Math.random() < 0.9 ? 2 : 4;
			if (emptyTiles.get(randomTile).value > maxTile) {
				maxTile = emptyTiles.get(randomTile).value;
			}
		}
	}
	
	private List<Tile> getEmptyTiles() {
		List<Tile> emptyTiles = new ArrayList<>();
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				if (gameTiles[i][j].value == 0) {
					emptyTiles.add(gameTiles[i][j]);
				}
			}
		}
		return emptyTiles;
	}
	
	protected void resetGameTiles() {
		gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				gameTiles[i][j] = new Tile();
			}
		}
		addTile();
		addTile();
	}
	
	private int getEmptyTilesCount() {
		return getEmptyTiles().size();
	}
	
	private boolean isFull() {
		return getEmptyTilesCount() == 0;
	}
	
	public boolean canMove() {
		if (!isFull()) {
			return true;
		}
		
		for (int x = 0; x < FIELD_WIDTH; x++) {
			for (int y = 0; y < FIELD_WIDTH; y++) {
				Tile t = gameTiles[x][y];
				if ((x < FIELD_WIDTH - 1 && t.value == gameTiles[x + 1][y].value)
						|| ((y < FIELD_WIDTH - 1) && t.value == gameTiles[x][y + 1].value)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean compressTiles(Tile[] tiles) {
		int insertPosition = 0;
		boolean change = false;
		for (int i = 0; i < FIELD_WIDTH; i++) {
			if (!tiles[i].isEmpty()) {
				if (i != insertPosition) {
					tiles[insertPosition] = tiles[i];
					tiles[i] = new Tile();
					if (!change) {
						change = true;
					}
				}
				insertPosition++;
			}
		}
		return change;
	}
	
	private boolean mergeTiles(Tile[] tiles) {
		LinkedList<Tile> tilesList = new LinkedList<>();
		boolean change = false;
		for (int i = 0; i < FIELD_WIDTH; i++) {
			if (tiles[i].isEmpty()) {
				continue;
			}
			
			if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i + 1].value) {
				int updatedValue = tiles[i].value * 2;
				if (updatedValue > maxTile) {
					maxTile = updatedValue;
				}
				score += updatedValue;
				tilesList.addLast(new Tile(updatedValue));
				tiles[i + 1].value = 0;
				if (!change) {
					change = true;
				}
			} else {
				tilesList.addLast(new Tile(tiles[i].value));
			}
			tiles[i].value = 0;
		}
		
		for (int i = 0; i < tilesList.size(); i++) {
			tiles[i] = tilesList.get(i);
		}
		return change;
	}
	
	public void left() {
		if (isSaveNeeded) {
			saveState(gameTiles);
		}
		boolean change = false;
		for (Tile[] tiles : gameTiles) {
		    if (compressTiles(tiles) | mergeTiles(tiles)) {
		    	if (!change) {
		    		change = true;
				}
			}
		}
		isSaveNeeded = true;
		if (change) {
			addTile();
		}
	}
	
	public void right() {
		saveState(gameTiles);
		matrixRotate();
		matrixRotate();
		left();
		matrixRotate();
		matrixRotate();
	}
	
	public void up() {
		saveState(gameTiles);
		matrixRotate();
		matrixRotate();
		matrixRotate();
		left();
		matrixRotate();
	}
	
	public void down() {
		saveState(gameTiles);
		matrixRotate();
		left();
		matrixRotate();
		matrixRotate();
		matrixRotate();
	}
	
	private void matrixRotate() {
		Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
		
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				temp[j][FIELD_WIDTH - i - 1] = gameTiles[i][j];
			}
		}
		
		gameTiles = temp;
	}
	
	private void saveState(Tile[][] tiles) {
		Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				temp[i][j] = new Tile(tiles[i][j].value);
			}
		}
		previousStates.push(temp);
		previousScores.push(score);
		isSaveNeeded = false;
	}
	
	public void rollback() {
		if (!previousStates.empty() && !previousScores.empty()) {
			gameTiles = previousStates.pop();
			score = previousScores.pop();
		}
	}
	
	public void randomMove() {
		int n = ((int) (Math.random() * 100)) % 4;
		if (n == 0) {
			left();
		} else if (n == 1) {
			right();
		} else if (n == 2) {
			up();
		} else if (n == 3) {
			down();
		}
	}
	
	public boolean hasBoardChanged() {
		int countGameTiles = 0;
		int countPreviousStateGameTiles = 0;
		Tile[][] previousStateGameTiles = previousStates.peek();
		
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				countGameTiles += gameTiles[i][j].value;
			}
		}
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				countPreviousStateGameTiles += previousStateGameTiles[i][j].value;
			}
		}
		return countGameTiles != countPreviousStateGameTiles;
	}
	
	public MoveEfficiency getMoveEfficiency(Move move) {
		move.move();
		if (!hasBoardChanged()) {
			return new MoveEfficiency(-1, 0, move);
		}
		MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
		rollback();
		return moveEfficiency;
	}
	
	public void autoMove() {
		PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
		queue.offer(getMoveEfficiency(this::left));
		queue.offer(getMoveEfficiency(this::right));
		queue.offer(getMoveEfficiency(this::up));
		queue.offer(getMoveEfficiency(this::down));
		queue.peek().getMove().move();
	}
}

package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
	int value;
	
	public Tile() {
		value = 0;
	}
	
	public Tile(int value) {
		this.value = value;
	}
	
	public boolean isEmpty() {
		return value == 0;
	}
	
	public Color getFontColor() {
		if (value < 16) {
			return new Color(0x776e65);
		} else {
			return new Color(0xf9f6f2);
		}
	}
	
	public Color getTileColor() {
		Color tileColor;
		switch (value) {
			case 0:
				tileColor = new Color(0xcdc1b4);
				break;
			case 2:
				tileColor = new Color(0xeee4da);
				break;
			case 4:
				tileColor = new Color(0xede0c8);
				break;
			case 8:
				tileColor = new Color(0xf2b179);
				break;
			case 16:
				tileColor = new Color(0xf59563);
				break;
			case 32:
				tileColor = new Color(0xf67c5f);
				break;
			case 64:
				tileColor = new Color(0xf65e3b);
				break;
			case 128:
				tileColor = new Color(0xedcf72);
				break;
			case 256:
				tileColor = new Color(0xedcc61);
				break;
			case 512:
				tileColor = new Color(0xedc850);
				break;
			case 1024:
				tileColor = new Color(0xedc53f);
				break;
			case 2048:
				tileColor = new Color(0xedc22e);
				break;
			default:
				tileColor = new Color(0xff0000);
		}
		return tileColor;
	}
}

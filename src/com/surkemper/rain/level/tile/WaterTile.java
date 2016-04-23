package com.surkemper.rain.level.tile;

import com.surkemper.rain.graphics.Screen;
import com.surkemper.rain.graphics.Sprite;

public class WaterTile extends Tile{
	int style = 0;
	int counter = 0;

	public WaterTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		if (counter <75000)counter++;
		else counter = 0;
		if (counter < 25000){
			style = 1;
		}		
		else if (counter >= 25000 && counter <50000) style = 2;
		else style = 3;
		screen.renderWater(x << 4, y << 4, this, style);
	}
	public boolean solid(){
		return true;
	}
}

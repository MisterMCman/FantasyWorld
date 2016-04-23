package com.surkemper.rain.level;

import com.surkemper.rain.graphics.Screen;
import com.surkemper.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static Level spawn = new SpawnLevel("/levels/level2.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		//used to load a level from file
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	public void update() {
		//update level 60 times a second

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;//= wie /16 wegen TileSize nur schneller da bitwise
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}	
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height){
			return Tile.voidTile;
		}
		if (tiles[x + y * width] == Tile.col_grass) return Tile.grass;
		if (tiles[x + y * width] == Tile.col_flower) return Tile.flower;
		if (tiles[x + y * width] == Tile.col_rock) return Tile.rock;
		if (tiles[x + y * width] == Tile.col_water) return Tile.wave_2;
		if (tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if (tiles[x + y * width] == Tile.col_spawn_dirt) return Tile.spawn_dirt;
		if (tiles[x + y * width] == Tile.col_spawn_wall1) return Tile.spawn_wall1;
		if (tiles[x + y * width] == Tile.col_spawn_wall2) return Tile.spawn_wall2;
		if (tiles[x + y * width] == Tile.col_spawn_wall2_top_vertical) return Tile.spawn_wall2_top_vertical;
		if (tiles[x + y * width] == Tile.col_spawn_wall2_top_horizontal) return Tile.spawn_wall2_top_horizontal;
		
		//player 0xffFF0000
		//if (tilesInt[x + y * width] == 3) return Tile.water;

		return Tile.voidTile;
	}

}

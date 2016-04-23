package com.surkemper.rain.level.tile;

import com.surkemper.rain.graphics.Screen;
import com.surkemper.rain.graphics.Sprite;
import com.surkemper.rain.graphics.SpriteSheet;

public class Tile {
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile water = new WaterTile(Sprite.water);
	
	public static Tile spawn_grass = new GrassTile(Sprite.spawn_grass);
	public static Tile spawn_dirt = new DirtTile(Sprite.spawn_dirt);
	public static Tile spawn_wall1 = new WallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new WallTile(Sprite.spawn_wall2);
	public static Tile spawn_wall2_top_vertical = new WallTile(Sprite.spawn_wall2_top_vertical);
	public static Tile spawn_wall2_top_horizontal = new WallTile(Sprite.spawn_wall2_top_horizontal);
	
	/*
	 * Eigene
	 */
	public static Tile wave_1 = new WaterTile(Sprite.wave_1);
	public static Tile wave_2 = new WaterTile(Sprite.wave_2);
	public static Tile wave_3 = new WaterTile(Sprite.wave_3);
	
	public final static int col_spawn_grass = 0xff267F00;
	public final static int col_grass = 0xff00ff00;
	public final static int col_flower = 0xffffff00;
	public final static int col_rock = 0xff7f7f7f;
	public final static int col_water = 0xff0000ff;
	public final static int col_spawn_dirt = 0xff704800;
	public final static int col_spawn_wall1 = 0xff57007F;
	public final static int col_spawn_wall2 = 0xffcccccc;
	public final static int col_spawn_wall2_top_vertical = 0xff383838;
	public final static int col_spawn_wall2_top_horizontal = 0xff8D688E;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}

}

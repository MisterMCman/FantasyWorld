package com.surkemper.rain.graphics;

public class Sprite {
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 0x1b87e0);
	public static Sprite voidSprite = new Sprite(16, 0x000000);
	
	/*
	 * Eigen
	 */
	public static Sprite wave_1 = new Sprite(16, 3, 1, SpriteSheet.tiles);
	public static Sprite wave_2 = new Sprite(16, 2, 1, SpriteSheet.tiles);
	public static Sprite wave_3 = new Sprite(16, 4, 1, SpriteSheet.tiles);
	
	public static Sprite spawn_grass = new Sprite(16, 0, 4, SpriteSheet.tiles);
	public static Sprite spawn_dirt = new Sprite(16, 1, 2, SpriteSheet.tiles);
	public static Sprite spawn_wall1 = new Sprite(16, 1, 3, SpriteSheet.tiles);
	public static Sprite spawn_wall2_top_vertical = new Sprite(16, 1, 5, SpriteSheet.tiles);
	public static Sprite spawn_wall2_top_horizontal = new Sprite(16, 1, 6, SpriteSheet.tiles);
	public static Sprite spawn_wall2 = new Sprite(16, 1, 4, SpriteSheet.tiles);
	

	
	public static Sprite player_back = new Sprite(32, 1, 7, SpriteSheet.tiles);
	public static Sprite player_forward = new Sprite(32, 1, 4, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(32, 1, 6, SpriteSheet.tiles);
	
	public static Sprite player_forward_1 = new Sprite(32, 2, 4, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 0, 4, SpriteSheet.tiles);
	
	public static Sprite player_back_1 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	
	public static Sprite player_right_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	
	public static Sprite player_left_1 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_left_2 = new Sprite(32, 2, 5, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
		
	}
	public Sprite(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i< SIZE*SIZE; i++){
			pixels[i] = colour;
		}
		
	}

	private void load(){
		for (int y = 0; y < SIZE; y++){
			for (int x = 0; x < SIZE; x++){
				pixels[x+y*SIZE] = sheet.pixels[(x+ this.x) + (y+this.y)* sheet.SIZE];
			}
		}
	}

}

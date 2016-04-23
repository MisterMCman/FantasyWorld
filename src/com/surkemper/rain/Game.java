package com.surkemper.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.surkemper.rain.entity.mob.Player;
import com.surkemper.rain.graphics.Screen;
import com.surkemper.rain.input.Keyboard;
import com.surkemper.rain.input.Mouse;
import com.surkemper.rain.level.Level;
import com.surkemper.rain.level.RandomLevel;
import com.surkemper.rain.level.SpawnLevel;
import com.surkemper.rain.level.TileCoordinate;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static int width = 300;
	private static int height = width / 16 * 9; //16 zu 9 Auflösung 50625 pixel
	private static int scale = 3;
	public static String title = "Rain";

	private JFrame frame;
	private Thread thread;
	private Keyboard key;
	private Level level;
	private Player player;
	private boolean running = false;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); //converting image object into an array of integers, which can later be modified by color etc

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);

		frame = new JFrame();
		key = new Keyboard();
		TileCoordinate playerSpawn = new TileCoordinate(18, 74);
		level = Level.spawn;//new RandomLevel(64, 64);18, 74
		player = new Player(playerSpawn.x(), playerSpawn.y(), key, 0);
		player.init(level);
		
		addKeyListener(key);
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);

	}
	
	public static int getWindowWidth(){
		return width * scale;
	}
	
	public static int getWindowHeight(){
		return height * scale;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + "ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

//	int x = 0, y = 0;
//	int speed = 0;

	public void update() {
		key.update();
		player.update();
//		if (key.up == true){
//			y--;
//		}
//		if (key.down == true){
//			y++;
//		}
//		if (key.right == true){
//			x++;
//		}
//		if (key.left == true){
//			x--;
//		}
		
		
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll = player.x - screen.width/2;
		int yScroll = player.y - screen.height/2;
		
		level.render(xScroll, yScroll, screen);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		//
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setFont(new Font("Verdana", 0, 40));
		g.setColor(new Color(0x66ffffff, true));
		g.fillOval(Mouse.getX()-32, Mouse.getY()-32, 64, 64);
		g.setColor(Color.WHITE);
		if (Mouse.getButton() != -1)g.drawString("Button: " + Mouse.getButton(), 80, 80);
		g.drawString("X: " + player.x + ", Y: " + player.y, 550, 450);
		//
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}

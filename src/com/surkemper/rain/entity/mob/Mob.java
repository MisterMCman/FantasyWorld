package com.surkemper.rain.entity.mob;

import com.surkemper.rain.entity.Entity;
import com.surkemper.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 2; // 0 north, 1 east, 2 south, 3 west
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0){
			move(xa, 0);
			move(0, ya);
			return;
			
		}
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}
	
	protected void shoot(int x, int y, double dir){
		//dir = Math.toDegrees(dir);//dir * (180/ Math.PI);
		
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++){
			int xt;
			if(x + xa <= 0)x++;
			xt = ((x + xa) +c % 2 * 12 -7)/16;
			int yt = ((y + ya) +c / 2 * 12 +3)/16;
			if (level.getTile(xt, yt).solid()){
				solid = true;
			}
		}
		return solid;
	}

	public void render() {

	}

}

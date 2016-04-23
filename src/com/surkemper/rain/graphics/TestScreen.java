package com.surkemper.rain.graphics;

public class TestScreen {}

	/*private int width, height;
	public int[] pixels;
	public int counter = 0;
	public int x = 300 / 2;
	public int y = 168 / 2;
	public int position = 25350;
	public int size = 5;
	public int colour = 0x174ad4;

	public TestScreen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height]; // 50400
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render() {
		counter++;
		if (counter % 100 == 0) {
			clear();
			System.out.println(position);

			double zufall = Math.random();

			if (zufall < 0.25) {
				position += 5;

			}
			if (zufall > 0.25 && zufall < 0.5) {
				position -= 5;
			}

			if (zufall >= 0.5 && zufall < 0.75) {
				position += 5 * 300;
			}
			if (zufall >= 0.75) {
				position -= 5 * 300;
			}
			if (position < pixels.length - 1 && position >= 0) {
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						pixels[position + i +j*300] = colour;
						//out of bounds wenn zusätzliche size-pixel rand treffen abfangen durch -size etc 
					}
				}

			}

		}
		if (counter % 1000 == 0){
			colour = (int) (Math.random()*0xffffff);
		}

	}
}
*/
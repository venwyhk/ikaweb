package com.ikasoa.web.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ImageCaptchaUtil {

	private static char mapTable[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private static Random random = new Random();

	public static ImageCode getImageCode() {
		int width = 75;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(0, 0, width, height);
		graphics.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
		graphics.setColor(getRandColor(100, 200));
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			graphics.drawLine(x, y, x + xl, y + yl);
		}
		String strEnsure = "";
		for (int i = 0; i < 4; ++i) {
			strEnsure += mapTable[(int) (mapTable.length * Math.random())];
			graphics.setColor(new Color(20 + random.nextInt(100), 20 + random.nextInt(100), 20 + random.nextInt(100)));
			graphics.drawString(strEnsure.substring(i, i + 1), 12 * i + 15, 20);
		}
		graphics.dispose();
		return new ImageCode(image, strEnsure, LocalDateTime.now());
	}

	private static Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		return new Color(fc + random.nextInt(bc - fc), fc + random.nextInt(bc - fc), fc + random.nextInt(bc - fc));
	}

	@AllArgsConstructor
	@Data
	public class ImageCode {

		private BufferedImage image;

		private String value;

		private LocalDateTime time;

	}

}
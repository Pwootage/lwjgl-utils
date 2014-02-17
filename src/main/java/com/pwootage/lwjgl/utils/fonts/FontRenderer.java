package com.pwootage.lwjgl.utils.fonts;
import java.util.Scanner;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.ReadableColor;

import com.pwootage.lwjgl.utils.sprites.SpriteSheet;

/**
 * Represents a font renderer - this class contains static methods for rendering sprite-sheet based
 * fonts. Currently only really supports calibri64.png. Should be rewritten to use factory methods instead.
 * 
 * @author Pwootage
 * 
 */
public class FontRenderer {
	private static float	r;
	private static float	g;
	private static float	b;
	private static float	a;
	private static char[]	chars;
	private static int[]	charWidths;
	private static int		SPACE_WIDTH		= 16;
	private static int		CHAR_SPACING	= -1;
	private static float	scale			= 1;
	private static float	rot				= 0;
	
	static {
		chars = new char[256];
		for (char i = 0; i < 256; i++) {
			chars[i] = i;
		}
		Scanner s = new Scanner(ClassLoader.getSystemResourceAsStream("textures/calibri64widths.txt"));
		charWidths = new int[256];
		for (int i = 0; i < charWidths.length; i++) {
			charWidths[i] = Integer.parseInt(s.nextLine());
			if (charWidths[i] == 0) charWidths[i] = SPACE_WIDTH;
		}
		r = 1;
		g = 1;
		b = 1;
		a = 1;
		s.close();
	}
	
	/**
	 * Render a string
	 * 
	 * @param s
	 *            String to render
	 * @param posX
	 *            X Position to render at
	 * @param posY
	 *            Y Position to render at
	 * @param sprite
	 *            Spritesheet to use to render
	 * @return Length of the string
	 */
	public static int renderString(String s, float posX, float posY, SpriteSheet sprite) {
		GL11.glPushMatrix();
		GL11.glTranslatef(posX, posY, 0);
		GL11.glRotatef(rot, 0, 0, 1);
		GL11.glScalef(scale, scale, 1);
		int x = 0;
		int y = 0;
		char[] chars = s.toCharArray();
		int charPos;
		for (int i = 0; i < s.length(); i++) {
			charPos = getCharPos(chars[i]);
			renderChar(charPos, x, y, sprite);
			x += charWidths[charPos] + CHAR_SPACING;
		}
		GL11.glPopMatrix();
		return x;
	}
	
	/**
	 * Get the width of a string, if it were to be rendered
	 * 
	 * @param s
	 *            String to get the length of
	 * @return Length of the string provided
	 */
	public static int getStringWidth(String s) {
		int width = 0;
		char[] chars = s.toCharArray();
		int charPos;
		for (int i = 0; i < s.length(); i++) {
			charPos = getCharPos(chars[i]);
			width += charWidths[charPos] + CHAR_SPACING;
		}
		return width;
	}
	
	private static int getCharPos(char c) {
		int ret = 63; // Question mark!
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == c) {
				ret = i;
				break;
			}
		}
		// ret -= 16;
		return ret;
	}
	
	private static void renderChar(int c, int posX, int posY, SpriteSheet sprite) {
		GL11.glColor4f(r, g, b, a);
		sprite.renderFrame(c, posX, posY);
	}
	
	public static void setColor(ReadableColor color) {
	    r = ((float) color.getRed()) / 255.0f;
        g = ((float) color.getGreen()) / 255.0f;
        b = ((float) color.getBlue()) / 255.0f;
        a = ((float) color.getAlpha()) / 255.0f;
	}
	
	public static void setColor(int r, int g, int b, int a) {
	    FontRenderer.r = ((float) r) / 255.0f;
	    FontRenderer.g = ((float) g) / 255.0f;
	    FontRenderer.b = ((float) b) / 255.0f;
	    FontRenderer.a = ((float) a) / 255.0f;
	}
	
	public static void setColor(float r, float g, float b, float a) {
		FontRenderer.r = r;
		FontRenderer.g = g;
		FontRenderer.b = b;
		FontRenderer.a = a;
	}
	
	public static void setCharSpacing(int charSpacing) {
		FontRenderer.CHAR_SPACING = charSpacing;
	}
	
	public static void setScale(float scale) {
		FontRenderer.scale = scale;
	}
	
	public static void setRot(float rot) {
		FontRenderer.rot = rot;
	}
}
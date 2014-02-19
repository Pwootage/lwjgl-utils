package com.pwootage.lwjgl.utils.geometry;

import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import com.pwootage.lwjgl.utils.math.Vector2;

public class GeoLib {
	
	public static void drawQuad(Vector2 blPos, Vector2 trPos, Vector2 blTex, Vector2 trTex) {
		glTexCoord2f(blTex.getX(), blTex.getY());
		glVertex2f(blPos.getX(), blPos.getY());
		
		glTexCoord2f(trTex.getX(), blTex.getY());
		glVertex2f(trPos.getX(), blPos.getY());
		
		glTexCoord2f(trTex.getX(), trTex.getY());
		glVertex2f(trPos.getX(), trPos.getY());
		
		glTexCoord2f(blTex.getX(), trTex.getY());
		glVertex2f(blPos.getX(), trPos.getY());
	}
	
}

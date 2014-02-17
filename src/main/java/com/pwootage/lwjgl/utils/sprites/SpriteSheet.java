package com.pwootage.lwjgl.utils.sprites;

import com.pwootage.lwjgl.utils.textures.Texture;

/**
 * Represents a Sprite Sheet
 * 
 * @author Pwootage
 * 
 */
public class SpriteSheet {
	private Texture	texture;
	private int		frameWidth;
	private int		frameHeight;
	
	/**
	 * Create a spritesheet based on the texture provided
	 * 
	 * @param texture
	 *            Texture for this spritesheet
	 * @param frameWidth
	 *            Width of one frame on this spritesheet, in pixels
	 * @param frameHeight
	 *            Height of one frame on this spritesheet, in pixels
	 */
	public SpriteSheet(Texture texture, int frameWidth, int frameHeight) {
		this.texture = texture;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}
	
	/**
	 * Get the width of the texture
	 * 
	 * @return Width of the texture
	 */
	public int getTexWidth() {
		return texture.getWidth();
	}
	
	/**
	 * Get the height of the texture
	 * 
	 * @return Height of the texture
	 */
	public int getTexHeight() {
		return texture.getHeight();
	}
	
	/**
	 * Get the width of one frame
	 * 
	 * @return Width of one frame
	 */
	public int getFrameWidth() {
		return frameWidth;
	}
	
	/**
	 * Get the height of one frame
	 * 
	 * @return Height of one frame
	 */
	public int getFrameHeight() {
		return frameHeight;
	}
	
	/**
	 * Get the number of columns on this sprite sheet
	 * 
	 * @return Number of columns on this sprite sheet
	 */
	public int getNumCols() {
		return getTexWidth() / frameWidth;
	}
	
	/**
	 * Get the number of rows on this sprite sheet
	 * 
	 * @return Number of rows on this sprite sheet
	 */
	public int getNumRows() {
		return getTexHeight() / frameHeight;
	}
	
	/**
	 * Get the texture
	 * 
	 * @return Texture attached to this spritesheet
	 */
	public Texture getTexture() {
		return texture;
	}
	
	/**
	 * Set the texture
	 * 
	 * @param texture
	 *            Texture to attach to this spritesheet
	 */
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	/**
	 * Render one frame
	 * 
	 * @param index
	 *            1d index of the frame to be rendered
	 * @param xPos
	 *            X pos to render at
	 * @param yPos
	 *            Y pos to render at
	 */
	public void renderFrame(int index, float xPos, float yPos) {
		renderFrame(index, xPos, yPos, 0);
	}
	
	/**
	 * Render one frame
	 * 
	 * @param index
	 *            1d index of the frame to be rendered
	 * @param xPos
	 *            X pos to render at
	 * @param yPos
	 *            Y pos to render at
	 * @param rot
	 *            Rotation to render at (radians)s
	 */
	public void renderFrame(int index, float xPos, float yPos, float rot) {
		int x = index % getNumCols();
		int y = index / getNumCols();
		
		renderFrame(x, y, xPos, yPos, rot);
	}
	
	/**
	 * Render a frame centered at the position passed
	 * 
	 * @param index
	 *            1d index of the frame to render
	 * @param xPos
	 *            X position to render at
	 * @param yPos
	 *            Y position to render at
	 * @param rot
	 *            Rotation to render at (radians)
	 */
	public void renderFrameCentered(int index, float xPos, float yPos, float rot) {
		int x = index % getNumCols();
		int y = index / getNumCols();
		
		renderFrameCentered(x, y, xPos, yPos, rot);
	}
	
	/**
	 * Render one frame
	 * 
	 * @param frameX
	 *            X pos of frame to render
	 * @param frameY
	 *            Y pos of frame to render
	 * @param xPos
	 *            X pos to render at
	 * @param yPos
	 *            Y pos to render at
	 * @param rot
	 *            Rotation to render at (radians)
	 */
	public void renderFrame(int frameX, int frameY, float xPos, float yPos, float rot) {
		int x = frameX * frameWidth;
		int y = frameY * frameHeight;
		
		texture.render(xPos, yPos, x, y, frameWidth, frameHeight, rot);
	}
	
	/**
	 * Render one frame centered on the position passed
	 * 
	 * @param frameX
	 *            X pos of frame to render
	 * @param frameY
	 *            Y pos of frame to render
	 * @param xPos
	 *            X pos to render at
	 * @param yPos
	 *            Y pos to render at
	 * @param rot
	 *            Rotation to render at (radians)
	 */
	public void renderFrameCentered(int frameX, int frameY, float xPos, float yPos, float rot) {
		int x = frameX * frameWidth;
		int y = frameY * frameHeight;
		
		texture.renderCentered(xPos, yPos, x, y, frameWidth, frameHeight, rot);
	}
}
package com.pwootage.lwjgl.utils.math;

public class Vector2 {
	private float	posX;
	private float	posY;
	
	public Vector2() {
		this(0, 0);
	}
	
	public Vector2(float x, float y) {
		posX = x;
		posY = y;
	}
	
	public float getX() {
		return posX;
	}
	
	public float getY() {
		return posY;
	}
	
	public void setX(float x) {
		this.posX = x;
	}
	
	public void setY(float y) {
		this.posY = y;
	}
	
	public void setPos(float x, float y) {
		this.posX = x;
		this.posY = y;
	}
	
	public Vector2 add(Vector2 vec) {
		Vector2 ret = clone();
		ret.setX(ret.getX() + vec.getX());
		ret.setY(ret.getY() + vec.getY());
		return ret;
	}
	
	public Vector2 subtract(Vector2 vec) {
		Vector2 ret = clone();
		ret.setX(ret.getX() - vec.getX());
		ret.setY(ret.getY() - vec.getY());
		return ret;
	}
	
	public Vector2 scale(float factor) {
		Vector2 ret = clone();
		ret.setX(ret.getX() * factor);
		ret.setY(ret.getY() * factor);
		return ret;
	}
	
	public float length() {
		return (float) Math.sqrt(posX * posX + posY * posY);
	}
	
	public Vector2 normalized() {
		Vector2 ret = clone();
		float len = ret.length();
		ret.setX(ret.getX() / len);
		ret.setY(ret.getY() / len);
		return ret;
	}
	
	public Vector2 clone() {
		return new Vector2(posX, posY);
	}
	
	public String toString() {
		return "(" + posX + ", " + posY + ")";
	}
}

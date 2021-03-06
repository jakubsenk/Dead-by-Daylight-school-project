package com.senkgang.dbd.entities;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity
{
	protected double x, y;

	public Entity(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void setPos(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public abstract void update();

	public abstract void draw(GraphicsContext g, int camX, int camY);

}
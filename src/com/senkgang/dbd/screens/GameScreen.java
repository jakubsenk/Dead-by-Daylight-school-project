package com.senkgang.dbd.screens;

import java.awt.Graphics;

import com.senkgang.dbd.Handler;
import com.senkgang.dbd.map.Map;
import com.senkgang.dbd.map.maps.TestMap;

public class GameScreen extends Screen
{
	private Map map;

	public GameScreen(Handler h)
	{
		super(h);
		map = new TestMap(handler, 2500, 1500);
	}

	@Override
	public void update()
	{
		map.update();
	}

	@Override
	public void draw(Graphics g)
	{
		map.draw(g, handler.getGameCamera().getxOffset(), handler.getGameCamera().getyOffset());
	}

	public Map getMap()
	{
		return map;
	}
}
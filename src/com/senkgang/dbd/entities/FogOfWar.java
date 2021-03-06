package com.senkgang.dbd.entities;

import com.senkgang.dbd.Game;
import com.senkgang.dbd.Launcher;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FogOfWar
{
	private Player pl;

	public FogOfWar(Player p)
	{
		this.pl = p;
	}

	public void draw(GraphicsContext g, int camX, int camY)
	{
		if (pl == null) return;

		g.setFill(Color.GRAY);
		if (Launcher.isDebug) g.setFill(new Color(0.5, 0.5, 0.5, 0.8));

		double[] xPl = pl.getViewPolygonX();
		double[] yPl = pl.getViewPolygonY();

		if (xPl == null || xPl.length == 0) return;

		double[] xPol = new double[xPl.length + 6];
		double[] yPol = new double[xPl.length + 6];

		xPol[0] = 0;
		yPol[0] = 0;
		xPol[1] = 0;
		yPol[1] = Game.handler.getGame().getHeight();
		xPol[2] = Game.handler.getGame().getWidth();
		yPol[2] = Game.handler.getGame().getHeight();
		xPol[3] = Game.handler.getGame().getWidth();
		yPol[3] = 0;
		int i = 0;
		for (; i < xPl.length; i++)
		{
			xPol[i + 4] = xPl[i] - camX;
			yPol[i + 4] = yPl[i] - camY;
		}
		xPol[i + 4] = xPl[0] - camX;
		yPol[i + 4] = yPl[0] - camY;
		xPol[i + 5] = Game.handler.getGame().getWidth();
		yPol[i + 5] = 0;
		g.fillPolygon(xPol, yPol, xPol.length);

	}
}

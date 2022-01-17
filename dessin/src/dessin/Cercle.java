package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cercle extends ObjetGraphique
{
	private Point centre;
	private int rayon;
	
	public Cercle(Point centre,int rayon,boolean is_filled)
	{
		super(is_filled);
		this.centre=centre;
		this.rayon=rayon;
	}
	public Cercle(Point centre,int rayon,Color c,boolean is_filled)
	{
		super(c,is_filled);
		this.centre=centre;
		this.rayon=rayon;
	}
	@Override
	public void dessineToi(Graphics g) 
	{

		g.setColor(super.getCouleur());
		if(super.get_filled())
		{
			g.fillOval(this.centre.x-this.rayon, this.centre.y-this.rayon, this.rayon*2, 2*this.rayon);
		}
		else
		{
			g.drawOval(this.centre.x-this.rayon, this.centre.y-this.rayon, this.rayon*2, 2*this.rayon);
		}
		
		
	}
	@Override
	public boolean contient(int x, int y) 
	{
		return (x-this.centre.x)*(x-this.centre.x)+(y-this.centre.y)*(y-this.centre.y) <= this.rayon*this.rayon;
		
	}

}

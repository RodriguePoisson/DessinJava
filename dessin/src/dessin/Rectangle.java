package dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends ObjetGraphique
{
	private java.awt.Rectangle rectangle;
	private int x,y,largeur,hauteur;
	private Point p;
	public Rectangle(int x, int y, int largeur, int hauteur,boolean is_filled)
	{
		super(is_filled);
		this.x=x;
		this.y=y;
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.rectangle = new java.awt.Rectangle(this.x,this.y,this.hauteur,this.largeur);
	}
	
	public Rectangle(Point p, int largeur, int hauteur,boolean is_filled)
	{
		super(is_filled);
		this.p=p;
		this.largeur=largeur;
		this.hauteur=hauteur;
		this.rectangle = new java.awt.Rectangle(p,new Dimension(this.hauteur,this.largeur));
	}
	
	public Rectangle(Point p, int largeur,int hauteur,Color c,boolean is_filled)
	{
		super(c,is_filled);
		this.largeur=largeur;
		this.hauteur=hauteur;
		this.p = p;
		this.rectangle = new java.awt.Rectangle(p,new Dimension(this.hauteur,this.largeur));
	}
	
	public Rectangle()
	{
		super(false);
	}
	@Override
	public void dessineToi(Graphics g) 
	{
		g.setColor(super.getCouleur());
		if(super.get_filled())
		{
			g.fillRect(this.x, this.y, this.largeur, this.hauteur);
		}
		else
		{
			g.drawRect(this.x, this.y, this.largeur, this.hauteur);
		}
		
		
		
	}

	@Override
	public boolean contient(int x, int y) 
	{
		return (x>=this.x&& x<=x+this.largeur&&y>=this.y&&y<=this.y+this.hauteur);
	}

}

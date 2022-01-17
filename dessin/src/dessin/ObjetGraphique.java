package dessin;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
public abstract class ObjetGraphique extends Component
{
	private Color couleur;
	private boolean is_filled;
	
	public ObjetGraphique(boolean is_filled)
	{
		this.couleur = Color.black;
		this.is_filled = is_filled;
	}
	
	public ObjetGraphique(Color couleur,boolean is_filled)
	{
		this.couleur = couleur;
		this.is_filled = is_filled;
	}
	
	public void setColorRandom()
	{
		ArrayList<Color> listeColor = new ArrayList<Color>();
		listeColor.add(Color.black);
		listeColor.add(Color.blue);
		listeColor.add(Color.green);
		listeColor.add(Color.red);
		listeColor.add(Color.orange);
		listeColor.add(Color.white);

		Collections.shuffle(listeColor);
		this.couleur = listeColor.get(0);
	}
	public Color getCouleur() {return this.couleur;}
	
	public void setCouleur(Color couleur) {this.couleur =couleur;}
	
	public boolean get_filled() {return this.is_filled;}
	
	public void set_filled(boolean filled)
	{
		this.is_filled = filled;
	}
	
	public abstract void dessineToi(Graphics g);
	
	public abstract boolean contient(int x,int y);
}

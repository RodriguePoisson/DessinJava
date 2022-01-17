package dessin;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TotoJPanel extends JPanel
{
	private ArrayList<ObjetGraphique> listeObjet;
	
	public TotoJPanel(ArrayList<ObjetGraphique>listeObjet)
	{
		super();
		this.listeObjet = listeObjet;
		Toto.listeObjet = listeObjet;
	}
	@Override
	public void paintComponent(Graphics g)
	{
		for(ObjetGraphique objet : listeObjet)
		{
			if(objet.isVisible())
			{
				objet.dessineToi(g);
			}
			
		}

	}
	
	public ArrayList<ObjetGraphique> getListeObjet(){return listeObjet;}

}

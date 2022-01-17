package dessin;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TotoButton extends Container
{
	ArrayList<ObjetGraphique> liste_objet;
	Toto toto;
	public TotoButton(ArrayList<ObjetGraphique> liste_objet,Toto toto)
	{
		this.toto = toto;
		this.setLayout(new FlowLayout());
		this.liste_objet = liste_objet;
		int cpt = 1;
		for (ObjetGraphique obj : this.liste_objet)
		{
			JButton bouton = new JButton(String.valueOf(cpt));
			bouton.addActionListener(e->
			{
				if(obj.isVisible())
				{
					obj.setVisible(false);
				}
				else
				{
					obj.setVisible(true);
				}
				
				this.toto.redessine(this.liste_objet);
			});
			this.add(bouton);
			cpt++;
		}
	}
}

package dessin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Toto extends JFrame implements MouseListener
{
	public static ArrayList<ObjetGraphique>listeObjet;
	public Toto(String titre)
	{
		super(titre);
		this.setSize(400,400);
		this.addMouseListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void redessine(ArrayList<ObjetGraphique> listeObjet)
	{
		this.getContentPane().invalidate();
		this.getContentPane().removeAll();
		dessine(listeObjet);
		this.getContentPane().validate();
		this.getContentPane().repaint();
		
		
	}
	
	public void dessine(ArrayList<ObjetGraphique> listeObjet)
	{
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		TotoJPanel panel = new TotoJPanel(listeObjet);
		this.add(panel,BorderLayout.CENTER);
		TotoButton buttons = new TotoButton(listeObjet,this);
		JCheckBox filled_choice = new JCheckBox("is filled ?");
		//filled_choice.setSelected(true);
		filled_choice.addActionListener(e->
		{
			if(filled_choice.isSelected())
			{
				for(ObjetGraphique objet : this.listeObjet)
				{
					objet.set_filled(true) ;
				}
			}
			else
			{
				filled_choice.setSelected(false);
				for(ObjetGraphique objet : this.listeObjet)
				{
					objet.set_filled(false) ;
				}
			}
			this.redessine(this.listeObjet);
		});
		this.add(buttons,BorderLayout.SOUTH);
		this.add(filled_choice,BorderLayout.EAST);

		
	}
	public static void main(String[] args)
	{
		Toto toto = new Toto("test");
		ArrayList<ObjetGraphique> listeObjet = new ArrayList<ObjetGraphique>();
		
		listeObjet.add(new Cercle(new Point(160,150),20,true));
		listeObjet.add(new Cercle(new Point(200,200),20,true));
		listeObjet.add(new Cercle(new Point(240,150),20,true));
		listeObjet.add(new Rectangle(150,220,100,40,true));
		listeObjet.add(new Cercle(new Point(200,200),100,false));
		toto.dessine(listeObjet);
		toto.setVisible(true);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		System.out.println("appuyé "+e.getX()+" "+e.getY());
		for(ObjetGraphique objet : this.listeObjet)
		{
			
			if (objet.contient(e.getX(),e.getY()-40))
			{
				
				objet.setColorRandom();
				this.redessine(listeObjet);
				return;
				
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

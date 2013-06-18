package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class MenuNewView extends GameViewMenu
{
	//declaration des attributs adaptes a la page creation de nouvelles parties
	JLabel playernameLabel;
	JTextField playernameField;
	JButton okNewButton;
	private Color AFBlueColor = new Color(12,25,74);
	private Color KLMBlueColor = new Color(114,208,241);

	
	public MenuNewView()
	{
        playernameLabel = new JLabel("Votre nom :");
        playernameLabel.setSize(200, 30);
        playernameLabel.setLocation(frameWidth/2-100,150);
        
        playernameField = new JTextField();
        playernameField.setSize(200,30);
        playernameField.setLocation(frameWidth/2-100,250);
   	 	
   	 	okNewButton = new JButton("OK");
   	 	okNewButton.setSize(200,30);
   	 	okNewButton.setLocation(frameWidth/2-100, 350);
        okNewButton.setBackground(AFBlueColor);
        okNewButton.setForeground(KLMBlueColor);

   	 	
   	    //ajout des attributs avec l'index 1 pour etre en premier plan
        this.add(playernameLabel,new Integer(1));
   	 	this.add(playernameField,new Integer(1));
        this.add(okNewButton,new Integer(1));
        
	}
	
	public JTextField getPlayerNameField()
	{
		return playernameField;
	}
	
	public JButton getOkNewButton()
	{
		return okNewButton;
	}
	
}

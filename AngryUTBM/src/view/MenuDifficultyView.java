package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class MenuDifficultyView extends GameViewMenu
{

	//declaration des attributs adaptes a la page de choix de difficulte
	private JLabel difficultyLabel;
	private JButton easyButton, mediumButton, hardButton;
	private String parentPanel="";
	private Color AFBlueColor = new Color(12,25,74);
	private Color AFRedColor = new Color(248,0,0);
	private Color KLMBlueColor = new Color(114,208,241);

	public MenuDifficultyView()
	{
		
        difficultyLabel = new JLabel("Choose difficulty :");
        difficultyLabel.setSize(200, 30);
        difficultyLabel.setLocation(frameWidth/2-100,150);
		
        easyButton = new JButton("EASY");
        easyButton.setSize(200,30);
        easyButton.setLocation(frameWidth/2-100, 250);
        easyButton.setBackground(KLMBlueColor);
        easyButton.setForeground(Color.WHITE);

        mediumButton = new JButton("MEDIUM");
        mediumButton.setSize(200,30);
        mediumButton.setLocation(frameWidth/2-100, 325);
        mediumButton.setBackground(AFBlueColor);
        mediumButton.setForeground(Color.WHITE);

        
        hardButton = new JButton("HARD");
        hardButton.setSize(200,30);
        hardButton.setLocation(frameWidth/2-100, 400);
        hardButton.setBackground(AFRedColor);
        hardButton.setForeground(Color.WHITE);
        
        
        //ajout des attributs avec l'index 1 pour etre en premier plan
   	 	this.add(difficultyLabel,new Integer(1));
   	 	this.add(easyButton,new Integer(1));
   	 	this.add(mediumButton,new Integer(1));
   	 	this.add(hardButton,new Integer(1));
	}
	
	public JButton getEasyButton()
	{
		return easyButton;
	}
	
	public JButton getMediumButton()
	{
		return mediumButton;
	}
	
	public JButton getHardButton()
	{
		return hardButton;
	}
	
	
	public String getParentPanel()
	{
		return this.parentPanel;
	}
	
	public void setParentPanel(String parent)
	{
		this.parentPanel=parent;
	}
}

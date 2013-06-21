package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import model.LevelNumber;

@SuppressWarnings("serial")
public class MenuLevelView extends GameViewMenu
{
	//declaration des attributs adaptes a la page de choix de level
	private ArrayList<JButton> lvlButtons;
	private Color AFBlueColor = new Color(12,25,74);

	public MenuLevelView()
	{
        lvlButtons = new ArrayList<JButton>();
        
        //creation des differents boutons des niveaux
        for (int lvlNumber = 0; lvlNumber < LevelNumber.getLevelNumber(); ++lvlNumber) {
        	lvlButtons.add(new JButton("" + (lvlNumber+1)));
        	lvlButtons.get(lvlNumber).setSize(60,60);
        	int lineNumber = lvlNumber / 5;
        	lvlButtons.get(lvlNumber).setLocation(frameWidth/2-190+(lvlNumber%5)*80,frameHeight/2-80 + lineNumber*80);
        	lvlButtons.get(lvlNumber).setBackground(AFBlueColor);
        	lvlButtons.get(lvlNumber).setForeground(Color.WHITE);
        }
        
        //ajout des boutons avec un index d'1 pour etre en premier plan
   	 	for (JButton button : lvlButtons) {
   	 		this.add(button, new Integer(1));
   	 	}
		
	}
	
	public ArrayList<JButton> getLvlButtons()
	{
		return lvlButtons;
	}
}

package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Player implements Serializable {
	private String name;
	
	//scores par niveaux et difficultes
	private ArrayList<Integer> easyScores;
	private ArrayList<Integer> mediumScores;
	private ArrayList<Integer> hardScores;
	
	//meilleurs scores par niveaux et difficultes
	private ArrayList<Integer> highestEasyScores;
	private ArrayList<Integer> highestMediumScores;
	private ArrayList<Integer> highestHardScores;
	
	//niveaux debloques
	private ArrayList<Integer> easy;
	private ArrayList<Integer> medium;
	private ArrayList<Integer> hard;
	
	@SuppressWarnings("unused")
	private int levelNumber;

	//creation du joueur a partir son nom
	public Player(String name) {

		this.name = name;

		easy = new ArrayList<Integer>();
		medium = new ArrayList<Integer>();
		hard = new ArrayList<Integer>();
		
		easyScores = new ArrayList<Integer>();
		mediumScores = new ArrayList<Integer>();
		hardScores = new ArrayList<Integer>();
		
		highestEasyScores = new ArrayList<Integer>();
		highestMediumScores = new ArrayList<Integer>();
		highestHardScores = new ArrayList<Integer>();
		
		
		//permet de creer des listes de la bonne taille et ainsi d'eviter les OutOfBoundExceptions
		for (int i = 0; i < LevelNumber.getLevelNumber(); ++i) {
			easyScores.add(0);
			mediumScores.add(0);
			hardScores.add(0);
			
			highestEasyScores.add(0);
			highestMediumScores.add(0);
			highestHardScores.add(0);
			
		}
		
		//creation du fichier de sauvegarde
		this.save();
	}

	//chargement d'un joueur
	public static Player loadFromFile(String name) {
		try {
			FileInputStream fichier = new FileInputStream("save/" + name
					+ ".save");
			ObjectInputStream ois = new ObjectInputStream(fichier);
			Player player = (Player) ois.readObject(); //on lit l'objet Player du fichier
			return player;
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	//creation du fichier de sauvegarde
	public void save() {
		try {
			File file = new File("save/" + name + ".save");
			file.delete();
			file.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this); // on ecrit l'objet Player correspondant dans le fichier
			oos.flush();
			oos.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

	}
	
	public String toString() {
		return name;
	}

	//retourne le numero du dernier level debloque
	public boolean isFinished(int level, String difficulty) {
		if (difficulty.equals("easy")) {
			return easy.contains(level);
		} else if (difficulty.equals("normal")) {
			return medium.contains(level);
		} else if (difficulty.equals("hard")){
			return hard.contains(level);
		}
		return false;
	}

	//actualise le numero du dernier niveau debloque avec le score effectue
	public void finished(int level, String difficulty, int score) {
		if (difficulty.equals("easy")) {
			if (!(easy.contains(level)))
				easy.add(level);
			// l'index des levels de scoreEasy commence à 0
			easyScores.set(level-1, score);
			if (score > highestEasyScores.get(level-1))
				highestEasyScores.set(level-1, score);
			
		} else if (difficulty.equals("medium")) {
			if (!(medium.contains(level)))
				medium.add(level);
			mediumScores.set(level-1, score);
			if (score > highestMediumScores.get(level-1))
				highestMediumScores.set(level-1, score);
		} else if (difficulty.equals("hard")) {
			if ( !(hard.contains(level)))
				hard.add(level);
			hardScores.set(level-1, score);
			if (score > highestHardScores.get(level-1))
				highestHardScores.set(level-1, score);
		}
		save(); // actualisation de la sauvegarde
	}
	
	public String getName() {
		return name;
	}
	
	public int getHighestScore(String difficulty, int level) {
		if (difficulty.equals("easy")) {
			return highestEasyScores.get(level);
		} else if (difficulty.equals("medium")) {
			return highestMediumScores.get(level);
		} else if (difficulty.equals("hard")) {
			return highestHardScores.get(level);
		}
		return 0;
	}
}

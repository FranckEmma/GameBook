package model;

import java.util.*;

public class Paragraphe {
		
	private String text ;
	private Map<Integer,Choice> choices;
	/**
	 * Permet de creer un paragraph
	 * @param text
	 */
	public Paragraphe(final String text) {
		this.text= text;
		choices= new HashMap<>();
		
	}
	/**
	 * Permet d'ajouter un choix a un paragraph
	 * @param numChoice
	 * @param text
	 */
	 public void addChoice(final int numChoice, final String text) {
		 choices.put(numChoice, new Choice(text));
	 }
	
	/**
	 * retourn le text un paragraph
	 * @return
	 */
	public String getText() {
		return text;
	}
	/**
	 * Permet de modifier le text d'un paragraph
	 * @param text
	 */
	public void setText(String text) {
		this.text= text;
	}
}

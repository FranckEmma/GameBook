package model;

import java.util.Iterator;
import java.util.Map;
/**
 * 
 * @author tamko
 *
 */
public class Book implements Iterable<Paragraphe>{
	
	private String title;
	private Map<Integer, Paragraphe> paragraph ;
	/**
	 * Permet de cree un livre 
	 * @param title
	 */
	public Book(final String title) {
		this.title= title;
	}
	
	/**
	 * permet d'ajouter un paragraph au livre 
	 * @param numParagraph numero du paragraph 
	 * @param text text du paragraph 
	 */
	public void addParagraph(final int numParagraph , final String text) {
		paragraph.put(numParagraph, new Paragraphe(text));
	}
	public String getTitle() {
		return title;
	}
	/**
	 * permet de modifier le titre du livre
	 * @param title
	 */
	public void setTitle(final String title) {
		this.title= title;
	}
	/**
	 * Perme d'ajouter une choice a un paragraph 
	 * @param numParagraph numero du paragraph 
	 * @param numChoice numero du choice 
	 * @param textChoice description du choix 
	 */
	public void addChoice(final int numParagraph, final int numChoice, final String textChoice) {
		var para= getParagraph(numParagraph);
		para.addChoice(numChoice, textChoice);
	}
	/**
	 * Permet d'obtenir un paragraph sur base de sa key
	 * @param key
	 * @return
	 */
	public Paragraphe getParagraph(final int key) {
		return paragraph.get(key);
	}
	
	@Override
	public Iterator<Paragraphe> iterator() {
		
		return paragraph.values().iterator();
	}
}

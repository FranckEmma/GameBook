package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import imodel.IBook;
import imodel.IDisplayGraph;

/**
 * 
 * @author tamko
 *
 */
public class DisplayGraph implements IDisplayGraph{
	// Je choisi une List par ce que j'ai besion
	// de maintenir ma collection ordonnée et pas une Set parce je ne risque pas
	// d'avoir les doublons et que j'emprunte tourjour des chemins differents

	private Set<List<Integer>> parcours;
	private Set<Integer> firstItem; // parce que je ne veux pas avoir deux fois la meme action qui point vers le
									// même paragraph

	/**
	 * Permet d'initialiser les attributs
	 */
	public DisplayGraph() {
		parcours = new LinkedHashSet<List<Integer>>();
		firstItem = new LinkedHashSet<Integer>();// pour permetre de maintenir l'ordre lors de l'ajout d'un nouvelle
													// element
	}

	/**
	 * Permet de parcourir tout les direction de mon book Cette Methode me permet de
	 * determiner tous les chemins possible a partir du premier paragraph jusqu'a un
	 * paragraph qui n'a plus d'action
	 * 
	 * Dans le mellieur des cas on cosidere qu'on un noeud parent avec des enfant
	 * qui n'ont pas d'enfant la CTT de ma methode allDirection() est o(1) puis que
	 * on va juste parcourir les parents Dans le moyen des cas j'ai on a les enfants
	 * qui on les enfants la CTT est o(n) ou n est le nombre d'enfant pour chaque
	 * enfants. Dans le pire, la CTT va dependre des enfants je peux avoir des
	 * enfants qui ont des enfants ansi de suite du coup on aura N parent avec la
	 * possibilite d'avoir N enfant j'aurais P=>N^N ou P et N represente
	 * respectivement Parent et Enfant donc pour n fois parent on aura n fois enfant
	 * d'ou la CTT est O(P(E^E)) Et CTT des methode add, addAll et remove sont de 4
	 * fois O(N) dans le pire des cas . Donc la CTT de notre methode allDirection()
	 * est O(P(E^E)) + 4*O(N)
	 * 
	 * @param num
	 * @param temp
	 */
	private Set<List<Integer>> allDirection(final int num, final IBook book) {
		List<Integer> temp = new ArrayList<>();
		firstItem.add(num);
		final var allChoice = book.getNumOfActions(num);
		for (final var ch : allChoice) {
			if (book.isHasAction(ch)) {
				allDirection(ch, book);
			} else {
				temp.addAll(firstItem);
				temp.add(ch);
				parcours.add(temp);
				temp = new ArrayList<>();
			}
		}
		firstItem.remove(num);
		return new LinkedHashSet<List<Integer>>(parcours);
	}

	/**
	 * 
	 * @return
	 */
	private Set<List<Integer>> allDirection(final IBook book) {
		final Set<List<Integer>> allParcours = new LinkedHashSet<>();
		final var allNumber = new HashSet<>(book.getAllNumberOfPara());
		for (final Integer integer : allNumber) {
			allParcours.addAll(allDirection(integer, book));
		}
		return new LinkedHashSet<List<Integer>>(allParcours);
	}
/**
 * Permet d'afficher le book sous forme de grapg
 * @param book
 * @return
 */
	public String displayGraph(final IBook book) {
		final List<String> result = new ArrayList<String>();
		final Set<List<Integer>> set = allDirection(book);
		final Map<Integer, List<Integer>> keyMap = book.getNumParaAndListAction();
		displayAllPaths(result, set);
		displaySmallPaths(result, keyMap);
		return afficharge(result);
	}

	/**
	 * @param result
	 * @param map
	 */
	private void displaySmallPaths(final List<String> result,final  Map<Integer, List<Integer>> map) {
		for (final var key : map.keySet()) {
			String str = "§";
			final var value = new ArrayList<>(map.get(key));
			if (!value.isEmpty()) {
				for (final var num : value) {
					str += key + " => §" + num;
					result.add(str);
					str = "§";
				}
			} else {
				str += key;
				result.add(str);
			}
		}
	}

	/**
	 * @param result
	 * @param set
	 */
	private void displayAllPaths(final List<String> result,final  Set<List<Integer>> set) {
		for (final List<Integer> list : set) {
			if (list.size() > 2) {
				String str = "§";
				str += display(list);
				result.add(str);
			}
		}
	}

	private String afficharge(final List<String> result) {
		String chaine = "";
		for (final String str : result) {
			chaine += str + "\n" + "\n";
		}
		firstItem = new LinkedHashSet<Integer>();
		parcours = new LinkedHashSet<List<Integer>>();
		return chaine;
	}

	private String display(final List<Integer> list) {
		String str = "";
		for (int i = 0; i < list.size() - 1; i++) {
			str += list.get(i) + " => §";
		}
		str += list.get(list.size() - 1);
		return str;
	}
}

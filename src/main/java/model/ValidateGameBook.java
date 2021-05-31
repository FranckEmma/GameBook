package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import imodel.IBook;
import imodel.IValidateGameBook;

/**
 * Permet de verifier le book
 */
public class ValidateGameBook implements IValidateGameBook{

	private final Set<Integer> notActionOfStart;

	/**
	 * 
	 * je choisi L'interface set car je ne souhaite pas obtenir deux fois un meme
	 * numero de paragraph et pas une liste pasce que je ne souhaite obtenir un
	 * element sur base de son indice et je choisi d'implenter un HAshSet car la CTT
	 * de la methode add est o(1) dans le mellieur des cas et o(n) si toutes
	 * collisions
	 * 
	 * @param book
	 */
	public ValidateGameBook() {
		notActionOfStart = new HashSet<>();

	}
//	public void initValidate(Book book) {
//		this.book = book;
//	}

	/**
	 * permet de comparare deux listes en fin de determiner les elements manquant
	 * d'une liste. Pour Determiner les noeuds absent de tout action : j'ai stocké
	 * tous les numeros de paragraph das une Liste , stoké tous les choix dans une
	 * liste en efin retire tous les numero de paragraph contenu dans la liste et le
	 * numero restant seron ceux de non refferencé la CTT de la methode
	 * allNumberOfparagraph() est o(p) ou p repressente le nombre de pararagraph ,la
	 * CTT de la methode allNumberOfAction() est o(a) ou a reperesente le nombre
	 * d'action associe a un paragraph, la CTT de la methode remove() est o(n) ou n
	 * represente le nombre d'element dans ma liste et la CTT de la methode
	 * removeALL() est o(n*n) ou n represente le nombre d'element dans ma liste car
	 * s'il faut le fair pas pas j'ai une premiere boucle qui parcours ma liste de
	 * numero de paragraph donc p fois et la CTT methode contains est o(n) du coup
	 * pour juste la methode removeAll on a o(n*p) pour finir la CTt de notre
	 * methode noeudAbsent est o(p)+o(a)+o(n)+o(n*p)
	 * 
	 * @param listNumber liste de numero des paragraphs
	 * @param lisChoice  liste choic a comparare
	 * @return retourne la liste des elements manquant dans la lisChoice
	 */
	private List<Integer> noeudAbsent(final IBook book) {
		final Set<Integer> listNumberOfPara = new HashSet<>(book.getAllNumberOfPara());
		final List<Integer> lisChoice = book.allNumberOfAction();
		listNumberOfPara.remove(1);
		listNumberOfPara.removeAll(lisChoice);
		return new ArrayList<>(listNumberOfPara);
	}

	/**
	 * Permet de determiner les noeud inaccessible
	 * 
	 * @return Retourne la liste de noeud inaccesseible
	 */
	private List<Integer> terminalNodeUnreachable(final IBook book) {
		final List<Integer> nodeTerminal = new ArrayList<>(book.allTerminalNodeOfBook());
		terminalNodeFromBegining(1, book);
		nodeTerminal.removeAll(notActionOfStart);
		return new ArrayList<>(nodeTerminal);
	}

	
	/**
	 * Permet d'obtenir tous les noeuds terminaux parti du debut Pour cette methode
	 * j'obtenir tous les actions associer a un paragraph en fonction du premier
	 * numero de paragraph. Dans le mellieur des cas en cosiderant que je n'ai pas
	 * d'action pour les paragraph la CTT de ma methode terminalNodeFromBegining()
	 * est o(1) car je ne parcours par ma mes actions. Dans le moyen des cas j'ai
	 * les actions qui n'ont pas d'action la CTT est o(a) ou a est le nombre
	 * d'action. Dans le pire, la CTT va dependre des actions je peux avoir des
	 * actions qui ont des actions j'aurais o(a*a) ou avoir des actions qui ont des
	 * actions qui eux memes ont des actions etc cad o(a*a*a....*a) n fois action du
	 * coup on aura o(p(a^n)) ou n represente le nombre de fois que a aurais
	 * d'action et p le nombre de paragraph. Et CTT de la methode add dans le pire
	 * des cas est o(n) si tout collisions . Donc la CTT de notre methode
	 * terminalNodeFromBegining() est o(p(a^n))+o(n)
	 * 
	 * @param num
	 * 
	 */
	private void terminalNodeFromBegining(final int num, final IBook book) {
		final var allChoice = book.getNumOfActions(num);
		for (final var ch : allChoice) {
			if (book.isHasAction(ch)) {
				terminalNodeFromBegining(ch, book);
			} else {
				notActionOfStart.add(ch);
			}
		}

	}

	/**
	 * Permet d'afficher Nœuds absents de toute action et Nœuds terminaux
	 * inaccessibles à partir du début:
	 * 
	 * @return
	 */
	public String displayNoeud(final IBook book) {

		final var str1 = "Nœuds absents de toute action :";
		final var str2 = "Nœuds terminaux inaccessibles à partir du début:";
		final var nAb = noeudAbsent(book);
		final var nT = terminalNodeUnreachable(book);
		final var strNab = displayNoeud(nAb);
		final var strNt = displayNoeud(nT);

		return str1 + strNab + "\n" + str2 + strNt;
	}

	private String displayNoeud(final List<Integer> nAb) {
		var str = " ";
		for (final Integer integer : nAb) {
			str += integer + " ";
		}
		return str;
	}

}

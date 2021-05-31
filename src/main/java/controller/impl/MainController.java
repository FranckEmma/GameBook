package controller.impl;

import controller.Controller;
import imodel.IBook;
import imodel.IDisplayGraph;
import imodel.*;
import model.DisplayGraph;

import model.*;

import view.FXMLGameBookController;
import viewModel.*;


public class MainController implements Controller {

	private FXMLGameBookController fxControler;
	private IBook iBook;
	private int initPosPara;
	private ViewModel viewModel;
	private IValidateGameBook validate;
	private IDisplayGraph dg;
//	private CanSaveAndLoad loadAndSave;
//	private ExportJson saveJson;
	private String  message;
	public MainController( IBook ibook , IDisplayGraph graph, IValidateGameBook validate) {
		this.iBook= ibook;
		this.validate =validate;
		this.dg = graph;
		viewModel = new ViewModelBook(iBook,dg,validate);
//		loadAndSave =  new MySaverLoader();
//		saveJson = new SaveJson();
	}

	/**
	 * Permet de creer mon livre et mon viewmodel
	 * 
	 * @param title titre du livre
	 */
//	private void create(final String title) {
//		iBook = new MyBook(title);
//		viewModel.createBook(iBook);
//	}
	/**
	 * Permet de creer mon livre et mon viewmodel
	 * 
	 * @param title titre du livre
	 */
	private void create(final String title) {
		iBook.setTitle(title);
	}

//	private void displayGraph() {
//		dg.initGraph(getIBook());
//		//message=dg.displayGraph();
//	}
	/**
	 * Permet de creer un nouveau viewModel 
	 * @param ib
	 * @return
	 */
	private ViewModel getViewModel(IBook ib, IDisplayGraph graph, IValidateGameBook validate) {
		viewModel= new ViewModelBook(ib, graph, validate);
		return viewModel;
		
	}
//	private ViewModel getViewModel(IBook ib) {
//		viewModel.createBook(iBook);
//		
//		return viewModel;
//		
//	}
	/**
	 * Permet d'afficher les numero de paragraph non refferencé
	 * 
	 * @return
	 */

//	public void displayNoeud() {
//		validate.initValidate(iBook);
//		//message=validate.displayNoeud();
//	}

	/**
	 * Obtenire le nombre de paragraph dans le book
	 * 
	 * @return
	 */

	private int lenghtOfBook() {
		return iBook.length();
	}

//	@Override
//	public void validateNoeud() {
//		if (!isEmpty() && lenghtOfBook() > 0) {
//			displayNoeud();
//			fxControler.updateNoeud(viewModel);
//		} else if (isEmpty()) {
//			message="Livre par encore crée !";
//			fxControler.updateStatus(message);
//			return;
//		} else {
//			message="Aucun paragraph";
//			fxControler.updateStatus(message);
//			return;
//		}
//
//	}

//	@Override
//	public void showGraph() {
//		if (!isEmpty() && lenghtOfBook() > 0) {
//			displayGraph();
//			fxControler.updateGraph(viewModel);
//		} else if (isEmpty()) {
//			message="Livre par encore crée !";
//			fxControler.updateStatus(message);
//			return;
//		} else {
//			message="Aucun paragraph";
//			fxControler.updateStatus(message);
//			return;
//		}
//	}

	@Override
	public void setView(FXMLGameBookController fxView) {
		fxControler = fxView;
	}

	/**
	 * Permet d'obtenir le livre
	 * 
	 * @return return le livre
	 */
	private IBook getIBook() {
		return iBook;
	}

	/**
	 * Verifie le livre est vide ou pas
	 * 
	 * @return return vrai si le livre est vide faux dans le cas contraire
	 */
	private boolean isEmpty() {
		if (getIBook().getTitle().isBlank()) {
			message="Entre un titre de livre !";
			return true;
		}
		return false;
	}

	public ViewModel getViewModel() {
		return viewModel;
	}

	/**
	 * Permet d'initialise le message a affichier a la vu
	 * 
	 * @param msg message donnée
	 */
//	private void initMessage(String msg) {
//		messageView.setMessage(msg);
//	}

	@Override
	public void createBook(String strTitle) {
		if (strTitle.isBlank()) {
			message="Entre un titre de livre non vide  !";
			fxControler.updateStatus(message);
			return;
		}
		if (isEmpty()) {
			create(strTitle);
			message="Livre créer !";
		} else {
			iBook.setTitle(strTitle);
			message="titre Modifier!";
		}
		fxControler.updateTitle(getViewModel(),message);
	}

//	@Override
//	public void addParagraph(String text, String pos) {
//		if (isEmpty()) {
//			fxControler.updateStatus(message);
//			return;
//		}
//		if (isCorrectNumber(pos)) {
//			iBook.addParagraph(text, getPosInit());
//			message="Paragraphe ajouter !";
//			fxControler.updatePargraph(getViewModel(),message);
//		} else {
//			fxControler.updateStatus(message);
//			return;
//		}
//
//	}

	/**
	 * Permet d'obtenir le numero de paragraph saisi par l'utilisateur
	 * 
	 * @return return le numero saisi par l'utilisateur
	 */
	private int getPosInit() {
		return initPosPara;
	}

	/**
	 * Verifie si le nombre saisir par l'utilisateur est correct
	 * 
	 * @param position position donné
	 * @return vrai si le numero est correct et faux dans le cas contraire
	 */
	private boolean isCorrectNumber(String position) {

		if (!position.isBlank()) {
			if (!position.matches("^[+-]?\\d+$")) {
				message="Numero incorrect !";
				return false;
			}
		} else {
			initPosPara = 0;
			return true;
		}

		return numberPositif(Integer.parseInt(position));

	}

	/**
	 * Permet de verifier si le numero saisi par l'utilisateur est positif ou pas
	 * 
	 * @param numeroPara numero saisir
	 * @return return true si le numero est positif et faux dans le cas contraire
	 */
	private boolean numberPositif(int numeroPara) {
		if (numeroPara <= 0) {
			message="Le numéro doit être positif ! ";
			return false;
		}
		initPosPara = numeroPara;
		return true;
	}
//
//	@Override
//	public void displayParagraphAndAction(int numPara) {
//		fxControler.displayPargraphContentAndAction(numPara, getViewModel());
//
//	}
//
//	@Override
//	public void saveParagraph(int numPara, String str) {
//		if (!str.isBlank()) {
//			if (!iBook.saveParagraph(numPara, str)) {
//				message="selectionné un paragraph !";
//				return;
//			}
//			message="Paragraph save !";
//		} else {
//			message="Paragraph vide !";
//		}
//		fxControler.updateBook(numPara, getViewModel(),message);
//	}
//
//	@Override
//	public void deleteParagraph(int numPara) {
//		iBook.deleteParagraph(numPara);
//		message="Paragraph supprimer !";
//		fxControler.updateBook(numPara, getViewModel(),message);
//
//	}
//
//	@Override
//	public void displayTextAndNumberAction(int numPara, int numAct) {
//		fxControler.displayTextAndNumberAction(numPara, numAct, getViewModel());
//
//	}
//
//	@Override
//	public void addAction(int numPara, String textAct, int numDest) {
//		if (textAct.isBlank()) {
//			message="Champs d'action vide !";
//			fxControler.updateStatus(message);
//			return;
//		}
//		iBook.addAction(numPara, textAct, numDest);
//		message="Action ajouter !";
//		fxControler.updateBook(numPara, getViewModel(),message);
//	}
//
//	@Override
//	public void deleteAction(int numPara, int numAct) {
//		if (iBook.deleteAction(numPara, numAct)) {
//			message="Action supprimer !";
//		} else {
//			message="Selction un action a supprimer ! ";
//			fxControler.updateStatus(message);
//			return;
//		}
//
//		fxControler.updateBook(numPara, getViewModel(),message);
//	}
//
//	@Override
//	public void newAction(int numPara, String newPosAct, String newTextAction) {
//		if (!newPosAct.isBlank())
//			validerChaine(newPosAct);
//		if (iBook.newAction(numPara, newPosAct, newTextAction)) {
//			message="Action ajouter !";
//			fxControler.updateBook(numPara, getViewModel(),message);
//			return;
//		}
//		message="Entre une Position positif !";
//		fxControler.updateStatus(message);
//	}
//
//	/**
//	 * @param newPosAct
//	 */
//	private void validerChaine(String newPosAct) {
//		if (!newPosAct.matches("^[+-]?\\d+$")) {
//			message="Numero incorrect !";
//			fxControler.updateStatus(message);
//			return;
//		}
//	}
//
//	@Override
//	public void saveAction(int numPara, int numAct, String newPosAct, String newTextAction) {
//		if (!newPosAct.isBlank())
//			validerChaine(newPosAct);
//		if (iBook.saveAction(numPara, numAct, newPosAct, newTextAction)) {
//			fxControler.updateBook(numPara, getViewModel(),message);
//			return;
//		}
//		message="Entre une Position positif !";
//		fxControler.updateStatus(message);
//	}

//	@Override
//	public boolean loadBook(String path) {
//		IBook bookLoaded;
//		bookLoaded = loadAndSave.load(path);
//		if (bookLoaded != null) {
//			iBook = bookLoaded;
//			getViewModel(iBook,dg,validate);
//			return true;
//			
//		}
//		return false;
//	}

//	@Override
//	public boolean saveBook(String path) {
//		return loadAndSave.save(iBook, path);
//	}
//
//	@Override
//	public boolean saveBookToJson(String path) {
//		return saveJson.save(path, iBook);
//	}
	

}

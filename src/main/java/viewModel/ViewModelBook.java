package viewModel;

import java.util.List;
import java.util.Set;

import imodel.*;


public class ViewModelBook implements ViewModel {

	private IBook book;
	private IValidateGameBook validate;
	private IDisplayGraph dg;
	
	public ViewModelBook(IBook book, IDisplayGraph graph, IValidateGameBook validate) {
		this.book = book;
		this.validate =validate;
		this.dg = graph;
	}


	@Override
	public String getTitle() {
		return book.getTitle();
	}
	public String displayNoeud() {
		return validate.displayNoeud(book);
	}
	public String displayGraph() {
		return dg.displayGraph(book);
	}

	@Override
	public List<String> paragraphToString() {
		return book.getAllTextOfPara();
	}

	@Override
	public Set<Integer> allNumber() {

		return book.getAllNumberOfPara();
	}

	@Override
	public List<String> actionToString(int numPara) {

		return book.getAllTextOfAction(numPara);
	}

	@Override
	public String getTextOfParagraph(int numPara) {

		return book.getTextOfParagraphe(numPara);
	}

	@Override
	public int getNumberOfParagraph(int numPara) {
		//return book.getNumberOfParagraph(numPara);
		return numPara;
	}

	@Override
	public String getTextActionByNumber(int numPara, int numAct) {

		return book.getTextOfAction(numPara, numAct);
	}

//	@Override
//	public void initValidate(final IBook book) {
//		validate.validate(book);
//	}
//
//	public String displayNoeud(final IBook book) {
//		initValidate(book);
//		return displayNoeud();
//	}
}

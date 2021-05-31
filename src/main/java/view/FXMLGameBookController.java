package view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import viewModel.ViewModel;

public class FXMLGameBookController implements Initializable {

	@FXML
	private TextField newTitle;
	@FXML
	private TextField position;
	@FXML
	private TextField textDesc;
	@FXML
	private TextArea textModif;
	@FXML
	private TextField textPosition;
	@FXML
	private TextArea textContent;
	@FXML
	private TextArea paragraphContent;
	@FXML
	private Button addButton;
	@FXML
	private MenuItem load;
	@FXML
	private ComboBox<Integer> myCombobox;
	@FXML
	private ListView<String> vueEnListe;
	@FXML
	private ListView<String> listAction;
	@FXML
	private Label titre;
	@FXML
	private Label status;
	@FXML
	MenuItem check;

	private ObservableList<String> listeParagraph;
	private ObservableList<String> oListAction;
	private ObservableList<Integer> oCombo;
	private String selectChanged;
	private Controller mainControler;

	public FXMLGameBookController(Controller mainControler) {
		this.mainControler = mainControler;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listeParagraph = FXCollections.observableArrayList();
		oListAction = FXCollections.observableArrayList();
		oCombo = FXCollections.observableArrayList();

		vueEnListe.setItems(listeParagraph);
		myCombobox.setItems(oCombo);
		listAction.setItems(oListAction);
		paragraphContent.setWrapText(true);
		textContent.setWrapText(true);
		textModif.setWrapText(true);

	}

	@FXML
	public void createBook() {
		var strTitle = newTitle.getText().toUpperCase().trim();
		mainControler.createBook(strTitle);
		newTitle.clear();
	}

	public void updateTitle(ViewModel viewModel,String str) {
		titre.setText(viewModel.getTitle());
		status.setText(str);
	}

	public void updateStatus(String str) {
		status.setText(str);
	}

	@FXML
	public void addParagraph(ActionEvent even) {
		String text = textContent.getText().trim();
		String pos = position.getText().trim();
	//	mainControler.addParagraph(text, pos);
		clear();
	}

	public void updatePargraph(ViewModel viewModel, String str) {
		listeParagraph.clear();
		listeParagraph.addAll(viewModel.paragraphToString());
		oCombo.clear();
		oCombo.addAll(viewModel.allNumber());
		status.setText(str);
	}

	@FXML
	public void saveParagraph() {
		if (selectChanged == null)
			return;
		var str = paragraphContent.getText().trim();
		int numPara = extractNumber(selectChanged);
		//mainControler.saveParagraph(numPara, str);
		clear();
	}

	@FXML
	public void addAction() {
		var numDest = myCombobox.getSelectionModel().getSelectedItem();
		if (selectChanged == null || numDest == null)
			return;
		int numPara = extractNumber(selectChanged);
		String textAct = textDesc.getText().toString().trim();
	//	mainControler.addAction(numPara, textAct, numDest);
		textDesc.clear();
	}

	@FXML
	public void newAction() {
		if (selectChanged == null) {
			textModif.clear();
			textPosition.clear();
			return;
		}
		int numPara = extractNumber(selectChanged);
		var newPosAct = textPosition.getText().trim();
		var newTextAction = textModif.getText().trim();

	//	mainControler.newAction(numPara, newPosAct, newTextAction);
		textModif.clear();
		textPosition.clear();
	}

	@FXML
	public void selectChanged() {
		selectChanged = vueEnListe.getSelectionModel().getSelectedItem();
		if (selectChanged == null)
			return;
		int numPara = extractNumber(selectChanged);
	//	mainControler.displayParagraphAndAction(numPara);

	}

	public void displayPargraphContentAndAction(int numPara, ViewModel viewModel) {
		oListAction.clear();
		oListAction.addAll(viewModel.actionToString(numPara));
		paragraphContent.setText(viewModel.getTextOfParagraph(numPara));
		position.setText(String.valueOf(viewModel.getNumberOfParagraph(numPara)));
	}

	public void updateBook(int numPara, ViewModel viewModel, String str) {
		oListAction.clear();
		oListAction.addAll(viewModel.actionToString(numPara));
		updateTitle( viewModel, str);
		updatePargraph(viewModel, str);
	}

	@FXML
	public void selectActionChanged() {
		String actionChanged = listAction.getSelectionModel().getSelectedItem();
		if (selectChanged == null || actionChanged == null)
			return;
		int numPara = extractNumber(selectChanged);
		int numAct = extractNumber(actionChanged);
		//mainControler.displayTextAndNumberAction(numPara, numAct);

	}

	public void displayTextAndNumberAction(int numPara, int numAct, ViewModel viewModel) {
		textModif.setText(viewModel.getTextActionByNumber(numPara, numAct));
		textPosition.setText(String.valueOf(numAct));
	}

	/**
	 * @return
	 */
	private int extractNumber(String str) {
		String[] splitP = str.split("\\.", 0);
		int numPara = Integer.parseInt(splitP[0]);
		return numPara;
	}

	@FXML
	public void deleteAction() {
		String actionChanged = listAction.getSelectionModel().getSelectedItem();
		if (selectChanged == null || actionChanged == null)
			return;
		int numPara = extractNumber(selectChanged);
		int numAct = extractNumber(actionChanged);

	//	mainControler.deleteAction(numPara, numAct);
		textModif.clear();
		textPosition.clear();
	}

	@FXML
	public void deleteParagraph() {
		if (selectChanged == null)
			return;
		int numPara = extractNumber(selectChanged);
	//	mainControler.deleteParagraph(numPara);
		clear();
	}

	/**
	 * 
	 */
	private void clear() {
		textContent.clear();
		position.clear();
		paragraphContent.clear();
		selectChanged = null;
	}

	@FXML
	public void saveAction() {
		String actionChanged = listAction.getSelectionModel().getSelectedItem();
		if (selectChanged == null || actionChanged == null) {
			status.setText("Electionner un paragraph ou une action !");
			textModif.clear();
			textPosition.clear();
			return;
		}
		int numPara = extractNumber(selectChanged);
		int numAct = extractNumber(actionChanged);
		var newPosAct = textPosition.getText();
		var newTextAction = textModif.getText();
	//	mainControler.saveAction(numPara, numAct, newPosAct, newTextAction);
		textModif.clear();
		textPosition.clear();
	}

	@FXML
	public void newWindowValidate() {
	//	mainControler.validateNoeud();
	}

	@FXML
	public void newWindowshowGraph() {
		//mainControler.showGraph();
	}

	public void updateNoeudAndGraph(ViewModel viewModel) {
		

	}
	public void updateNoeud(ViewModel viewModel) {
		WindowValidateGameBook validate = new WindowValidateGameBook();
		
		validate.display("Game Book", viewModel.displayNoeud());
	}
	public void updateGraph(ViewModel viewModel) {
		WindowValidateGameBook validate = new WindowValidateGameBook();
	
		validate.display("Game Book", viewModel.displayGraph());
	}

	@FXML
	private void saveBook() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Sauver un livre-jeu");
		File f = fileChooser.showSaveDialog(position.getScene().getWindow());
		if (f != null) {
			//boolean b = mainControler.saveBook(f.getPath()); 
			if (false) 
				displayAlertMessage("Information", "Sauvegarde réussie", "Le livre-jeu a été correctement sauvegardé");
			else
				displayAlertMessage("Attention", "Echec de la sauvegarde", "Le livre-jeu n'a pas pu être sauvegardé");
		}
	}
	@FXML
	private void saveBookToJson() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Sauver un livre-jeu To Json");
		File f = fileChooser.showSaveDialog(position.getScene().getWindow());
		if (f != null) {
			boolean b =false;
		//	boolean b = mainControler.saveBookToJson(f.getPath()); 
			if (b) 
				displayAlertMessage("Information", "Sauvegarde réussie", "Le livre-jeu a été correctement sauvegardé");
			else
				displayAlertMessage("Attention", "Echec de la sauvegarde", "Le livre-jeu n'a pas pu être sauvegardé");
		}
	}

	@FXML
	private void loadBook() {
//		FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Charger un livre-jeu");
//		File f = fileChooser.showOpenDialog(position.getScene().getWindow());
//		if (f != null) {
//			boolean succeed = mainControler.loadBook(f.getPath());
//			if (succeed) {
//				displayAlertMessage("Information", "Chargement réussi", "Le livre-jeu a été correctement récupéré");
//				update(1,mainControler.getViewModel());
//			} else
//				displayAlertMessage("Attention", "Echec du chargement", "Le livre-jeu n'a pas pu être récupéré");
//		}
	}
//	private void update(int i, ViewModel viewModel) {
//		updateBook(1, viewModel,"Chargement réussi");
//		
//	}

	private void displayAlertMessage(String title, String header, String content) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
		}

	


}

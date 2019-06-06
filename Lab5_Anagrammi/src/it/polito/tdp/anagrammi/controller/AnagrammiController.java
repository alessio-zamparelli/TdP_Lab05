/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;

	public void setModel(Model model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtParola"
	private TextField txtParola; // Value injected by FXMLLoader

	@FXML // fx:id="txtCorrect"
	private TextArea txtCorrect; // Value injected by FXMLLoader

	@FXML // fx:id="txtWrong"
	private TextArea txtWrong; // Value injected by FXMLLoader

	@FXML
	void doCalcola(ActionEvent event) {

		txtCorrect.clear();
		txtWrong.clear();
		String parola = txtParola.getText();
		Set<String> soluzioni = model.calcolaAnagramma(parola);

	}

	@FXML
	void doReset(ActionEvent event) {
		txtParola.clear();
		txtCorrect.clear();
		txtWrong.clear();

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	}
}

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AnagrammiController {
	
	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private TextArea txtCorrect;

	@FXML
	private TextArea txtWrong;

	@FXML
	void doCalcolaAnagramma(ActionEvent event) {

		String parola = txtParola.getText();
		
		parola = parola.trim();
		
		if(parola.split(" ").length!=1) {
			txtCorrect.setText(String.format("Hai inserito %d parole, ne puoi inserire al massimo una per volta", parola.split("").length));
			return;
		}
		
		List<Anagramma> res = model.anagrammizza(txtParola.getText());
		
		for(Anagramma a:res ) {
			if(a.isCorrect())
				txtCorrect.appendText(a.getWord() + "\n");
			else
				txtWrong.appendText(a.getWord() + "\n");
		}
		
	}

	@FXML
	void doReset(ActionEvent event) {
		
		txtParola.clear();
		txtCorrect.clear();
		txtWrong.clear();

	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'Anagrammi.fxml'.";

		// Utilizzare questo font per incolonnare correttamente i dati
		txtCorrect.setStyle("-fx-font-family: monospace");
		txtCorrect.setFont(Font.font(null, FontWeight.BOLD, 12));
		txtWrong.setStyle("-fx-font-family: monospace");
		txtWrong.setFont(Font.font(null, FontWeight.BOLD, 12));

	}

	public void setModel(Model model) {
		this.model = model;
	}
}

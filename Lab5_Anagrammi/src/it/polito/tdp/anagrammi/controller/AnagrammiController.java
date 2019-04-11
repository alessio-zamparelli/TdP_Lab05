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
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AnagrammiController {

	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private Label lblnTot;

	@FXML
	private Label lblnCorr;

	@FXML
	private Label lblnWrong;

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

		if (parola.split(" ").length != 1) {
			txtCorrect.setText(String.format("Hai inserito %d parole, ne puoi inserire al massimo una per volta",
					parola.split("").length));
			return;
		}
		
		if(parola.length()>6) {
			txtCorrect.setText("Parola enorme, potrebbe non funzionare");
			txtWrong.setText("Parola enorme, potrebbe non funzionare");
		}

		List<Anagramma> res = model.anagrammizza2(txtParola.getText());

		txtCorrect.clear();
		txtWrong.clear();
		int c = 0, w = 0;
		System.out.println("Inizia la stampa");
		for (Anagramma a : res) {
			if (a.isCorrect()) {
				txtCorrect.appendText(a.getWord() + "\n");
				c++;
			}
			else {
				txtWrong.appendText(a.getWord() + "\n");
				w++;
			}
		}
		
		lblnCorr.setText(Integer.toString(c));
		lblnWrong.setText(Integer.toString(w));
		lblnTot.setText(Integer.toString(c+w) + " totali");
		
//		for (Anagramma a : res) {
//			if (a.isCorrect()) {
//				if (c < 1000) {
//					txtCorrect.appendText(a.getWord() + "\n");
//					c++;
//				} else if (c >= 1000 && c != -1) {
//					txtCorrect.appendText("And more...");
//					c = -1;
//				}
//			} else {
//				if (w < 1000) {
//					txtWrong.appendText(a.getWord() + "\n");
//					w++;
//				} else if (w >= 1000 && w != -1) {
//					txtWrong.appendText("And more...");
//					w = -1;
//				}
//			}
//
//			if (c + w > -2)
//				break;
//		}

	}

	@FXML
	void doReset(ActionEvent event) {

		txtParola.clear();
		txtCorrect.clear();
		txtWrong.clear();
		lblnCorr.setText("0");
		lblnWrong.setText("0");
		lblnTot.setText("0 totali");

	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert lblnTot != null : "fx:id=\"lblnTot\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert lblnCorr != null : "fx:id=\"lblnCorr\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert lblnWrong != null : "fx:id=\"lblnWrong\" was not injected: check your FXML file 'Anagrammi.fxml'.";
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

package it.polito.tdp.anagrammi.model;

public class Anagramma {

	private String word;
	private boolean correct;

	public Anagramma(String word, boolean correct) {
		super();
		this.word = word;
		this.correct = correct;
	}

	public String getWord() {
		return word;
	}

	public boolean isCorrect() {
		return correct;
	}

	@Override
	public String toString() {
		return String.format("Anagramma [word=%s, correct=%s]", word, correct);
	}

}

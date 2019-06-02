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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagramma other = (Anagramma) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

}

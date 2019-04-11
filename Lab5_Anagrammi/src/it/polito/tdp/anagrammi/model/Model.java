package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

@SuppressWarnings("unused")
public class Model {

	private List<String> anagrammi;

	/*
	 * per dare gli anagrammi della parola in ingresso {@code parola}
	 * 
	 * @return List<String> contenente tutti gli anagrammi
	 */
	public List<Anagramma> anagrammizza(String parola) {
		// i controlli li lascio al pubblico
		
		AnagrammaDAO dao = new AnagrammaDAO();

		anagrammi = new ArrayList<String>();

		magicFunction(parola, "");
		
		List<Anagramma> res = new ArrayList<>();
		
		for (String a : anagrammi) {
//			System.out.format("Controllo la correttezza di: %s\n", a);

			if (dao.isCorrect(a)) 
				res.add(new Anagramma(a, true));
			else
				res.add(new Anagramma(a, false));
		}

		return res;

	}

	public void magicFunction(String startWord, String currWord) {

		if (startWord.length() == 0) {
//			System.out.format("Trovato un anagramma: %s\n\n", currWord);
			anagrammi.add(currWord);
			return;
		}

		for (int i = 0; i < startWord.length(); i++) {
			String newCurrWord = currWord + startWord.charAt(i);
//			System.out.format("newCurrWord {%-10s}", newCurrWord);
			String newStartWord = startWord.substring(0, i) + startWord.substring(i + 1);
//			System.out.format(" :: {%-10s} newStartWord\n", newStartWord);
			magicFunction(newStartWord, newCurrWord);
		}

	}

	public static void main(String[] args) {
//		Model m = new Model();
//		List<String> res = m.anagrammizza("allakalbar");
//		System.out.format("La stringa è lunga: %d, mi aspetto %d risultati\n", "allakalbar".length(),
//				m.fact("allakalbar".length()));
//		System.out.format("Ho trovato %d anagrammi\n", res.size());
//		if(res.size()==m.fact("allakalbar".length()))
//			System.out.println("Giusto!");
//		else
//			System.out.println("Sbagliato");
//		res.stream().forEach(a->System.out.println(a));
	}

	private int fact(int number) {
		int i, fact = 1;
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		return fact;
	}

}

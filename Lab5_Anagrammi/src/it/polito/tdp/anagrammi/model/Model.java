package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

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

		System.out.format("Length: %d  ", parola.length());
		long start = System.nanoTime();
		magicFunction(parola, "");
		long finish = System.nanoTime();
		System.out.format("Search: %7.3f ms  ", (finish - start) / 1e6);

		List<Anagramma> res = new ArrayList<>();

		start = System.nanoTime();
		for (String a : anagrammi) {
//			System.out.format("Verify: %s\n", a);

			if (dao.isCorrect(a))
				res.add(new Anagramma(a, true));
			else
				res.add(new Anagramma(a, false));
		}
		finish = System.nanoTime();

		System.out.format("Verify: %10.3f ms\n", (finish - start) / 1e6);

		return res.stream().distinct().collect(Collectors.toList());

	}

	public List<Anagramma> anagrammizza2(String parola) {
		// i controlli li lascio al pubblico

		AnagrammaDAO dao = new AnagrammaDAO();

		anagrammi = new ArrayList<String>();

		System.out.format("Length: %d  ", parola.length());
		long start = System.nanoTime();
		magicFunction(parola, "");
		long finish = System.nanoTime();
		System.out.format("Search: %7.3f ms  ", (finish - start) / 1e6);

		start = System.nanoTime();
		List<Anagramma> res = dao.isCorrectImproved(anagrammi);
		finish = System.nanoTime();
		System.out.format("Verify: %10.3f ms\n", (finish - start) / 1e6);

		return res.stream().distinct().collect(Collectors.toList());

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
		Model m = new Model();
//		List<String> res = m.anagrammizza("allakalbar");
//		System.out.format("La stringa è lunga: %d, mi aspetto %d risultati\n", "allakalbar".length(),
//				m.fact("allakalbar".length()));
//		System.out.format("Ho trovato %d anagrammi\n", res.size());
//		if(res.size()==m.fact("allakalbar".length()))
//			System.out.println("Giusto!");
//		else
//			System.out.println("Sbagliato");
//		res.stream().forEach(a->System.out.println(a));

		String parola;
		List<Anagramma> res;

		// v2
		System.out.println("------V2------");
		parola = "ciao";
		res = m.anagrammizza2(parola);
		parola = "ciaod";
		res = m.anagrammizza2(parola);
		parola = "ciaotr";
		res = m.anagrammizza2(parola);
		parola = "ciao";
		res = m.anagrammizza2(parola);
		parola = "ciaod";
		res = m.anagrammizza2(parola);
		parola = "ciaotr";
		res = m.anagrammizza2(parola);
		parola = "ciaonfd";
		res = m.anagrammizza2(parola);
		parola = "ciaeonfd";
		res = m.anagrammizza2(parola);

		// v1
		System.out.println("------V1------");
		parola = "ciao";
		res = m.anagrammizza(parola);
		parola = "ciaod";
		res = m.anagrammizza(parola);
		parola = "ciaotr";
		res = m.anagrammizza(parola);
		parola = "ciao";
		res = m.anagrammizza(parola);
		parola = "ciaod";
		res = m.anagrammizza(parola);
		parola = "ciaotr";
		res = m.anagrammizza(parola);
		parola = "ciaonfd";
		res = m.anagrammizza(parola);
		parola = "ciaeonfd";
		res = m.anagrammizza(parola);

		System.out.println("-----DONE-----");

	}

	private int fact(int number) {
		int i, fact = 1;
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		return fact;
	}

}

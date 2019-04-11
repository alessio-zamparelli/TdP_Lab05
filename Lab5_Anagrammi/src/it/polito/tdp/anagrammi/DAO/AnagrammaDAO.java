package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DBConnect;
import it.polito.tdp.anagrammi.model.Anagramma;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {

		final String sql = "SELECT * FROM parola p WHERE p.nome LIKE ?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			boolean res = false;

			if (rs.next())
				res = true;

			conn.close();
			return res;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}

	}

	public List<Anagramma> isCorrectImproved(List<String> anagrammi) {

		final String sql = "SELECT * FROM parola p WHERE p.nome LIKE ?";

		List<Anagramma> res = new ArrayList<Anagramma>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			for (String s : anagrammi) {

				st.setString(1, s);

				ResultSet rs = st.executeQuery();

				if (rs.next())
					res.add(new Anagramma(s, true));
				else
					res.add(new Anagramma(s, false));

			}

			conn.close();
			
			return res;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}

	}

}

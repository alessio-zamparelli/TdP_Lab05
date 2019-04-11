package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.db.DBConnect;

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

}

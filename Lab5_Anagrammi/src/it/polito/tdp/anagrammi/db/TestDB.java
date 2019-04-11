package it.polito.tdp.anagrammi.db;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;
import it.polito.tdp.anagrammi.db.DBConnect;;

public class TestDB {

	public static void main(String[] args) {
		
		TestDB m = new TestDB();
		m.run();
		
	}
	
	@SuppressWarnings({ "static-access", "unused" })
	public void run() {
		DBConnect conn = new DBConnect();
		conn.getConnection();
		if (conn != null)
			System.out.println("Success");
		else
			System.out.println("epic fail boia faus!!!");
		
		
		AnagrammaDAO dao = new AnagrammaDAO();

		System.out.println(dao.isCorrect("ciao"));		//si
		System.out.println(dao.isCorrect("fiaygifye"));	//no
		System.out.println(dao.isCorrect("bellazic"));	//no
		System.out.println(dao.isCorrect("bella"));		//si
		System.out.println(dao.isCorrect("figa"));		//boh, a quanto pare si! ahahha
	}
	
	

}

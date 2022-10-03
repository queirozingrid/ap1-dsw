package database;

import java.util.ArrayList;
import java.util.List;

import model.Pagamento;

public class BancoDeDados {
	
	public static List<Pagamento> bd = new ArrayList<Pagamento>();
	
	public static void insert(Pagamento pagamento) {
		bd.add(pagamento);
	}

}

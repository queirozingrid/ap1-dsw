package model;

public class Main {
	
	public static void main(String[] args) {
		Pagamento pagamento = new BoletoBancario(123, "joao", "miguel");
		
		BoletoBancario boleto = (BoletoBancario) pagamento;
		
		System.out.println(boleto.getValor());
		
		Pagamento pagamento2 = (Pagamento) boleto;
		System.out.println(pagamento2.getBeneficiario());
	}

}

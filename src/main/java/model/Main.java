package model;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
//		Pagamento pagamento = new BoletoBancario(123, "joao", "miguel");
//		
//		BoletoBancario boleto = (BoletoBancario) pagamento;
//		
//		System.out.println(boleto.getValor());
//		
//		Pagamento pagamento2 = (Pagamento) boleto;
//		System.out.println(pagamento2.getBeneficiario());
        
        for(int i = 0; i<5; i++) {
        	Random geradorNumero = new Random();
            int numeroSorteado = geradorNumero.nextInt(1, 5);
            
            System.out.println(numeroSorteado);
        }
	}

}

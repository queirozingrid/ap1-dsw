package model;

public class BoletoBancario extends Pagamento{

	private String codigoBarra;
	
	public BoletoBancario() {}

	public BoletoBancario(String codigoBarra) {
		super();
		this.codigoBarra = codigoBarra;
	}
	
	public BoletoBancario(double valor, String beneficiario, String pagador) {
		super(valor, beneficiario, pagador);
		// TODO Auto-generated constructor stub
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

}

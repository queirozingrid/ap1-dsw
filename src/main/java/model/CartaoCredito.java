package model;

public class CartaoCredito extends Pagamento{
	
	// Número do cartão
	private String numero;
	
	// Quantidade de parcelas para
	// o pagamento em questão
	private int quantidadeParcelas;
	
	public CartaoCredito() {}

	public CartaoCredito (String numero, int quantidadeParcelas) {
		super();
		this.numero = numero;
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public CartaoCredito(double valor, String beneficiario, String pagador) {
		super(valor, beneficiario, pagador);
		// TODO Auto-generated constructor stub
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

}

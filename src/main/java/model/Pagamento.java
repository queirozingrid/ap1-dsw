package model;

public class Pagamento {
	private double valor;
	private String beneficiario;
	private String pagador;
	
	public Pagamento() {}

	public Pagamento(double valor, String beneficiario, String pagador) {
		this.valor = valor;
		this.beneficiario = beneficiario;
		this.pagador = pagador;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getPagador() {
		return pagador;
	}
	public void setPagador(String pagador) {
		this.pagador = pagador;
	}

}

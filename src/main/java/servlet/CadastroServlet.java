package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BancoDeDados;
import model.BoletoBancario;
import model.CartaoCredito;
import model.Pagamento;

@WebServlet(urlPatterns = "/cadastrar")
public class CadastroServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String metodoPagamento = req.getParameter("metodoPagamento");

		double valor = Double.parseDouble(req.getParameter("valor"));
		String beneficiario = req.getParameter("beneficiario");
		String pagador = req.getParameter("pagador");
		
		BoletoBancario boleto = new BoletoBancario();
		CartaoCredito cartao = new CartaoCredito();
		
				
		// Cria um pagamento do tipo solicitado no request (boleto ou cartão)
		if(metodoPagamento.equals("boleto")) {
			metodoPagamento = "Boleto Bancário";
			Pagamento pagamentoBoleto = new BoletoBancario(valor, beneficiario, pagador);
			boleto = (BoletoBancario) pagamentoBoleto;
			boleto.setCodigoBarra("123456789");
			
			BancoDeDados.insert(boleto);

		} else if(metodoPagamento.equals("cartao")) {
			metodoPagamento = "Cartão de Crédito";
			Pagamento pagamentoCartao = new CartaoCredito(valor, beneficiario, pagador);
			cartao = (CartaoCredito) pagamentoCartao;
			cartao.setNumero("1234 5678 9123 4567");
			cartao.setQuantidadeParcelas(8);
			
			BancoDeDados.insert(cartao);
		}


		// Devolver os dados dinamicamente para o usuário
		PrintWriter out = resp.getWriter();
		out.write(""
					+ "<head>"
					+ 		"<title>Dados</title>"
					+ 		"<link rel='stylesheet' href='./resources/css/main.css'>"
					+ "</head>"
					+ "<div class='dynamic-container'>"
					+ 	"<div class='text-box'>"
					+		"<h1>Dados cadastrados</h1>"
					+ 	"</div>"
					+	"<div class='div-list'>"
					+		"<ol class='list'>"
		);
		for (Pagamento p : BancoDeDados.bd) {
			if (p instanceof BoletoBancario) {
				metodoPagamento = "Boleto Bancário";
			} else {
				metodoPagamento = "Cartão de Crédito";
			}
			out.write(""
					+ "<li class='li'>"
					+ 		"<label class='label'>Beneficiário: "+ p.getBeneficiario() +" "
					+ 			"| Pagador: " + p.getPagador() + " "
					+ 			"| Valor: " + p.getValor() + " " 
					+			"| Método de pagamento: " + metodoPagamento + "</label>"
					+ 	"</li>"
			);
		}
		out.write(""
				+ 		"</ol>"
				+ 	"</div>"
				+		"<a href='./index.html'><button class='btn-voltar'>Voltar</button></a>"
				+ "</div>"
		);
	}

}

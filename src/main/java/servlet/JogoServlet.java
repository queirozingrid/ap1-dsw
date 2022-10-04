package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/jogar")
public class JogoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int numeroDigitado = Integer.parseInt(req.getParameter("numeroDigitado"));
		List<Integer> numerosSorteados = new ArrayList<Integer>();
		
		PrintWriter out = resp.getWriter();
		out.write(""
				+ "<head>"
				+ 		"<title>Resultado</title>"
				+ 		"<link rel='stylesheet' href='./resources/css/main.css'>"
				+ "</head>"
		);
		
		for(int i = 0; i<5; i++) {
        	Random geradorNumero = new Random();
            int numeroSorteado = geradorNumero.nextInt(1, 5);

            numerosSorteados.add(numeroSorteado);
        }
		
		  if(numerosSorteados.contains(numeroDigitado)) {
			  out = resp.getWriter();
			  out.write(""
	     				+ "<div class='dynamic-container'>"
	     				+	"<div class='text-box'>"
	 					+		"<h1>Parabéns, você acertou!!!</h1>"
	     		);    	
          } else {
	         	out = resp.getWriter();
	     		out.write(""
	     				+ "<div class='dynamic-container'>"
	     				+	"<div class='text-box'>"
	 					+		"<h1>Não foi dessa vez, tente novamente!</h1>"

	     		);
         }
		out.write("		<a href='./index.html'><button class='btn-voltar'>Voltar</button></a>"
				+ 	"</div>"
				+ "</div>");
	}

}

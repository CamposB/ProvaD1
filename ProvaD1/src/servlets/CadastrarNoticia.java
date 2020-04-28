package servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;
@WebServlet("/CadastrarNoticia.do")
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Data
		Random r = new Random();
		int id = r.nextInt(25);
		String titulo = request.getParameter("titulo");
		String desc = request.getParameter("desc");
		String texto = request.getParameter("texto");
		
		//New Noticia
		Noticia n = new Noticia(id, titulo, desc, texto);
		
		//Insert Data
		NoticiaService.cadastrarService(n);
		
	}

}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;

import service.NoticiaService;
import model.Noticia;

@WebServlet("/ListarNoticias.do")
public class ListarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <Noticia> listagem = NoticiaService.listarNoticias();
		String listar = "<hr>";
		for (Iterator iterator = listagem.iterator(); iterator.hasNext();){

			Noticia n = (Noticia) iterator.next(); 
			listar += "<h4>" + n.getTitulo() + " ID: "+  n.getId() + "</h4><br>";
			listar += "<h5>" + n.getDescricao() + "</h5><br>"; 
			listar += "<p>" + n.getText() + "<p><br>"; 
			listar += "<form name=\"id\" action=\"AbrirNoticia.do\" method=\"value="+ n.getId() +"/get\" value="+ n.getId() +">";
			listar += "<input name=\"id\" type=\"text\" readonly class=\"form-control-plaintext\" id=\"staticEmail2\" value="+ n.getId() +">" + "<br> <br>";
			listar += "<button type=\"submit\" class=\"btn btn-primary\" >Abrir id "+ n.getId()+"</button>";
			listar += "</form>";
			listar += "<hr>";
			
		}
		request.setAttribute("noticia", listar);
		RequestDispatcher view = 
		request.getRequestDispatcher("listar.jsp");
		view.forward(request, response);
	}
 
	
}

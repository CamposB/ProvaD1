package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

@WebServlet("/Comentar.do")
public class Comentar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String nome = request.getParameter("nome");
		String texto = request.getParameter("texto");
        HttpSession session = request.getSession();
         int idNoticia  = (int) session.getAttribute("id");
		request.getAttribute("id");
		Noticia n = NoticiaService.buscarService(idNoticia);
		Comentario c = new Comentario(nome, texto, idNoticia);
		ComentarioService.comentarService(c);
		ArrayList <Comentario> listagem = ComentarioService.listarComentarios(idNoticia);
		String listar = "";
		for (Iterator iterator = listagem.iterator(); iterator.hasNext();){
			Comentario cN = (Comentario) iterator.next(); 
			listar += "<h5>" + cN.getNome() + "</h5><br>";
			listar += "<p>" + cN.getText() + "<p><br>"; 
			listar += "<hr>";
		}


		


		
        request.setAttribute("noticia", n);
        request.setAttribute("comentario", listar);
        session = request.getSession();
        session.setAttribute("id", n.getId());
        RequestDispatcher view = 
        request.getRequestDispatcher("exibir.jsp");
        view.forward(request, response);
		
	}

}

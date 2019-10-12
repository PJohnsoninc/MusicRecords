package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumList;

/**
 * Servlet implementation class addAlbumServlet
 */
@WebServlet("/addAlbumServlet")
public class addAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String artist = request.getParameter("artist");
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		AlbumList al = new AlbumList(artist, title, year, LocalDate.now());
		AlbumListHelper alh = new AlbumListHelper();
		alh.insertAlbum(al);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

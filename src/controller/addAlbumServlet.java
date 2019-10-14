package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumList;
import model.Artists;
import model.Genres;

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
		
		String artistName = request.getParameter("artist");
		String artistDescription = request.getParameter("artist_description");
		String title = request.getParameter("title");
		String genreName = request.getParameter("genre");
		String genre_description = request.getParameter("genre_description");
		String year = request.getParameter("year");
		
		Artists artist = new Artists(artistName, artistDescription);
		Genres genre = new Genres(genreName, genre_description);
		AlbumList al = new AlbumList(artist, genre, title, year, LocalDate.now());
		AlbumListHelper alh = new AlbumListHelper();
		alh.insertAlbum(al);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

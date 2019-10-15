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
 * Servlet implementation class editAlbumServlet
 */
@WebServlet("/editAlbumServlet")
public class editAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editAlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AlbumListHelper alh = new AlbumListHelper();
		
		String artistName = request.getParameter("artist_name");
		String artistDescription = request.getParameter("artist_description");
		String title = request.getParameter("title");
		String genreName = request.getParameter("genre_name");
		String genreDescription = request.getParameter("genre_description");
		String year = request.getParameter("year");
		Long tempId = Long.parseLong(request.getParameter("id"));
		Artists artist = new Artists(artistName, artistDescription);
		Genres genre = new Genres(genreName,genreDescription);
		
		AlbumList albumToEdit = alh.searchForAlbumById(tempId);
		
		request.setAttribute("albumToEdit", albumToEdit);
		
		albumToEdit.setArtist(artist);
		albumToEdit.setGenres(genre);
		albumToEdit.setTitle(title);
		albumToEdit.setTitle(year);
		
		alh.updateAlbum(albumToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllAlbumsServlet").forward(request, response);
	}

}

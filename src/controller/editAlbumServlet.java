package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumList;

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
		// TODO Auto-generated method stub
		
		
		AlbumListHelper alh = new AlbumListHelper();
		
		String artist = request.getParameter("artist");
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		AlbumList albumToUpdate = alh.searchForAlbumById(tempId);
		albumToUpdate.setArtist(artist);
		albumToUpdate.setTitle(title);
		albumToUpdate.setYear(year);
		
		alh.updateAlbum(albumToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAlbumsServlet").forward(request, response);
	}

}
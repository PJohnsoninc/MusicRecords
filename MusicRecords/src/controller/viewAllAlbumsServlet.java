package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumList;

/**
 * Servlet implementation class viewAllAlbumsServlet
 */
@WebServlet("/viewAllAlbumsServlet")
public class viewAllAlbumsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllAlbumsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AlbumListHelper alh = new AlbumListHelper();		
	    request.setAttribute("allAlbums", alh.showAllAlbums());	
	    
		if(alh.showAllAlbums().isEmpty()) {
			request.setAttribute("allAlbums", "");
			
		}
		/*the redirect instruction was nested inside of the if statement that would only run
		if there was no items in the list.  But there was items in the list.  So it was never
		redirecting to album-list.jsp with the allAlbums list.
		*/
		getServletContext().getRequestDispatcher("/album-list.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

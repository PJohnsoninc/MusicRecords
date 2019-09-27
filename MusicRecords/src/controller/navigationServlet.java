package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumList;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		String act = request.getParameter("doThisToAlbum");
		if (act == null) {
			         // no button has been selected
			getServletContext().getRequestDispatcher("/viewAllAlbumsServlet").forward(request, response);
			
		} else if (act.equals("delete")) {
			
			try {
			     Integer tempId = Integer.parseInt(request.getParameter("id"));
			     AlbumList albumToDelete = alh.searchForAlbumById(tempId);
			     alh.deleteAlbum(albumToDelete);
			
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
			     getServletContext().getRequestDispatcher("/viewAllAlbumsServlet").forward(request, response);
			}
			
		} else if (act.equals("edit")) {
			try {
			     Integer tempId = Integer.parseInt(request.getParameter("id"));
			     AlbumList albumToEdit = alh.searchForAlbumById(tempId);
			     request.setAttribute("albumToEdit",  albumToEdit);
			     getServletContext().getRequestDispatcher("/edit-album.jsp").forward(request, response);
			
			} catch (NumberFormatException e) {
				 getServletContext().getRequestDispatcher("/viewAllAlbumsServlet").forward(request, response);
			}
		
		} else if (act.equals("add")) {
			 getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}

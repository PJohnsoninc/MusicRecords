package view;

import java.util.List;

import controller.GenresHelper;
import model.Genres;

public class GenereTester {

	public static void main(String[] args) {
		
		GenresHelper gh = new GenresHelper();
		Genres genre = new Genres("Rock", "none");
		Genres genre2 = new Genres("Rocke", "none");
		
//		gh.insertGenre(genre);
//		gh.insertGenre(genre2);
//		
		List<Genres> lgens = gh.showAllGenres();
//		for(Genres gen : lgens) {
//			System.out.println(gen.toString());			
//		}
//		
//		System.out.println("************");		
//		
//		gh.deleteGenre(genre);
//		gh.deleteGenre(genre2);
		
		for(Genres gen : lgens) {
			System.out.println(gen.toString());			
		}
	}
}

package view;

import java.util.List;

import controller.ArtistHelper;
import model.Artists;

public class ArtistTester {

public static void main(String[] args) {
		
		ArtistHelper ah = new ArtistHelper();
//		Artists artist = new Artists("Beyonce", "none");
//		Artists artist2 = new Artists("Camila", "none");
		
//		ah.insertArtist(artist);
		List<Artists> lartist = ah.showAllArtists();
//		for(Genres gen : lgens) {
//			System.out.println(gen.toString());			
//		}
//		
//		System.out.println("************");		
//		
//		gh.deleteGenre(genre);
//		gh.deleteGenre(genre2);
		
		for(Artists a : lartist) {
			System.out.println(a.toString());			
		}
	}

}

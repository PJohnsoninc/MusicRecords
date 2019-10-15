package view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.AlbumListHelper;
import model.AlbumList;
import model.Artists;
import model.Genres;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static AlbumListHelper alh = new AlbumListHelper();

		private static void addAlbum() {
			//create an Artist
			System.out.print("Enter artist to add: ");
			String artistName = in.nextLine();
			System.out.print("Enter description to add to artist: ");
			String artistDescription = in.nextLine();
			//create Genre
			System.out.print("Enter genre to add: ");
			String genreName = in.nextLine();
			System.out.print("Enter description to add to genre: ");
			String genreDescription = in.nextLine();
			//create Album
			System.out.print("Enter title to add to album: ");
			String title = in.nextLine();
			System.out.print("Enter year to add to album: ");
			String year = in.nextLine();
			
			Artists artist = new Artists(artistName, artistDescription);
			Genres genre = new Genres(genreName, genreDescription);	
			AlbumList toAdd = new AlbumList(artist, genre, title, year, LocalDate.now());
			
			alh.insertAlbum(toAdd);
		}

		private static void deleteAlbum() {
		
			System.out.print("Enter album title to delete: ");
			String title = in.nextLine();
			System.out.print("Enter year to delete: ");
			String year = in.nextLine();
		}

		private static void editAlbum() {
			
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Artist");
			System.out.println("2 : Search by Title");
			System.out.println("3 : Search by Year");
			int searchBy = in.nextInt();
			in.nextLine();
			List<AlbumList> foundAlbums;
			if (searchBy == 1) {
				System.out.print("Enter the artist name: ");
				String artistName = in.nextLine();
				foundAlbums = alh.searchForAlbumByArtist(artistName);
				
			} else if (searchBy == 2) {
				System.out.print("Enter the title: ");
				String titleName = in.nextLine();
				foundAlbums = alh.searchForAlbumsByTitle(titleName);
			} else {
				System.out.print("Enter the year: ");
				String yearName = in.nextLine();
				foundAlbums = alh.searchForAlbumsByYear(yearName);
			}

			if (!foundAlbums.isEmpty()) {
				System.out.println("Found Results.");
				for (AlbumList l : foundAlbums) {
//					System.out.println(l.getId() + " : " + l.getArtist().toString() + " : " + l.getTitle().toString() + " : " + l.getYear().toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				AlbumList toEdit = alh.searchForAlbumById(idToEdit);
				System.out.println("Retrieved " + toEdit.getArtist() + " and " + toEdit.getTitle() + " and " + toEdit.getYear());
				System.out.println("1 : Update Artist");
				System.out.println("2 : Update Title");
				System.out.println("3 : Update Year");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Artist: ");
					String newArtist = in.nextLine();
//					toEdit.setArtist(newArtist);
				} else if (update == 2) {
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 3) {
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				}
				alh.updateAlbum(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("   Hello.  Welcome to Album Inventory.     ");
			System.out.println("-------------------------------------------");
			while (goAgain) {
				System.out.println(">> Selection <<");
				System.out.println("   1 -- Add album");
				System.out.println("   2 -- Delete album");
				System.out.println("   3 -- Edit album");
				System.out.println("   4 -- View album list");
				System.out.println("   5 -- Exit program");
				System.out.println(" ");
				System.out.print("Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAlbum();
				} else if (selection == 2) {
					deleteAlbum();
				} else if (selection == 3) {
					editAlbum();
				} else if (selection == 4) {
					viewAlbumList();
				} else {
					alh.cleanUp();
					System.out.println("   Goodbye. Have a good day.   ");
					goAgain = false;
				}

			}

		}

		private static void viewAlbumList() {
			
			List<AlbumList>allAlbums = alh.showAllAlbums();
			for(AlbumList singleAlbum : allAlbums) {
				System.out.println(singleAlbum.toString());			
			}
		}

	}


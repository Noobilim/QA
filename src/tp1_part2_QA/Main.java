package tp1_part2_QA;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {

	public static void main( String[] args ) {

		ArrayList<String> infosFichier = new ArrayList<String>();

		List<String> stringClients = new ArrayList<String>();
		List<String> stringPlats = new ArrayList<String>();
		List<String> stringComm = new ArrayList<String>();

		ArrayList<Client> listeClients = new ArrayList<Client>();
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		ArrayList<Commande> listeCommandes = new ArrayList<Commande>();

		try {
			File myObj = new File( "fichier.txt" );
			Scanner myReader = new Scanner( myObj );

			while ( myReader.hasNextLine() ) {
				infosFichier.add( myReader.nextLine() );
			}
			myReader.close();
		} catch ( FileNotFoundException e ) {
			System.out.println( "Erreur dans la lecture du fichier!" );
			e.printStackTrace();
		}

		int indexPlats = 0;
		int indexComm = 0;

		for ( int i = 0; i < infosFichier.size(); i++ ) {

			if ( infosFichier.get( i ).contains( "Plats :" ) ) {
				indexPlats = i;
				stringClients = infosFichier.subList( 1, i );

			} else if ( infosFichier.get( i ).contains( "Commandes :" ) ) {
				indexComm = i;
				stringPlats = infosFichier.subList( indexPlats + 1, i );

			} else {
				stringComm = infosFichier.subList( indexComm + 1, infosFichier.size() - 1 );
			}

		}

		for ( int i = 0; i < stringClients.size(); i++ ) {
			listeClients.add( new Client( stringClients.get( i ) ) );
		}

		for ( int i = 0; i < stringPlats.size(); i++ ) {
			listePlats.add( new Plat( stringPlats.get( i ).split( " " )[0],
					Double.parseDouble( stringPlats.get( i ).split( " " )[1] ) ) );
		}

		for ( int i = 0; i < stringComm.size(); i++ ) {
			listeCommandes.add( new Commande( stringComm.get( i ).split( " " )[0], stringComm.get( i ).split( " " )[1],
					Integer.parseInt( stringComm.get( i ).split( " " )[2] ) ) );
		}

		System.out.println( "Bienvenue chez Barette!" );
		System.out.println( "Factures:" );

		for ( int k = 0; k < listeClients.size(); k++ ) {
			
			double prix = 0;

			for ( int i = 0; i < listeCommandes.size(); i++ ) {
				
				if ( listeCommandes.get( i ).getName().equals( listeClients.get( k ).getName() ) ) {
					
					for ( int j = 0; j < listePlats.size(); j++ ) {
						
						if ( listeCommandes.get( i ).getPlat().equals( listePlats.get( j ).getName() ) ) {
							
							prix += ( listePlats.get( j ).getPrix() * listeCommandes.get( i ).getQuantite() );
						}
					}
				}
			}
			System.out.println(
					listeClients.get( k ).getName() + " " + new DecimalFormat( "0.00" ).format( prix ) + "$" );
		}
	}
}
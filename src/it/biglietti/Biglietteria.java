package it.biglietti;

import java.time.LocalDate;
import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		int km, eta, flessibileInput;
		boolean flessibile = false;
		Scanner input = new Scanner(System.in);
		System.out.print("Inserire km:");
		km = input.nextInt();
		System.out.print("Inserire eta: ");
		eta = input.nextInt();
		System.out.print("Digitare 1 per acquistare un biglietto flessibile altrimenti digitare 2");
		flessibileInput = input.nextInt();
		if (flessibileInput == 1) {
			flessibile = true;
		}
		Biglietto biglietto = new Biglietto(km, eta, LocalDate.now(), flessibile);
		try {
			biglietto.isValidKm();
		}catch (Exception e) {
			System.out.println("Si e' verificato un errore: " + e.getMessage());
		}
		try {
			biglietto.isValidEta();
		}catch (Exception eD) {
			System.out.println("Si e' verificato un errore: " + eD.getMessage());
		}
		
		input.close();
		
		System.out.println("Prezzo: $" + biglietto.calcolaPrezzo());
		System.out.println("Data di scadenza: " + biglietto.calcolaDataScadenza());
	}

	

}

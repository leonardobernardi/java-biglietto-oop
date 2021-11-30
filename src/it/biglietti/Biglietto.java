// Lavoro svolto nella room 2
package it.biglietti;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class Biglietto {

	private int km, eta;
	private LocalDate data;
	private boolean flessibile;
	
	private final BigDecimal COSTO_PER_KM = new BigDecimal(0.21);
	private final BigDecimal SCONTO_OVER = new BigDecimal(0.4);
	private final BigDecimal SCONTO_UNDER = new BigDecimal(0.2);
	private final BigDecimal EXTRA = new BigDecimal(0.1);
	private final int DURATA_NORMALE = 30;
	private final int DURATA_FLESSIBILE = 90;
	 
	public Biglietto(int km, int eta, LocalDate data, boolean flessibile) {
		this.km = km;
		this.eta = eta;
		this.data = data;
		this.flessibile = flessibile;
	}
	
	 public boolean isValidKm() throws Exception {
		 if(km <= 0) {
			 throw new Exception("Km not valid");
		 } return true;
	 }
	 public boolean isValidEta() throws Exception {
		 if(eta <= 0) {
			 throw new Exception("Eta not valid");
		 } return true;
	 }
	 
	 private BigDecimal calcolaSconto() {
		 if (eta < 18) {
			 return SCONTO_UNDER;
		 } 
		 if (eta > 65) {
			 return SCONTO_OVER; 
		 } 
		 return new BigDecimal(0);
	 }
	 
	 public BigDecimal calcolaPrezzo() {
		 MathContext context = new MathContext(3);
		 BigDecimal kmBD = new BigDecimal(km);
		 BigDecimal costo = COSTO_PER_KM.multiply(kmBD);
		 BigDecimal sconto = costo.multiply(calcolaSconto());
		 BigDecimal extra = costo.multiply(EXTRA);
		 if (!flessibile) {
			 return costo.subtract(sconto,context);
		 }
		 return costo.subtract(sconto).add(extra, context); 
	 }
	 
	 public LocalDate calcolaDataScadenza() {
		 if (!flessibile) {
			 return LocalDate.now().plusDays(DURATA_NORMALE);
		 }
		 return LocalDate.now().plusDays(DURATA_FLESSIBILE);
	 }

}

package application;

/**
 * Berechnet das Formelrad
 * 
 * @author Tyler Storz, Nico Leemann
 * @version 01.11.2019
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;

	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}

	public double getLeistung() {
		return leistung;
	}

	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + ", spannung=" + spannung + ", strom=" + strom + ", widerstand="
				+ widerstand + "]";
	}

	public void calculate() {
		/*
		 * Hier auf Grund der vorhanden Werte entscheiden welche Methode unten
		 * aufgerufen werden muss.
		 */
	}

	/* Hier die Methoden mit den Formlen */

	/* p berechnen */

	public double pAusUUndI(double u, double i) {
		return u * i;
	}

	public double pAusRUndI(double r, double i) {
		return r * (i * i);
	}

	public double pAusUUndR(double u, double r) {
		return (u * u) / r;
	}

	/* u berechnen */

	public double uAusRundI(double r, double i) {
		return r * i;
	}

	public double uAusPundI(double p, double i) {
		return p / i;
	}

	public double uAusPundR(double p, double r) {
		return Math.sqrt(p * r);
	}
	
	/* r berechnen */

	public double rAusUundI(double u, double i) {
		return u / i;
	}

	public double rAusPundI(double p, double i) {
		return p / Math.pow(i, 2);
	}

	public double rAusUundP(double u, double p) {
		return Math.pow(u, 2) / p;
	}
	
	/* I berechnen */
	
	public double iAusUUndR(double u, double r) {
		return u/r;
	}
	
	public double iAusPUndU(double p, double u) {
		return p/u;
	}
	
	public double iAusPUndR(double p, double r) {
		return Math.sqrt(p/r);
	}
}

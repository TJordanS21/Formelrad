package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	private final static Logger LOGGER = Logger.getLogger(Calculator.class.getName());

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
		LOGGER.setLevel(Level.INFO);

		if ((leistung != 0.0 && spannung != 0.0 && strom != 0.0)
				|| (leistung != 0.0 && spannung != 0.0 && widerstand != 0.0)
				|| (widerstand != 0.0 && spannung != 0.0 && strom != 0.0)
				|| (widerstand != 0.0 && leistung != 0.0 && strom != 0.0)) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Zu viele Angaben");
			alert.setContentText("Bitte nicht mehr als 2 Groessen eingeben!!!!");
			alert.showAndWait();
			LOGGER.warning("Zu viele Angaben");
		} else {
			if (leistung != 0.0 && spannung != 0.0) {
				LOGGER.info("I wird aus P und U berechnet");
				strom = iAusPUndU(leistung, spannung);
				LOGGER.info("R wird aus U und P berechnet");
				widerstand = rAusUundP(spannung, leistung);
			} else if (leistung != 0.0 && strom != 0.0) {
				LOGGER.info("U wird aus P und I berechnet");
				spannung = uAusPundI(leistung, strom);
				LOGGER.info("R wird aus P und I berechnet");
				widerstand = rAusPundI(leistung, strom);
			} else if (leistung != 0.0 && widerstand != 0.0) {
				LOGGER.info("U wird aus P und R berechnet");
				spannung = uAusPundR(leistung, widerstand);
				LOGGER.info("I wird aus P und R berechnet");
				strom = iAusPUndR(leistung, widerstand);
			} else if (spannung != 0.0 && widerstand != 0.0) {
				LOGGER.info("P wird aus U und R berechnet");
				leistung = pAusUUndR(spannung, widerstand);
				LOGGER.info("I wird aus U und R berechnet");
				strom = iAusUUndR(spannung, widerstand);
			} else if (spannung != 0.0 && strom != 0.0) {
				LOGGER.info("P wird aus U und I berechnet");
				leistung = pAusUUndI(spannung, strom);
				LOGGER.info("R wird aus U und I berechnet");
				widerstand = rAusUundI(spannung, strom);
			} else if (widerstand != 0.0 && strom != 0.0) {
				LOGGER.info("P wird aus R und I berechnet");
				leistung = pAusRUndI(widerstand, strom);
				LOGGER.info("U wird aus R und I berechnet");
				spannung = uAusRundI(widerstand, strom);

			}
		}
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
		return u / r;
	}

	public double iAusPUndU(double p, double u) {
		return p / u;
	}

	public double iAusPUndR(double p, double r) {
		return Math.sqrt(p / r);
	}
}

package controllers;

import java.util.ArrayList;

import models.TourDuLich;

public class CtrlTourDuLich {
	public static ArrayList<TourDuLich> locTourTongHopTheoChuoi(ArrayList<TourDuLich> dsIn, String txt) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			if(tour.toString().matches("^"+txt+"$")) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	public static ArrayList<TourDuLich> locTourTheoMa(ArrayList<TourDuLich> dsIn, String ma) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			if(tour.toString().matches("^"+ma+"$")) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
}

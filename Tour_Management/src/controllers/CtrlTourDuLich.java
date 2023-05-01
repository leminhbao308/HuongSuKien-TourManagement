package controllers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.text.List;

import DAO.DAO_TourDuLich;
import entity.TourDuLich;

public class CtrlTourDuLich {
	public static ArrayList<TourDuLich> locTourTongHopTheoChuoi(ArrayList<TourDuLich> dsIn, String txt) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			Pattern pa = Pattern.compile(".*" + txt + ".*");
			Matcher ma = pa.matcher(tour.toString());
			if(ma.matches()) {
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
	
	public static void main(String[] args) {
		System.out.println("----------------------");
		ArrayList<TourDuLich> ds = new ArrayList<TourDuLich>();
		ds = DAO_TourDuLich.getAllTourDuLich();
		for (TourDuLich t: ds ) {
			System.out.println(t.toString());
		}
		System.out.println("----------------------");
		ArrayList<TourDuLich> dsr = new ArrayList<TourDuLich>();
		dsr = locTourTongHopTheoChuoi(ds, "Hội An");
		for (TourDuLich t: dsr) {
			System.out.println(t.toString());
		}
		System.out.println("----------------------");
	}
}

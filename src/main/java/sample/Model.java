package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("restriction")
public class Model extends Observable {

	private StringProperty etat;
	private DoubleProperty score;

	private DoubleProperty propc1;
	private DoubleProperty propc2;
	private DoubleProperty propc3;
	private DoubleProperty propc4;

	private DoubleProperty propc5;
	private DoubleProperty propc6;
	private DoubleProperty propc7;
	private DoubleProperty propc8;

	private DoubleProperty propc9;
	private DoubleProperty propc10;
	private DoubleProperty propc11;
	private DoubleProperty propc12;

	private DoubleProperty propc13;
	private DoubleProperty propc14;
	private DoubleProperty propc15;
	private DoubleProperty propc16;

	private ArrayList<DoubleProperty> tabList;

	private HashMap<Integer, DoubleProperty> hashMapDoubleProperty;

	// Fonction de set de valeur d'une property
	// Notifie le changement à son observer, le controller - Liaison model - controller
	public void setValuePropc(DoubleProperty d, double val) {
		(hashMapDoubleProperty.get(d.hashCode())).setValue(val);
		setChanged();
		notifyObservers(hashMapDoubleProperty.get(d.hashCode()));
	}

	/*
	 * Getters et setters
	 */

	public HashMap<Integer, DoubleProperty> getHashMapDoubleProperty() {
		return hashMapDoubleProperty;
	}

	public void setHashMapDoubleProperty() {
		hashMapDoubleProperty = new HashMap<Integer, DoubleProperty>();
		hashMapDoubleProperty.put(propc1.hashCode(), propc1);
		hashMapDoubleProperty.put(propc2.hashCode(), propc2);
		hashMapDoubleProperty.put(propc3.hashCode(), propc3);
		hashMapDoubleProperty.put(propc4.hashCode(), propc4);
		hashMapDoubleProperty.put(propc5.hashCode(), propc5);
		hashMapDoubleProperty.put(propc6.hashCode(), propc6);
		hashMapDoubleProperty.put(propc7.hashCode(), propc7);
		hashMapDoubleProperty.put(propc8.hashCode(), propc8);
		hashMapDoubleProperty.put(propc9.hashCode(), propc9);
		hashMapDoubleProperty.put(propc10.hashCode(), propc10);
		hashMapDoubleProperty.put(propc11.hashCode(), propc11);
		hashMapDoubleProperty.put(propc12.hashCode(), propc12);
		hashMapDoubleProperty.put(propc13.hashCode(), propc13);
		hashMapDoubleProperty.put(propc14.hashCode(), propc14);
		hashMapDoubleProperty.put(propc15.hashCode(), propc15);
		hashMapDoubleProperty.put(propc16.hashCode(), propc16);
	}

	public ArrayList<DoubleProperty> getTabList() {
		return tabList;
	}

	public void setTabList() {
		tabList = new ArrayList<DoubleProperty>();
		tabList.add(propc1);
		tabList.add(propc2);
		tabList.add(propc3);
		tabList.add(propc4);
		tabList.add(propc5);
		tabList.add(propc6);
		tabList.add(propc7);
		tabList.add(propc8);
		tabList.add(propc9);
		tabList.add(propc10);
		tabList.add(propc11);
		tabList.add(propc12);
		tabList.add(propc13);
		tabList.add(propc14);
		tabList.add(propc15);
		tabList.add(propc16);
	}

	public StringProperty getEtat() {
		return etat;
	}
	public void setEtat(StringProperty etat) {
		this.etat = etat;
	}
	public DoubleProperty getScore() {
		return score;
	}
	public void setScore(DoubleProperty score) {
		this.score = score;
	}

	public DoubleProperty getPropc1() {
		return propc1;
	}
	public void setPropc1(DoubleProperty propc1) {
		this.propc1 = propc1;
	}
	public DoubleProperty getPropc2() {
		return propc2;
	}
	public void setPropc2(DoubleProperty propc2) {
		this.propc2 = propc2;
	}
	public DoubleProperty getPropc3() {
		return propc3;
	}
	public void setPropc3(DoubleProperty propc3) {
		this.propc3 = propc3;
	}
	public DoubleProperty getPropc4() {
		return propc4;
	}
	public void setPropc4(DoubleProperty propc4) {
		this.propc4 = propc4;
	}
	public DoubleProperty getPropc5() {
		return propc5;
	}
	public void setPropc5(DoubleProperty propc5) {
		this.propc5 = propc5;
	}
	public DoubleProperty getPropc6() {
		return propc6;
	}
	public void setPropc6(DoubleProperty propc6) {
		this.propc6 = propc6;
	}
	public DoubleProperty getPropc7() {
		return propc7;
	}
	public void setPropc7(DoubleProperty propc7) {
		this.propc7 = propc7;
	}
	public DoubleProperty getPropc8() {
		return propc8;
	}
	public void setPropc8(DoubleProperty propc8) {
		this.propc8 = propc8;
	}
	public DoubleProperty getPropc9() {
		return propc9;
	}
	public void setPropc9(DoubleProperty propc9) {
		this.propc9 = propc9;
	}
	public DoubleProperty getPropc10() {
		return propc10;
	}
	public void setPropc10(DoubleProperty propc10) {
		this.propc10 = propc10;
	}
	public DoubleProperty getPropc11() {
		return propc11;
	}
	public void setPropc11(DoubleProperty propc11) {
		this.propc11 = propc11;
	}
	public DoubleProperty getPropc12() {
		return propc12;
	}
	public void setPropc12(DoubleProperty propc12) {
		this.propc12 = propc12;
	}
	public DoubleProperty getPropc13() {
		return propc13;
	}
	public void setPropc13(DoubleProperty propc13) {
		this.propc13 = propc13;
	}
	public DoubleProperty getPropc14() {
		return propc14;
	}
	public void setPropc14(DoubleProperty propc14) {
		this.propc14 = propc14;
	}
	public DoubleProperty getPropc15() {
		return propc15;
	}
	public void setPropc15(DoubleProperty propc15) {
		this.propc15 = propc15;
	}
	public DoubleProperty getPropc16() {
		return propc16;
	}
	public void setPropc16(DoubleProperty propc16) {
		this.propc16 = propc16;
	}
}
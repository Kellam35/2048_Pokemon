package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

@SuppressWarnings("restriction")
public class Controller implements Initializable, Observer {

	// Le modèle
	private Model model;

	// Les éléments de la vue (cf fichier FXML)
	@FXML
	private TextField c1;
	@FXML
	private TextField c2;
	@FXML
	private TextField c3;
	@FXML
	private TextField c4;
	@FXML
	private TextField c5;
	@FXML
	private TextField c6;
	@FXML
	private TextField c7;
	@FXML
	private TextField c8;
	@FXML
	private TextField c9;
	@FXML
	private TextField c10;
	@FXML
	private TextField c11;
	@FXML
	private TextField c12;
	@FXML
	private TextField c13;
	@FXML
	private TextField c14;
	@FXML
	private TextField c15;
	@FXML
	private TextField c16;
	@FXML
	private TextField scoreText;
	@FXML
	private TextField etatText;

	// Une table liée aux éléments de la vue
	private HashMap<Integer, TextField> m = new HashMap<Integer, TextField>();

	// Un tableau pour la fin de partie
	private boolean[] finDePartie= new boolean[4];

	/**
	 * Called to initialize a controller after its root element has been
	 * completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or
	 *                  <tt>null</tt> if the location is not known.
	 * @param resources The resources used to localize the root object, or <tt>null</tt> if
	 */
	public void initialize(URL location, ResourceBundle resources){

		//Le controller et la view sont liés dans le fichier fxml

		//Le model
		model = new Model();
		// On ajoute le model comme observer du controller : liaison model - controller
		model.addObserver(this);

		//Initialisation du modèle
		model.setEtat(new SimpleStringProperty());
		model.setScore(new SimpleDoubleProperty());
		model.setPropc1(new SimpleDoubleProperty());
		model.setPropc2(new SimpleDoubleProperty());
		model.setPropc3(new SimpleDoubleProperty());
		model.setPropc4(new SimpleDoubleProperty());
		model.setPropc5(new SimpleDoubleProperty());
		model.setPropc6(new SimpleDoubleProperty());
		model.setPropc7(new SimpleDoubleProperty());
		model.setPropc8(new SimpleDoubleProperty());
		model.setPropc9(new SimpleDoubleProperty());
		model.setPropc10(new SimpleDoubleProperty());
		model.setPropc11(new SimpleDoubleProperty());
		model.setPropc12(new SimpleDoubleProperty());
		model.setPropc13(new SimpleDoubleProperty());
		model.setPropc14(new SimpleDoubleProperty());
		model.setPropc15(new SimpleDoubleProperty());
		model.setPropc16(new SimpleDoubleProperty());
		model.setTabList();
		model.setHashMapDoubleProperty();

		//Initialisation des properties qui font le lien view - model, par le controller
		StringConverter<Number> converter =  new NumberStringConverter();

		scoreText.textProperty().bindBidirectional((Property<Number>) model.getScore(), converter);
		c1.textProperty().bindBidirectional((Property<Number>) model.getPropc1(), converter);
		c2.textProperty().bindBidirectional((Property<Number>) model.getPropc2(), converter);
		c3.textProperty().bindBidirectional((Property<Number>) model.getPropc3(), converter);
		c4.textProperty().bindBidirectional((Property<Number>) model.getPropc4(), converter);
		c5.textProperty().bindBidirectional((Property<Number>) model.getPropc5(), converter);
		c6.textProperty().bindBidirectional((Property<Number>) model.getPropc6(), converter);
		c7.textProperty().bindBidirectional((Property<Number>) model.getPropc7(), converter);
		c8.textProperty().bindBidirectional((Property<Number>) model.getPropc8(), converter);
		c9.textProperty().bindBidirectional((Property<Number>) model.getPropc9(), converter);
		c10.textProperty().bindBidirectional((Property<Number>) model.getPropc10(), converter);
		c11.textProperty().bindBidirectional((Property<Number>) model.getPropc11(), converter);
		c12.textProperty().bindBidirectional((Property<Number>) model.getPropc12(), converter);
		c13.textProperty().bindBidirectional((Property<Number>) model.getPropc13(), converter);
		c14.textProperty().bindBidirectional((Property<Number>) model.getPropc14(), converter);
		c15.textProperty().bindBidirectional((Property<Number>) model.getPropc15(), converter);
		c16.textProperty().bindBidirectional((Property<Number>) model.getPropc16(), converter);
		etatText.textProperty().bindBidirectional(model.getEtat());

		m.put(model.getPropc1().hashCode(), c1);
		m.put(model.getPropc2().hashCode(), c2);
		m.put(model.getPropc3().hashCode(), c3);
		m.put(model.getPropc4().hashCode(), c4);
		m.put(model.getPropc5().hashCode(), c5);
		m.put(model.getPropc6().hashCode(), c6);
		m.put(model.getPropc7().hashCode(), c7);
		m.put(model.getPropc8().hashCode(), c8);
		m.put(model.getPropc9().hashCode(), c9);
		m.put(model.getPropc10().hashCode(), c10);
		m.put(model.getPropc11().hashCode(), c11);
		m.put(model.getPropc12().hashCode(), c12);
		m.put(model.getPropc13().hashCode(), c13);
		m.put(model.getPropc14().hashCode(), c14);
		m.put(model.getPropc15().hashCode(), c15);
		m.put(model.getPropc16().hashCode(), c16);

		// Valeurs de départ : etat et score à zero
		model.getEtat().setValue("0");
		model.getScore().setValue(0);
		scoreText.getStylesheets().add(getClass().getResource("/score.css").toExternalForm());

		//Ajout des 2 cases de départ
		addVal2or4Random();
		addVal2or4Random();
	}


	//Ajout d'un 2 ou 4
	private void addVal2or4Random (){
		int i = 0;
		boolean stop = false;
		Collections.shuffle(model.getTabList());
		while (i< model.getTabList().size() && !stop){
			if (model.getTabList().get(i).getValue().equals(0.0)){
				if(Math.random()>0.1){
					model.setValuePropc(model.getTabList().get(i),2);
				}
				else {
					model.setValuePropc(model.getTabList().get(i),4);	
				}
				stop = true;
			}
			i++;
		}
	}


	// Fonction de test de fin de partie (il faut cliquer une fois sur chaque bouton)
	private boolean finDePartie(){
		boolean rep = true;
		for (int i =0; i<finDePartie.length;i++){
			rep= rep && finDePartie[i];
		}
		return rep;		
	}

	// Fonction pour recommencer une partie
	@FXML
	private void restart(){
		model.getEtat().setValue("0");
		model.getScore().setValue(0);
		model.setValuePropc(model.getPropc1(),0);
		model.setValuePropc(model.getPropc2(),0);
		model.setValuePropc(model.getPropc3(),0);
		model.setValuePropc(model.getPropc4(),0);
		model.setValuePropc(model.getPropc5(),0);
		model.setValuePropc(model.getPropc6(),0);
		model.setValuePropc(model.getPropc7(),0);
		model.setValuePropc(model.getPropc8(),0);
		model.setValuePropc(model.getPropc9(),0);
		model.setValuePropc(model.getPropc10(),0);
		model.setValuePropc(model.getPropc11(),0);
		model.setValuePropc(model.getPropc12(),0);
		model.setValuePropc(model.getPropc13(),0);
		model.setValuePropc(model.getPropc14(),0);
		model.setValuePropc(model.getPropc15(),0);
		model.setValuePropc(model.getPropc16(),0);
		addVal2or4Random();
		addVal2or4Random();
		finDePartie[0]=false;
		finDePartie[1]=false;
		finDePartie[2]=false;
		finDePartie[3]=false;
	}

	//Fonction de mouvement vers le haut
	@FXML
	private void addHaut(){
		//Décalage et fusion si possibles
		boolean rep = mvHaut();
		//Décalage si nécessaire après fusion
		boolean dec = decalHaut();
		//Ajout d'une case avec 2 ou 4 si possible
		if(rep)
			addVal2or4Random();

		//Actions liées au test de fin de partie
		if (!rep && !dec){
			finDePartie[0]=true;
		}
		else {
			finDePartie[0]=false;
			finDePartie[1]=false;
			finDePartie[2]=false;
			finDePartie[3]=false;
		}

		if (finDePartie()){
			model.getEtat().setValue("Perdu !");
		}
	}

	//Fonction de mouvement vers le bas
	@FXML
	private void addBas(){
		//Décalage et fusion si possibles
		boolean rep = mvBas();
		//Décalage si nécessaire après fusion
		boolean dec = decalBas();
		//Ajout d'une case avec 2 ou 4 si possible
		if(rep)
			addVal2or4Random();

		//Actions liées au test de fin de partie
		if (!rep && !dec){
			finDePartie[1]=true;
		}
		else {
			finDePartie[0]=false;
			finDePartie[1]=false;
			finDePartie[2]=false;
			finDePartie[3]=false;
		}

		if (finDePartie()){
			model.getEtat().setValue("Perdu !");
		}
	}
	@FXML
	private void addGauche(){
		//Décalage et fusion si possibles
		boolean rep = mvGauche();
		//Décalage si nécessaire après fusion
		boolean dec = decalGauche();
		//Ajout d'une case avec 2 ou 4 si possible
		if(rep)
			addVal2or4Random();

		//Actions liées au test de fin de partie
		if (!rep && !dec){
			finDePartie[2]=true;
		}
		else {
			finDePartie[0]=false;
			finDePartie[1]=false;
			finDePartie[2]=false;
			finDePartie[3]=false;
		}

		if (finDePartie()){
			model.getEtat().setValue("Perdu !");
		}
	}
	@FXML
	private void addDroite(){
		//Décalage et fusion si possibles
		boolean rep = mvDroite();
		//Décalage si nécessaire après fusion
		boolean dec = decalDroite();
		//Ajout d'une case avec 2 ou 4 si possible
		if(rep)
			addVal2or4Random();

		//Actions liées au test de fin de partie
		if (!rep && !dec){
			finDePartie[3]=true;
		}
		else {
			finDePartie[0]=false;
			finDePartie[1]=false;
			finDePartie[2]=false;
			finDePartie[3]=false;
		}

		if (finDePartie()){
			model.getEtat().setValue("Perdu !");
		}
	}

	//Fonction de mise à jour de la view, car model modifié - appelée dans update
	private void updateEvoliAndScore(DoubleProperty p){
		TextField t = m.get(p.hashCode());
		double val = p.getValue();
		int v = (int)val;
		int currentMax = Integer.parseInt(model.getEtat().getValue());
		if (v>currentMax){
			model.getEtat().setValue(v+"");
		}
		if (v==2048){
			model.getEtat().setValue("Gagné !");
		}
		// On "blanchit" la case
		t.getStylesheets().clear();
		// On met le nouvel affichage
		t.getStylesheets().add(getClass().getResource("/"+v+".css").toExternalForm());
	}


	//Fonction update (pour lien observer-observable)
	@Override
	public void update(Observable o, Object arg) {
		updateEvoliAndScore((DoubleProperty) arg);
	}


	/*
	 * Fonctions annexes pour calcul selon case et mouvement
	 */

	private void caseRang2Decal(DoubleProperty d, DoubleProperty e, TextField td, TextField te){
		model.setValuePropc(d,e.getValue());					
		model.setValuePropc(e,0);					
	}

	private void caseRang3Decal(DoubleProperty d, DoubleProperty e,DoubleProperty f, 
			TextField td, TextField te, TextField tf){
		if (f.getValue().equals(0.0)){
			model.setValuePropc(f,e.getValue());
			model.setValuePropc(e,0);
		}
		else {
			model.setValuePropc(d,e.getValue());
			model.setValuePropc(e,0);
		}
	}

	private void caseRang4Decal(DoubleProperty d, DoubleProperty e, DoubleProperty f, DoubleProperty g,
			TextField td, TextField te, TextField tf, TextField tg){
		if (e.getValue().equals(0.0)){
			if (d.getValue().equals(0.0)){
				model.setValuePropc(d,g.getValue());
				model.setValuePropc(g,0);	
			}
			else {
				model.setValuePropc(e,g.getValue());
				model.setValuePropc(g,0);	
			}
		}	
		else {
			model.setValuePropc(f,g.getValue());
			model.setValuePropc(g,0);	
		}
	}	

	private void fusionValeurs(DoubleProperty d, DoubleProperty e, TextField td){
		model.setValuePropc(d,d.getValue()+ e.getValue());
		model.getScore().setValue(model.getScore().getValue()+d.getValue());
	}

	private void cleanCase(DoubleProperty d, TextField td){
		model.setValuePropc(d,0);
	}

	/*
	 *  Les deux fonctions pour le mouvement Haut
	 */

	private boolean decalHaut(){
		boolean rep = false;
		//case1

		//case5
		if (model.getPropc1().getValue().equals(0.0)&& !model.getPropc5().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc1(), model.getPropc5(), c1, c5);
		}

		//case9
		if (model.getPropc5().getValue().equals(0.0)&& !model.getPropc9().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc5(), model.getPropc9(), model.getPropc1(), c5, c9, c1);
		}

		//case 13
		if (model.getPropc9().getValue().equals(0.0)&& !model.getPropc13().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc1(), model.getPropc5(), model.getPropc9(), model.getPropc13(), c1, c5, c9, c13);
		}

		//case2

		//case6
		if (model.getPropc2().getValue().equals(0.0)&& !model.getPropc6().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc2(), model.getPropc6(), c2, c6);
		}

		//case10
		if (model.getPropc6().getValue().equals(0.0)&& !model.getPropc10().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc6(), model.getPropc10(), model.getPropc2(), c6, c10, c2);
		}

		//case 14
		if (model.getPropc10().getValue().equals(0.0)&& !model.getPropc14().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc2(), model.getPropc6(), model.getPropc10(), model.getPropc14(), c2, c6, c10, c14);
		}

		//case3

		//case7
		if (model.getPropc3().getValue().equals(0.0)&& !model.getPropc7().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc3(), model.getPropc7(), c3, c7);
		}

		//case11
		if (model.getPropc7().getValue().equals(0.0)&& !model.getPropc11().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc7(), model.getPropc11(), model.getPropc3(), c7, c11, c3);
		}

		//case 15
		if (model.getPropc11().getValue().equals(0.0)&& !model.getPropc15().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc3(), model.getPropc7(), model.getPropc11(), model.getPropc15(), c3, c7, c11, c15);
		}

		//case4

		//case8
		if (model.getPropc4().getValue().equals(0.0)&& !model.getPropc8().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc4(), model.getPropc8(), c4, c8);
		}

		//case12
		if (model.getPropc8().getValue().equals(0.0)&& !model.getPropc12().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc8(), model.getPropc12(), model.getPropc4(), c8, c12, c4);
		}

		//case 16
		if (model.getPropc12().getValue().equals(0.0)&& !model.getPropc16().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc4(), model.getPropc8(), model.getPropc12(), model.getPropc16(), c4, c8, c12, c16);
		}
		return rep;
	}

	private boolean mvHaut(){

		boolean decal = decalHaut();

		boolean rep = decal;

		//case1
		boolean ch1 = false;
		if (model.getPropc5().getValue().equals(model.getPropc1().getValue())&& model.getPropc1().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc1(), model.getPropc5(), c1);
			ch1 = true;
		}

		//case5
		boolean ch5 = false;
		if (ch1){
			cleanCase(model.getPropc5(), c5);
		}

		if (model.getPropc9().getValue().equals(model.getPropc5().getValue())&& model.getPropc5().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc5(), model.getPropc9(), c5);
			ch5 = true;
		}

		//case9
		boolean ch9 = false;
		if (ch5){
			cleanCase(model.getPropc9(), c9);
		}

		if (model.getPropc13().getValue().equals(model.getPropc9().getValue())&& model.getPropc9().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc9(), model.getPropc13(), c9);
			ch9 = true;
		}

		//case 13
		if (ch9){
			cleanCase(model.getPropc13(), c13);
		}

		//case2
		boolean ch2 = false;
		if (model.getPropc6().getValue().equals(model.getPropc2().getValue())&& model.getPropc2().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc2(), model.getPropc6(), c2);
			ch2 = true;
		}

		//case6
		boolean ch6 = false;
		if (ch2){
			cleanCase(model.getPropc6(), c6);
		}

		if (model.getPropc10().getValue().equals(model.getPropc6().getValue())&& model.getPropc6().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc6(), model.getPropc10(), c6);
			ch6 = true;
		}

		//case10
		boolean ch10 = false;
		if (ch6){
			cleanCase(model.getPropc10(), c10);
		}

		if (model.getPropc14().getValue().equals(model.getPropc10().getValue())&& model.getPropc14().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc10(), model.getPropc14(), c10);
			ch10 = true;
		}

		//case 14
		if (ch10){
			cleanCase(model.getPropc14(), c14);
		}

		//case3
		boolean ch3 = false;
		if (model.getPropc7().getValue().equals(model.getPropc3().getValue())&& model.getPropc3().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc3(), model.getPropc7(), c3);
			ch3 = true;
		}

		//case7
		boolean ch7 = false;
		if (ch3){
			cleanCase(model.getPropc7(), c7);
		}

		if (model.getPropc11().getValue().equals(model.getPropc7().getValue())&& model.getPropc7().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc7(), model.getPropc11(), c7);
			ch7 = true;
		}

		//case11
		boolean ch11 = false;
		if (ch7){
			cleanCase(model.getPropc11(), c11);
		}

		if (model.getPropc15().getValue().equals(model.getPropc11().getValue())&& model.getPropc11().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc11(), model.getPropc15(), c11);
			ch11 = true;
		}

		//case 15
		if (ch11){
			cleanCase(model.getPropc15(), c15);
		}

		//case4
		boolean ch4 = false;
		if (model.getPropc8().getValue().equals(model.getPropc4().getValue())&& model.getPropc4().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc4(), model.getPropc8(), c4);
			ch4 = true;
		}

		//case8
		boolean ch8 = false;
		if (ch4){
			cleanCase(model.getPropc8(), c8);
		}

		if (model.getPropc12().getValue().equals(model.getPropc8().getValue())&& model.getPropc8().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc8(), model.getPropc12(), c8);
			ch8 = true;
		}

		//case12
		boolean ch12 = false;
		if (ch8){
			cleanCase(model.getPropc12(), c12);
		}

		if (model.getPropc16().getValue().equals(model.getPropc12().getValue())&& model.getPropc12().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc12(), model.getPropc16(), c12);
			ch12 = true;
		}

		//case 16
		if (ch12){
			cleanCase(model.getPropc16(), c16);
		}
		return rep;
	}

	/*
	 * Par la suite et jusqu'à la fin de cette classe,
	 * on retrouve les fonctions pour les mouvements Bas, Gauche et Droite qui suivent
	 * la même logique de déplacement et de fusion.
	 */	

	private boolean decalBas(){
		boolean rep = false;
		//case13

		//case 9
		if (model.getPropc13().getValue().equals(0.0)&& !model.getPropc9().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc13(), model.getPropc9(), c13, c9);
		}

		//case5
		if (model.getPropc9().getValue().equals(0.0)&& !model.getPropc5().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc9(), model.getPropc5(), model.getPropc13(), c9, c5, c13);
		}

		//case 1
		if (model.getPropc5().getValue().equals(0.0)&& !model.getPropc1().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc13(), model.getPropc9(), model.getPropc5(), model.getPropc1(), c13, c9, c5, c1);
		}

		//case14

		//case 10
		if (model.getPropc14().getValue().equals(0.0)&& !model.getPropc10().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc14(), model.getPropc10(), c14, c10);
		}

		//case6
		if (model.getPropc10().getValue().equals(0.0)&& !model.getPropc6().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc10(), model.getPropc6(), model.getPropc14(), c10, c6, c14);
		}

		//case 2
		if (model.getPropc6().getValue().equals(0.0)&& !model.getPropc2().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc14(), model.getPropc10(), model.getPropc6(), model.getPropc2(), c14, c10, c6, c2);
		}

		//case15

		//case 11
		if (model.getPropc15().getValue().equals(0.0)&& !model.getPropc11().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc15(), model.getPropc11(), c15, c11);
		}

		//case 7
		if (model.getPropc11().getValue().equals(0.0)&& !model.getPropc7().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc11(), model.getPropc7(), model.getPropc15(), c11, c7, c15);
		}

		//case 3
		if (model.getPropc7().getValue().equals(0.0)&& !model.getPropc3().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc15(), model.getPropc11(), model.getPropc7(), model.getPropc3(), c15, c11, c7, c3);
		}

		//case16

		//case 12
		if (model.getPropc16().getValue().equals(0.0)&& !model.getPropc12().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc16(), model.getPropc12(), c16, c12);
		}

		//case 8
		if (model.getPropc12().getValue().equals(0.0)&& !model.getPropc8().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc12(), model.getPropc8(), model.getPropc16(), c12, c8, c16);
		}

		//case 4
		if (model.getPropc8().getValue().equals(0.0)&& !model.getPropc4().getValue().equals(0.0)){
			rep = true;			
			caseRang4Decal(model.getPropc16(), model.getPropc12(), model.getPropc8(), model.getPropc4(), c16, c12, c8, c4);
		}
		return rep;
	}

	private boolean mvBas(){
		boolean decal = decalBas();
		boolean rep = decal;

		//case13
		boolean ch13 = false;
		if (model.getPropc9().getValue().equals(model.getPropc13().getValue())&& model.getPropc13().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc13(), model.getPropc9(), c13);
			ch13 = true;
		}

		//case9
		boolean ch9 = false;
		if (ch13){
			cleanCase(model.getPropc9(), c9);
		}

		if (model.getPropc5().getValue().equals(model.getPropc9().getValue())&& model.getPropc9().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc9(), model.getPropc5(), c9);
			ch9 = true;
		}

		//case5
		boolean ch5 = false;
		if (ch9){
			cleanCase(model.getPropc5(), c5);
		}

		if (model.getPropc1().getValue().equals(model.getPropc5().getValue())&& model.getPropc5().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc5(), model.getPropc1(), c5);
			ch5 = true;
		}

		//case 1
		if (ch5){
			cleanCase(model.getPropc1(), c1);
		}

		//case14
		boolean ch14 = false;
		if (model.getPropc10().getValue().equals(model.getPropc14().getValue())&& model.getPropc14().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc14(), model.getPropc10(), c14);
			ch14 = true;
		}

		//case 10
		boolean ch10 = false;
		if (ch14){
			cleanCase(model.getPropc10(), c10);
		}

		if (model.getPropc6().getValue().equals(model.getPropc10().getValue())&& model.getPropc10().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc10(), model.getPropc6(), c10);
			ch10 = true;
		}

		//case 6
		boolean ch6 = false;
		if (ch10){
			cleanCase(model.getPropc6(), c6);
		}

		if (model.getPropc2().getValue().equals(model.getPropc6().getValue())&& model.getPropc6().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc6(), model.getPropc2(), c6);
			ch6 = true;
		}

		//case 2
		if (ch6){
			cleanCase(model.getPropc2(), c2);
		}

		//case15
		boolean ch15 = false;
		if (model.getPropc11().getValue().equals(model.getPropc15().getValue())&& model.getPropc15().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc15(), model.getPropc11(), c15);
			ch15 = true;
		}

		//case11
		boolean ch11 = false;
		if (ch15){
			cleanCase(model.getPropc11(), c11);
		}

		if (model.getPropc7().getValue().equals(model.getPropc11().getValue())&& model.getPropc11().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc11(), model.getPropc7(), c11);
			ch11 = true;
		}

		//case7
		boolean ch7 = false;
		if (ch11){
			cleanCase(model.getPropc7(), c7);
		}

		if (model.getPropc3().getValue().equals(model.getPropc7().getValue())&& model.getPropc7().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc7(), model.getPropc3(), c7);
			ch7 = true;
		}

		//case 3
		if (ch7){
			cleanCase(model.getPropc3(), c3);
		}

		//case16
		boolean ch16 = false;
		if (model.getPropc12().getValue().equals(model.getPropc16().getValue())&& model.getPropc16().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc16(), model.getPropc12(), c16);
			ch16 = true;
		}

		//case12
		boolean ch12 = false;
		if (ch16){
			cleanCase(model.getPropc12(), c12);
		}

		if (model.getPropc8().getValue().equals(model.getPropc12().getValue())&& model.getPropc12().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc12(), model.getPropc8(), c12);
			ch12 = true;
		}

		//case8
		boolean ch8 = false;
		if (ch12){
			cleanCase(model.getPropc8(), c8);
		}

		if (model.getPropc4().getValue().equals(model.getPropc8().getValue())&& model.getPropc8().getValue() !=0){
			rep = rep ||true;
			fusionValeurs(model.getPropc8(), model.getPropc4(), c8);
			ch8 = true;
		}

		//case 4
		if (ch8){
			cleanCase(model.getPropc4(), c4);
		}

		return rep;
	}

	private boolean decalGauche(){

		boolean rep = false;

		//case1

		//case2
		if (model.getPropc1().getValue().equals(0.0) && !model.getPropc2().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc1(), model.getPropc2(), c1, c2);
		}

		//case3
		if (model.getPropc2().getValue().equals(0.0)&& !model.getPropc3().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc2(), model.getPropc3(), model.getPropc1(), c2, c3, c1);
		}

		//case 4
		if (model.getPropc3().getValue().equals(0.0)&& !model.getPropc4().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc1(), model.getPropc2(), model.getPropc3(), model.getPropc4(), c1, c2, c3, c4);
		}

		//case5

		//case6
		if (model.getPropc5().getValue().equals(0.0)&& !model.getPropc6().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc5(), model.getPropc6(), c5, c6);
		}

		//case7
		if (model.getPropc6().getValue().equals(0.0)&& !model.getPropc7().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc6(), model.getPropc7(), model.getPropc5(), c6, c7, c5);
		}

		//case 8
		if (model.getPropc7().getValue().equals(0.0)&& !model.getPropc8().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc5(), model.getPropc6(), model.getPropc7(), model.getPropc8(), c5, c6, c7, c8);
		}

		//case9

		//case10
		if (model.getPropc9().getValue().equals(0.0)&& !model.getPropc10().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc9(), model.getPropc10(), c9, c10);
		}

		//case11
		if (model.getPropc10().getValue().equals(0.0)&& !model.getPropc11().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc10(), model.getPropc11(), model.getPropc9(), c10, c11, c9);
		}

		//case 12
		if (model.getPropc11().getValue().equals(0.0)&& !model.getPropc12().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc9(), model.getPropc10(), model.getPropc11(), model.getPropc12(), c9, c10, c11, c12);
		}

		//case13

		//case14
		if (model.getPropc13().getValue().equals(0.0)&& !model.getPropc14().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc13(), model.getPropc14(), c13, c14);
		}

		//case15
		if (model.getPropc14().getValue().equals(0.0)&& !model.getPropc15().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc14(), model.getPropc15(), model.getPropc13(), c14, c15, c13);
		}

		//case 16
		if (model.getPropc15().getValue().equals(0.0)&& !model.getPropc16().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc13(), model.getPropc14(), model.getPropc15(), model.getPropc16(), c13, c14, c15, c16);
		}
		return rep;
	}

	private boolean mvGauche(){
		boolean decal = decalGauche();
		boolean rep = decal;

		//case13
		boolean ch13 = false;
		if (model.getPropc14().getValue().equals(model.getPropc13().getValue()) && model.getPropc13().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc13(), model.getPropc14(), c13);
			ch13 = true;
		}

		//case14
		boolean ch14 = false;
		if (ch13){
			cleanCase(model.getPropc14(), c14);
		}

		if (model.getPropc15().getValue().equals(model.getPropc14().getValue())&& model.getPropc14().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc14(), model.getPropc15(), c14);
			ch14 = true;
		}

		//case15
		boolean ch15 = false;
		if (ch14){
			cleanCase(model.getPropc15(),c15);
		}

		if (model.getPropc16().getValue().equals(model.getPropc15().getValue())&& model.getPropc15().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc15(), model.getPropc16(), c15);
			ch15 = true;
		}

		//case 16
		if (ch15){
			cleanCase(model.getPropc16(),c16);
		}

		//case9
		boolean ch9 = false;
		if (model.getPropc10().getValue().equals(model.getPropc9().getValue())&& model.getPropc9().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc9(), model.getPropc10(), c9);
			ch9 = true;
		}

		//case10
		boolean ch10 = false;
		if (ch9){
			cleanCase(model.getPropc10(), c10);
		}

		if (model.getPropc11().getValue().equals(model.getPropc10().getValue())&& model.getPropc10().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc10(), model.getPropc11(), c10);
			ch10 = true;
		}

		//case11
		boolean ch11 = false;
		if (ch10){
			cleanCase(model.getPropc11(), c11);
		}

		if (model.getPropc12().getValue().equals(model.getPropc11().getValue())&& model.getPropc11().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc11(), model.getPropc12(), c11);
			ch11 = true;
		}

		//case 12
		if (ch11){
			cleanCase(model.getPropc12(), c12);
		}

		//case5
		boolean ch5 = false;
		if (model.getPropc6().getValue().equals(model.getPropc5().getValue())&& model.getPropc5().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc5(), model.getPropc6(), c5);
			ch5 = true;
		}

		//case6
		boolean ch6 = false;
		if (ch5){
			cleanCase(model.getPropc6(), c6);
		}

		if (model.getPropc7().getValue().equals(model.getPropc6().getValue())&& model.getPropc6().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc6(), model.getPropc7(), c6);
			ch6 = true;
		}

		//case7
		boolean ch7 = false;
		if (ch6){
			cleanCase(model.getPropc7(), c7);
		}

		if (model.getPropc8().getValue().equals(model.getPropc7().getValue())&& model.getPropc7().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc7(), model.getPropc8(), c7);
			ch7 = true;
		}

		//case 8
		if (ch7){
			cleanCase(model.getPropc8(), c8);
		}

		//case1
		boolean ch1 = false;
		if (model.getPropc2().getValue().equals(model.getPropc1().getValue())&& model.getPropc1().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc1(), model.getPropc2(), c1);
			ch1 = true;
		}

		//case2
		boolean ch2 = false;
		if (ch1){
			cleanCase(model.getPropc2(), c2);
		}

		if (model.getPropc3().getValue().equals(model.getPropc2().getValue())&& model.getPropc2().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc2(), model.getPropc3(), c2);
			ch2 = true;
		}

		//case3
		boolean ch3 = false;
		if (ch2){
			cleanCase(model.getPropc3(), c3);
		}

		if (model.getPropc4().getValue().equals(model.getPropc3().getValue())&& model.getPropc3().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc3(), model.getPropc4(), c3);
			ch3 = true;
		}

		//case 4
		if (ch3){
			cleanCase(model.getPropc4(), c4);
		}
		return rep;
	}

	private boolean decalDroite(){
		boolean rep = false;

		//case4

		//case3
		if (model.getPropc4().getValue().equals(0.0)&& !model.getPropc3().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc4(), model.getPropc3(), c4, c3);
		}

		//case2
		if (model.getPropc3().getValue().equals(0.0)&& !model.getPropc2().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc3(), model.getPropc2(), model.getPropc4(), c3, c2, c4);
		}

		//case 1
		if (model.getPropc2().getValue().equals(0.0)&& !model.getPropc1().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc4(), model.getPropc3(), model.getPropc2(), model.getPropc1(), c4, c3, c2, c1);
		}

		//case8

		//case7
		if (model.getPropc8().getValue().equals(0.0)&& !model.getPropc7().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc8(), model.getPropc7(), c8, c7);
		}

		//case6
		if (model.getPropc7().getValue().equals(0.0)&& !model.getPropc6().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc7(), model.getPropc6(), model.getPropc8(), c7, c6, c8);
		}

		//case 5
		if (model.getPropc6().getValue().equals(0.0)&& !model.getPropc5().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc8(), model.getPropc7(), model.getPropc6(), model.getPropc5(), c8, c7, c6, c5);
		}

		//case12

		//case11
		if (model.getPropc12().getValue().equals(0.0)&& !model.getPropc11().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc12(), model.getPropc11(), c12, c11);
		}

		//case10
		if (model.getPropc11().getValue().equals(0.0)&& !model.getPropc10().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc11(), model.getPropc10(), model.getPropc12(), c11, c10, c12);
		}

		//case 9
		if (model.getPropc10().getValue().equals(0.0)&& !model.getPropc9().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc12(), model.getPropc11(), model.getPropc10(), model.getPropc9(), c12, c11, c10, c9);
		}

		//case16

		//case15
		if (model.getPropc16().getValue().equals(0.0)&& !model.getPropc15().getValue().equals(0.0)){
			rep = true;
			caseRang2Decal(model.getPropc16(), model.getPropc15(), c16, c15);
		}

		//case14
		if (model.getPropc15().getValue().equals(0.0)&& !model.getPropc14().getValue().equals(0.0)){
			rep = true;
			caseRang3Decal(model.getPropc15(), model.getPropc14(), model.getPropc16(), c15, c14, c16);
		}

		//case 13
		if (model.getPropc14().getValue().equals(0.0)&& !model.getPropc13().getValue().equals(0.0)){
			rep = true;
			caseRang4Decal(model.getPropc16(), model.getPropc15(), model.getPropc14(), model.getPropc13(), c16, c15, c14, c13);
		}
		return rep;
	}

	private boolean mvDroite (){

		boolean decal = decalDroite();
		boolean rep = decal;

		//case16
		boolean ch16 = false;
		if (model.getPropc15().getValue().equals(model.getPropc16().getValue()) && model.getPropc16().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc16(), model.getPropc15(), c16);
			ch16= true;
		}

		//case15
		boolean ch15 = false;
		if (ch16){
			cleanCase(model.getPropc15(), c15);
		}

		if (model.getPropc14().getValue().equals(model.getPropc15().getValue()) && model.getPropc15().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc15(), model.getPropc14(), c15);
			ch15 = true;
		}

		//case14
		boolean ch14 = false;
		if (ch15){
			cleanCase(model.getPropc14(), c14);
		}

		if (model.getPropc13().getValue().equals(model.getPropc14().getValue()) && model.getPropc14().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc14(), model.getPropc13(), c14);
			ch14 = true;
		}

		//case 13
		if (ch14){
			cleanCase(model.getPropc13(), c13);
		}

		//case12
		boolean ch12 = false;
		if (model.getPropc11().getValue().equals(model.getPropc12().getValue()) && model.getPropc12().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc12(), model.getPropc11(), c12);
			ch12= true;
		}

		//case11
		boolean ch11 = false;
		if (ch12){
			cleanCase(model.getPropc11(), c11);
		}

		if (model.getPropc10().getValue().equals(model.getPropc11().getValue()) && model.getPropc11().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc11(), model.getPropc10(), c11);
			ch11 = true;
		}

		//case10
		boolean ch10= false;
		if (ch11){
			cleanCase(model.getPropc10(), c10);
		}

		if (model.getPropc9().getValue().equals(model.getPropc10().getValue()) && model.getPropc10().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc10(), model.getPropc9(), c10);
			ch10 = true;
		}

		//case 9
		if (ch10){
			cleanCase(model.getPropc9(), c9);
		}


		//case8
		boolean ch8 = false;
		if (model.getPropc7().getValue().equals(model.getPropc8().getValue()) && model.getPropc8().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc8(), model.getPropc7(), c8);
			ch8 = true;
		}

		//case7
		boolean ch7 = false;
		if (ch8){
			cleanCase(model.getPropc7(), c7);
		}

		if (model.getPropc6().getValue().equals(model.getPropc7().getValue()) && model.getPropc7().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc7(), model.getPropc6(), c7);
			ch7 = true;
		}

		//case6
		boolean ch6 = false;
		if (ch7){
			cleanCase(model.getPropc6(), c6);
		}

		if (model.getPropc5().getValue().equals(model.getPropc6().getValue()) && model.getPropc6().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc6(), model.getPropc5(), c6);
			ch6 = true;
		}

		//case 5
		if (ch6){
			cleanCase(model.getPropc5(), c5);
		}

		//case4
		boolean ch4 = false;
		if (model.getPropc3().getValue().equals(model.getPropc4().getValue()) && model.getPropc4().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc4(), model.getPropc3(), c4);
			ch4 = true;
		}

		//case3
		boolean ch3 = false;
		if (ch4){
			cleanCase(model.getPropc3(), c3);
		}

		if (model.getPropc2().getValue().equals(model.getPropc3().getValue()) && model.getPropc3().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc3(), model.getPropc2(), c3);
			ch3 = true;
		}

		//case2
		boolean ch2 = false;
		if (ch3){
			cleanCase(model.getPropc2(), c2);
		}

		if (model.getPropc1().getValue().equals(model.getPropc2().getValue()) && model.getPropc2().getValue() !=0 ){
			rep = rep ||true;
			fusionValeurs(model.getPropc2(), model.getPropc1(), c2);
			ch2 = true;
		}

		//case 1
		if (ch2){
			cleanCase(model.getPropc1(), c1);
		}
		return rep;
	}
}
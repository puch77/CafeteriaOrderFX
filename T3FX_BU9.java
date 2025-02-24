package t3FX_BU9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3FX_BU9 extends Application {
	private CheckBox chBeef = new CheckBox("Beef tartare (12,50 Euro)");
	private CheckBox chSuppe = new CheckBox("Rindsuppe mit Einlage (4,90 Euro)");
	private RadioButton rbSchnitzel = new RadioButton("Wiener Schnitzel vom Kalb (19,50 Euro)");
	private RadioButton rbGoldbrasse = new RadioButton("Goldbrasse gegrillt mit Gemüse (21,50 Euro)");
	private RadioButton rbLasagne= new RadioButton("Gemüselasagne (12,20 Euro)");
	private RadioButton rbEis = new RadioButton("Gemischtes Eis mit Schokosauce (6,30 Euro)");
	private RadioButton rbMousse = new RadioButton("Mousse au chocolat (7,80 Euro)");
	private CheckBox chEspresso = new CheckBox("Kleiner Expresso (3,50 Euro)");
	private CheckBox chOban = new CheckBox("2cl Oban (6,90 Euro)");
	private Label lblGesamtpreis = new Label("Gesamtpreis ");
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Label lblVor = new Label("Vorspeisen und Suppen");	
		Label lblHaupt = new Label("Hauptspeisen");	
		Label lblDessert = new Label("Desserts");
		Label lblKaffee = new Label("Kaffee und Whisky");	
		
		ToggleGroup tgHauptspeise = new ToggleGroup();
		rbSchnitzel.setToggleGroup(tgHauptspeise);
		rbGoldbrasse.setToggleGroup(tgHauptspeise);
		rbLasagne.setToggleGroup(tgHauptspeise);
		
		ToggleGroup tgDessert = new ToggleGroup();
		rbEis.setToggleGroup(tgDessert);
		rbMousse.setToggleGroup(tgDessert);
	
		Button btn = new Button("Bestellen");
		
		btn.setOnMouseClicked(e -> gesamtpreisBerechnen());
		
		VBox vb = new VBox(10, lblVor, chBeef, chSuppe, lblHaupt, rbSchnitzel, rbGoldbrasse, rbLasagne,
				lblDessert, rbEis, rbMousse, lblKaffee, chEspresso, chOban, btn, lblGesamtpreis);
		vb.setPadding(new Insets(5));	
		arg0.setScene(new Scene(vb));
		arg0.setTitle("T3FX_BU9");
		arg0.show();
	}

	private void gesamtpreisBerechnen() {
		double gesamt = 0;
		if(chBeef.isSelected()) {
			gesamt += 12.50;
		}
		if(chSuppe.isSelected()) {
			gesamt += 4.90;
		}
		if(rbSchnitzel.isSelected()) {
			gesamt += 19.50;
		}
		else if(rbGoldbrasse.isSelected()) {
			gesamt += 21.50;
		}
		else if(rbLasagne.isSelected()) {
			gesamt += 12.20;
		}
		if(rbEis.isSelected()) {
			gesamt += 6.30;
		}
		else if(rbMousse.isSelected()) {
			gesamt += 7.80;
		}
		if(chEspresso.isSelected()) {
			gesamt += 3.50;
		}
		if(chOban.isSelected()) {
			gesamt += 6.90;
		}
		
		lblGesamtpreis.setText("Gesamtpreis " + String.format("%.2f", Double.valueOf(gesamt)));
	}

}

package t3FX_BU8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3FX_BU8 extends Application {
	private CheckBox chCroissant = new CheckBox("Croissant (1,90 Euro)");
	private CheckBox chSemmel = new CheckBox("Semmel (0,80 Euro)");
	private CheckBox chMarmelade = new CheckBox("Marmelade und Butter (2,50 Euro)");
	private Label lbl = new Label("Gesamtpreis");
	private RadioButton rbKaffee = new RadioButton("Kaffee (3,20 Euro)");
	private RadioButton rbTee = new RadioButton("Tee (2,90 Euro)");
	private RadioButton rbSaft = new RadioButton("frischgepresster Orangensaft (3,50 Euro)");
	private RadioButton rbSekt = new RadioButton("Sekt Orange (5,50 Euro)");
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		ToggleGroup tgTop = new ToggleGroup();
		rbKaffee.setToggleGroup(tgTop);
		rbTee.setToggleGroup(tgTop);
		
		ToggleGroup tgBottom = new ToggleGroup();
		rbSaft.setToggleGroup(tgBottom);
		rbSekt.setToggleGroup(tgBottom);
			
		chCroissant.setOnAction(e-> handleSelection());
		chSemmel.setOnAction(e-> handleSelection());
		chMarmelade.setOnAction(e-> handleSelection());
		rbKaffee.setOnAction(e-> handleSelection());
		rbTee.setOnAction(e-> handleSelection());
		rbSaft.setOnAction(e-> handleSelection());
		rbSekt.setOnAction(e-> handleSelection());
		
		BorderPane bp = new BorderPane();
		
		HBox hbTop = new HBox(10, rbKaffee, rbTee);
		hbTop.setPadding(new Insets(5));
		bp.setTop(hbTop);
		
		VBox vb = new VBox(10, chCroissant, chSemmel, chMarmelade);
		vb.setPadding(new Insets(5));
		bp.setCenter(vb);
		
		GridPane gpBottom = new GridPane();
		gpBottom.add(rbSaft, 0,0);
		gpBottom.add(rbSekt, 1,0);
		gpBottom.add(lbl, 0, 1);
		gpBottom.setPadding(new Insets(5,5,5,5));
		gpBottom.setVgap(10);
		gpBottom.setHgap(10);
		bp.setBottom(gpBottom);
		
		arg0.setScene(new Scene(bp));
		arg0.setTitle("T3FX_BU8");
		arg0.show();
	}

	private void handleSelection() {
		double gesamt = 0;
		if(chCroissant.isSelected()) {
			gesamt += 1.90;
		}
		if(chSemmel.isSelected()) {
			gesamt += 0.80;
		}
		if(chMarmelade.isSelected()) {
			gesamt += 2.50;
		}
		if(rbKaffee.isSelected()) {
			gesamt += 3.20;
		}
		else if(rbTee.isSelected()) {
			gesamt += 2.90;
		}
		if(rbSaft.isSelected()) {
			gesamt += 3.50;
		}
		else if(rbSekt.isSelected()) {
			gesamt += 5.50;
		}
		
		lbl.setText("Gesamtpreis " + Double.valueOf(gesamt).toString());
	}

}

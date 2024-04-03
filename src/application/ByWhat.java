package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ByWhat {
//	public static RadioButton n1_10 = new RadioButton("1_10");
//	public static RadioButton n10_30 = new RadioButton("10-30");
//	public static RadioButton n30_90 = new RadioButton("30_90");
//	public static RadioButton n90_00 = new RadioButton("90_##");
	public static RadioButton ByFile1_9 = new RadioButton("ByFile1_9");
	public static RadioButton ByUser1_9 = new RadioButton("ByUser1_9");
	public static RadioButton ByRandom1_9 = new RadioButton("ByRandom1_9");
	public static RadioButton ByFile10_30 = new RadioButton("ByFile10_30");
	public static RadioButton ByUser10_30 = new RadioButton("ByUser10_30");
	public static RadioButton ByRandom10_30 = new RadioButton("ByRandom10_30");
	public static RadioButton ByFile30_90 = new RadioButton("ByFile30_90");
	public static RadioButton ByUser30_90 = new RadioButton("ByUser30_90");
	public static RadioButton ByRandom30_90 = new RadioButton("ByRandom30_90");
	public static RadioButton ByFile90_100 = new RadioButton("ByFile90_100");
	public static RadioButton ByUser90_100 = new RadioButton("ByUser90_100");
	public static RadioButton ByRandom90_100 = new RadioButton("ByRandom90_100");
	VBox VBox1 = new VBox();

	ByFile ByFileScren = new ByFile();

	public Scene Scene_Number() {
		
		BorderPane borderPane = new BorderPane();
		borderPane.setBackground(background());
		borderPane.setPadding(new Insets(30, 150, 70, 80));

		ByFile1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-color:BLACK;-fx-font-weight:bold;");
		ByUser1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		ByRandom1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");

		ByFile1_9.setPrefSize(250, 30);
		ByUser1_9.setPrefSize(220, 30);
		ByRandom1_9.setPrefSize(220, 30);
		
		ByFile10_30.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-color:BLACK;-fx-font-weight:bold;");
		ByUser10_30.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		ByRandom10_30.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");

		ByFile10_30.setPrefSize(250, 30);
		ByUser10_30.setPrefSize(220, 30);
		ByRandom10_30.setPrefSize(220, 30);
		
		ByFile30_90.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-color:BLACK;-fx-font-weight:bold;");
		ByUser30_90.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		ByRandom30_90.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");

		ByFile30_90.setPrefSize(250, 30);
		ByUser30_90.setPrefSize(220, 30);
		ByRandom30_90.setPrefSize(220, 30);
		
		ByFile90_100.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-color:BLACK;-fx-font-weight:bold;");
		ByUser90_100.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		ByRandom90_100.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");

		ByFile90_100.setPrefSize(250, 30);
		ByUser90_100.setPrefSize(220, 30);
		ByRandom90_100.setPrefSize(220, 30);

//		VBox VBox1 = new VBox();
//		VBox1.getChildren().addAll(ByFile1_9, ByUser1_9, ByRandom1_9);
		VBox1.setAlignment(Pos.CENTER);
		VBox1.setSpacing(10);

		borderPane.setRight(VBox1);
		Scene scene = new Scene(borderPane, 400, 400);
		return scene;

	}

	public static Background background() {
		Image image = new Image("tadel.jpeg");
		BackgroundSize backgroundSize = new BackgroundSize(1560, 855, false, false, false, false);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null, backgroundSize);
		Background background1 = new Background(backgroundImage);
		return background1;
	}

}

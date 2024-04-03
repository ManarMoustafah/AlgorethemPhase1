package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

	// **********************************
	static DynamicProgramming DynamicProgramming = new DynamicProgramming();
	// **********************************

	public static BorderPane root = new BorderPane();
	public static RadioButton n1_9 = new RadioButton("1==>9");
	public static RadioButton n10_30 = new RadioButton("10==>30");
	public static RadioButton n30_90 = new RadioButton("30==>90");
	public static RadioButton n90_00 = new RadioButton("90==>##");
	public static Button back = new Button("back");

	ByFile ByFile = new ByFile();
	ByUser ByUser = new ByUser();
	ByRandom ByRandom = new ByRandom();
	ByWhat ByWhat = new ByWhat();

	@Override
	public void start(Stage primaryStage) {
		try {

			n1_9.setOnAction(e -> {
				n1_9.setSelected(false);
				ByWhat.VBox1.getChildren().clear();
				ByWhat.VBox1.getChildren().addAll(ByWhat.ByFile1_9, ByWhat.ByUser1_9, ByWhat.ByRandom1_9, back);
				primaryStage.setScene(ByWhat.Scene_Number());
				primaryStage.setFullScreen(true);

			});
			n10_30.setOnAction(e -> {
				n10_30.setSelected(false);
				ByWhat.VBox1.getChildren().clear();
				ByWhat.VBox1.getChildren().addAll(ByWhat.ByFile10_30, ByWhat.ByUser10_30, ByWhat.ByRandom10_30, back);
				primaryStage.setScene(ByWhat.Scene_Number());
				primaryStage.setFullScreen(true);

			});
			n30_90.setOnAction(e -> {
				n30_90.setSelected(false);
				ByWhat.VBox1.getChildren().clear();
				ByWhat.VBox1.getChildren().addAll(ByWhat.ByFile30_90, ByWhat.ByUser30_90, ByWhat.ByRandom30_90, back);
				primaryStage.setScene(ByWhat.Scene_Number());
				primaryStage.setFullScreen(true);

			});
			n90_00.setOnAction(e -> {
				n90_00.setSelected(false);
				ByWhat.VBox1.getChildren().clear();
				ByWhat.VBox1.getChildren().addAll(ByWhat.ByFile90_100, ByWhat.ByUser90_100, ByWhat.ByRandom90_100,
						back);
				primaryStage.setScene(ByWhat.Scene_Number());
				primaryStage.setFullScreen(true);

			});
//=====================================1--9===========================================================

			ByWhat.ByUser1_9.setOnAction(e -> {
				ByWhat.ByUser1_9.setSelected(false);

				ByUser.CHOOSE.getChildren().clear();
				ByUser.CHOOSE.getChildren().addAll(ByUser.expected_result1_9, ByUser.DP_table, ByUser.The_LEDs,
						ByUser.Demonstrate1_9, ByUser.back);
				primaryStage.setScene(ByUser.Scene_ByUser(1, 9));
				primaryStage.setFullScreen(true);

			});

			ByWhat.ByFile1_9.setOnAction(e -> {
				ByWhat.ByFile1_9.setSelected(false);

				ByFile.HBox1.getChildren().addAll(ByFile.expected_result, ByFile.DP_table, ByFile.The_LEDs,
						ByFile.Demonstrate1_9, ByFile.back);
				primaryStage.setScene(ByFile.Scene_ByFile());
				primaryStage.setFullScreen(true);

			});
			ByWhat.ByRandom1_9.setOnAction(e -> {
				ByWhat.ByRandom1_9.setSelected(false);

				ByRandom.CHOOSE.getChildren().addAll(ByRandom.expected_result1_9, ByRandom.DP_table, ByRandom.The_LEDs,
						ByRandom.Demonstrate1_9, ByRandom.back);
				primaryStage.setScene(ByRandom.Scene_ByRandom(1, 9));
				primaryStage.setFullScreen(true);

			});
//=====================================10--30===========================================================

			ByWhat.ByUser10_30.setOnAction(e -> {
				ByWhat.ByUser10_30.setSelected(false);

				ByUser.CHOOSE.getChildren().clear();
				ByUser.CHOOSE.getChildren().addAll(ByUser.expected_result1_9, ByUser.DP_table, ByUser.The_LEDs,
						ByUser.Demonstrate10_30, ByUser.back);
				primaryStage.setScene(ByUser.Scene_ByUser(10, 30));
				primaryStage.setFullScreen(true);

			});

			ByWhat.ByFile10_30.setOnAction(e -> {
				ByWhat.ByFile10_30.setSelected(false);

				ByFile.HBox1.getChildren().clear();
				ByFile.HBox1.getChildren().addAll(ByFile.expected_result, ByFile.DP_table, ByFile.The_LEDs,
						ByFile.Demonstrate10_30, ByFile.back);
				primaryStage.setScene(ByFile.Scene_ByFile());
				primaryStage.setFullScreen(true);

			});
			ByWhat.ByRandom10_30.setOnAction(e -> {
				ByWhat.ByRandom10_30.setSelected(false);

				ByRandom.CHOOSE.getChildren().addAll(ByRandom.expected_result1_9, ByRandom.DP_table, ByRandom.The_LEDs,
						ByRandom.Demonstrate10_30, ByRandom.back);
				primaryStage.setScene(ByRandom.Scene_ByRandom(10, 30));
				primaryStage.setFullScreen(true);

			});
//=====================================30--90===========================================================

			ByWhat.ByUser30_90.setOnAction(e -> {
				ByWhat.ByUser30_90.setSelected(false);

				ByUser.CHOOSE.getChildren().clear();
				ByUser.CHOOSE.getChildren().addAll(ByUser.expected_result1_9, ByUser.DP_table, ByUser.The_LEDs,
						ByUser.Demonstrate30_90, ByUser.back);
				primaryStage.setScene(ByUser.Scene_ByUser(30, 90));
				primaryStage.setFullScreen(true);

			});

			ByWhat.ByFile30_90.setOnAction(e -> {
				ByWhat.ByFile30_90.setSelected(false);

				ByFile.HBox1.getChildren().clear();
				ByFile.HBox1.getChildren().addAll(ByFile.expected_result, ByFile.DP_table, ByFile.The_LEDs,
						ByFile.Demonstrate30_90, ByFile.back);
				primaryStage.setScene(ByFile.Scene_ByFile());
				primaryStage.setFullScreen(true);

			});
			ByWhat.ByRandom30_90.setOnAction(e -> {
				ByWhat.ByRandom30_90.setSelected(false);

				ByRandom.CHOOSE.getChildren().addAll(ByRandom.expected_result1_9, ByRandom.DP_table, ByRandom.The_LEDs,
						ByRandom.Demonstrate30_90, ByRandom.back);
				primaryStage.setScene(ByRandom.Scene_ByRandom(30, 90));
				primaryStage.setFullScreen(true);

			});
//=========================================================================================
			ByUser.back.setOnAction(u -> {
				ByUser.CHOOSE.getChildren().clear();
				primaryStage.setScene(ByWhat.Scene_Number());
				primaryStage.setFullScreen(true);

			});
			ByRandom.back.setOnAction(u -> {
				ByRandom.CHOOSE.getChildren().clear();
				primaryStage.setScene(ByWhat.Scene_Number());
				primaryStage.setFullScreen(true);

			});
			ByFile.back.setOnAction(u -> {
				ByFile.count = 0;
				ByFile.HBox1.getChildren().clear();
				primaryStage.setScene(ByWhat.Scene_Number());
				primaryStage.setFullScreen(true);

			});

			root.setBackground(Background());
			mainborderPane(root);
			Scene scene = new Scene(mainborderPane(root), 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setFullScreen(true);

			back.setOnAction(r -> {
				primaryStage.setScene(scene);
				primaryStage.setFullScreen(true);

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public BorderPane mainborderPane(BorderPane x) {

		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(400, 100, 30, 600));
		borderPane.setBackground(Background());

		n1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		n10_30.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		n30_90.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		n90_00.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");

		VBox VBox = new VBox();
		VBox.getChildren().addAll(n1_9, n10_30, n30_90, n90_00);
		VBox.setAlignment(Pos.CENTER);
		VBox.setSpacing(10);

		borderPane.setRight(VBox);
		return borderPane;

	}

	public static Background Background() {
		Image image = new Image("tadel.jpeg");
		BackgroundSize backgroundSize = new BackgroundSize(1560, 855, false, false, false, false);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null, backgroundSize);
		Background background1 = new Background(backgroundImage);
		return background1;
	}

}

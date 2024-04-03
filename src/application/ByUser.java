package application;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ByUser {

	GridPane GridPaneForBox = new GridPane();
	GridPane GridPaneForOk = new GridPane();
	public static RadioButton expected_result1_9 = new RadioButton("expected_result");
	Button back = new Button("back");
	public static RadioButton DP_table = new RadioButton("DP_table");
	public static RadioButton The_LEDs = new RadioButton("The_LEDs");
	public static RadioButton Demonstrate1_9 = new RadioButton("Demonstrate");
	public static RadioButton Demonstrate10_30 = new RadioButton("Demonstrate1020");
	public static RadioButton Demonstrate30_90 = new RadioButton("Demonstrate1020");
	public static RadioButton Demonstrate90_100 = new RadioButton("Demonstrate1020");
	HBox CHOOSE = new HBox();
	String[] sorses;
	int loop;
	String[] s;
	HBox hBox3 = new HBox(10);

	public Scene Scene_ByUser(int num1, int num2) {

		BorderPane borderPane = new BorderPane();

		CHOOSE.setAlignment(Pos.CENTER);

		Label LabelOfNumForUser = new Label("LabelOfNumForUser");
		Button okForNum = new Button("ok");
		LabelOfNumForUser.setStyle("-fx-background-radius: 30;-fx-background-color: BLACK;-fx-text-fill:#DCDCDC ");
		LabelOfNumForUser.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.ITALIC, 20));

		ComboBox<Integer> comboBoxCount = new ComboBox<>();
		for (int i = num1; i <= num2; i++) {
			comboBoxCount.getItems().addAll(i);
		}

		VBox hBox1 = new VBox(10);
		hBox1.getChildren().clear();
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(LabelOfNumForUser, comboBoxCount, okForNum);
		FlowPane hBox2 = new FlowPane();
		hBox2.setPadding(new Insets(10));
		hBox2.setHgap(10);
		hBox2.setVgap(10);
		hBox2.setAlignment(Pos.CENTER);

		expected_result1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		DP_table.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		The_LEDs.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		Demonstrate1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		Demonstrate10_30.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		Demonstrate30_90.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");

		hBox3.setAlignment(Pos.CENTER);
		hBox3.getChildren().clear();
		hBox3.getChildren().addAll(hBox1, hBox2);

		okForNum.setOnAction(e -> {
			sorses = new String[comboBoxCount.getValue()];

			for (int i = 0; i < comboBoxCount.getValue(); i++) {
				sorses[i] = i + 1 + "";
			}
			createComboBoxes(comboBoxCount.getValue(), hBox2);

		});

// ==============================expected_result=========================================

		expected_result1_9.setOnAction(t -> {
			expected_result1_9.setSelected(false);
			TextField expected_result_tf = new TextField();
			expected_result_tf.setText(Main.DynamicProgramming.numofLedsnew(sorses, leds()) + ""); // b)
			HBox HBox2 = new HBox();
			HBox2.getChildren().addAll(expected_result_tf);
			HBox2.setAlignment(Pos.CENTER);
			borderPane.setBottom(HBox2);
		});

//==============================DP_table=========================================

		DP_table.setOnAction(W -> {
			TextArea DP_table_tf = new TextArea();
			DP_table.setSelected(false);
			//DP_table_tf.setStyle("-fx-text-fill: blue;-fx-font-weight: bold;-fx-font-style: italic;");
			DP_table_tf.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
			DP_table_tf.setText(Main.DynamicProgramming.tableofcountsnew(sorses, leds()) + "");
			HBox HBox2 = new HBox();
			HBox2.getChildren().addAll(DP_table_tf);
			HBox2.setAlignment(Pos.CENTER);
			borderPane.setBottom(HBox2);
		});
// ==============================The_LEDs=========================================
		The_LEDs.setOnAction(r -> {// print_LCS_ReturnS
			The_LEDs.setSelected(false);
			TextField The_LEDs_tf = new TextField();
			The_LEDs_tf.setText(Main.DynamicProgramming.CommomSubsequencesnew(sorses, leds()));
			HBox HBox2 = new HBox();
			HBox2.getChildren().addAll(The_LEDs_tf);
			HBox2.setAlignment(Pos.CENTER);
			borderPane.setBottom(HBox2);
		});
// ==============================Demonstrate=========================================
		Demonstrate1_9.setOnAction(t -> {
			Demonstrate1_9.setSelected(false);

			Pane Pane = new Pane();
			Pane.getChildren().clear();
			Pane.setPrefWidth(1000);
			Pane.setPrefHeight(300);
			Pane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"); // no color pane 0.5%
			int x = -100;// Label1.setLayoutX
			int z = -100;// Label2.setLayoutX
			for (int i = 0; i < leds().length; i++) {
				int y = i + 1;
				Label Label1 = new Label("" + y + "");
				Label Label2 = new Label("" + leds()[i] + "");

				Label1.setStyle(
						"-fx-background-radius:30;-fx-font-size:25px;-fx-font-weight:bold;-fx-background-color:	STEELBLUE;-fx-border-color:GOLD; -fx-border-width: 4 4 4 4;-fx-border-radius:30;");
				Label2.setStyle(
						"-fx-background-radius:30;-fx-font-size:25px;-fx-font-weight:bold;-fx-background-color:	STEELBLUE;-fx-border-color:GOLD; -fx-border-width: 4 4 4 4;-fx-border-radius:30;");
				Label1.setPrefWidth(50);
				Label2.setPrefWidth(50);

				Pane.getChildren().addAll(Label1, Label2);
				Label1.setLayoutX(x += 100);
				Label2.setLayoutX(z += 100);
				Label2.setLayoutY(100);

				Image off = new Image("off.jpeg");
				ImageView imageView1 = new ImageView(off);
				imageView1.setFitWidth(50); // Set the width
				imageView1.setFitHeight(80); // Set the height
				Pane.getChildren().add(imageView1);
				imageView1.setLayoutX(y = 100 * i);
				imageView1.setLayoutY(150);

			}

			for (int i = 0; i < Main.DynamicProgramming.numofLedsnew(sorses, leds()); i++) {
				int z1 = Integer.parseInt(Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds())[i] + "");
				int z2 = findIndexInArray(leds(), Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds())[i]);
				Line Line = new Line();
				Line line = new Line((100 * z2) + 20, 100, ((z1 - 1) * 100) + 20, 50);
				line.setStroke(Color.BLACK);
				line.setStrokeWidth(5);
				Pane.getChildren().add(line);

				Image off = new Image("on.jpeg");
				ImageView imageView1 = new ImageView(off);
				imageView1.setFitWidth(50); // Set the width
				imageView1.setFitHeight(80); // Set the height
				Pane.getChildren().add(imageView1);
				imageView1.setLayoutX(100 * z2);
				imageView1.setLayoutY(150);

			}
			HBox HBox2 = new HBox();
			HBox2.getChildren().addAll(Pane);
			HBox2.setAlignment(Pos.CENTER);
			// HBox1.setSpacing(10);
			borderPane.setBottom(HBox2);

		});

//======================================================================
		Demonstrate10_30.setOnAction(t -> {
			Demonstrate10_30.setSelected(false);

			Pane Pane = new Pane();
			Pane.getChildren().clear();
			Pane.setPrefWidth(2200);
			Pane.setPrefHeight(300);
			Pane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"); // no color pane 0.5%
			int x = -50;// Label1.setLayoutX
			int z = -50;// Label2.setLayoutX
			for (int i = 0; i < sorses.length; i++) {
				int y = i + 1;
				Label Label1 = new Label("" + y + "");
				Label Label2 = new Label("" + leds()[i] + "");

				Label1.setStyle(
						"-fx-background-radius:30;-fx-font-size:25px;-fx-font-weight:bold;-fx-background-color:	STEELBLUE;-fx-border-color:GOLD; -fx-border-width: 4 4 4 4;-fx-border-radius:30;");
				Label2.setStyle(
						"-fx-background-radius:30;-fx-font-size:25px;-fx-font-weight:bold;-fx-background-color:	STEELBLUE;-fx-border-color:GOLD; -fx-border-width: 4 4 4 4;-fx-border-radius:30;");
				Label1.setPrefWidth(50);
				Label2.setPrefWidth(50);

				Pane.getChildren().addAll(Label1, Label2);
				Label1.setLayoutX(x += 50);
				Label2.setLayoutX(z += 50);
				Label2.setLayoutY(100);

				Image off = new Image("off.jpeg");
				ImageView imageView1 = new ImageView(off);
				imageView1.setFitWidth(50); // Set the width
				imageView1.setFitHeight(80); // Set the height
				Pane.getChildren().add(imageView1);
				imageView1.setLayoutX(y = 50 * i);
				imageView1.setLayoutY(150);

			}

			for (int i = 0; i < Main.DynamicProgramming.numofLedsnew(sorses, leds()); i++) {
				int z1 = Integer.parseInt(Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds())[i] + "");
				int z2 = findIndexInArray(leds(), Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds())[i]);
				Line Line = new Line();
				Line line = new Line((50 * z2) + 20, 100, ((z1 - 1) * 50) + 20, 50);
				line.setStroke(Color.BLACK);
				line.setStrokeWidth(5);
				Pane.getChildren().add(line);

				Image off = new Image("on.jpeg");
				ImageView imageView1 = new ImageView(off);
				imageView1.setFitWidth(50); // Set the width
				imageView1.setFitHeight(80); // Set the height
				Pane.getChildren().add(imageView1);
				imageView1.setLayoutX(50 * z2);
				imageView1.setLayoutY(150);

			}
			HBox HBox2 = new HBox();
			HBox2.getChildren().addAll(Pane);
			HBox2.setAlignment(Pos.CENTER);
			// HBox1.setSpacing(10);
			borderPane.setBottom(HBox2);

		});
//========================================================================================
		Demonstrate30_90.setOnAction(t -> {
			Demonstrate30_90.setSelected(false);

			Pane Pane = new Pane();
			Pane.getChildren().clear();
			Pane.setPrefWidth(2200);
			Pane.setPrefHeight(300);
			Pane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"); // no color pane 0.5%
			int x = -20;// Label1.setLayoutX
			int z = -20;// Label2.setLayoutX
			for (int i = 0; i < sorses.length; i++) {
				int y = i + 1;
				Label Label1 = new Label("" + y + "");
				Label Label2 = new Label("" + leds()[i] + "");

				Label1.setStyle(
						"-fx-background-radius:30;-fx-font-size:15px;-fx-font-weight:bold;-fx-background-color:	STEELBLUE;-fx-border-color:GOLD;-fx-border-radius:30;");
				Label2.setStyle(
						"-fx-background-radius:30;-fx-font-size:15px;-fx-font-weight:bold;-fx-background-color:	STEELBLUE;-fx-border-color:GOLD;-fx-border-radius:30;");

				Label1.setPrefWidth(20);
				Label2.setPrefWidth(20);
				Pane.getChildren().addAll(Label1, Label2);
				Label1.setLayoutX(x += 20);
				Label2.setLayoutX(z += 20);
				Label2.setLayoutY(100);

				Image off = new Image("off.jpeg");
				ImageView imageView1 = new ImageView(off);
				imageView1.setFitWidth(20); // Set the width
				imageView1.setFitHeight(30); // Set the height
				Pane.getChildren().add(imageView1);
				imageView1.setLayoutX(y = 20 * i);
				imageView1.setLayoutY(150);

			}

			for (int i = 0; i < Main.DynamicProgramming.numofLedsnew(sorses, leds()); i++) {
				int z1 = Integer.parseInt(Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds())[i] + "");
				int z2 = findIndexInArray(leds(), Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds())[i]);
				Line Line = new Line();
				Line line = new Line((20 * z2) + 20, 100, ((z1 - 1) * 20) + 20, 50);
				line.setStroke(Color.BLACK);
				line.setStrokeWidth(5);
				Pane.getChildren().add(line);

				Image off = new Image("on.jpeg");
				ImageView imageView1 = new ImageView(off);
				imageView1.setFitWidth(20); // Set the width
				imageView1.setFitHeight(30); // Set the height
				Pane.getChildren().add(imageView1);
				imageView1.setLayoutX(20 * z2);
				imageView1.setLayoutY(150);

			}
			HBox HBox2 = new HBox();
			HBox2.getChildren().addAll(Pane);
			HBox2.setAlignment(Pos.CENTER);
			// HBox1.setSpacing(10);
			borderPane.setBottom(HBox2);

		});
		// ================================================================================

		borderPane.setTop(hBox3);
		borderPane.setCenter(CHOOSE);
		borderPane.setPadding(new Insets(20, 20, 20, 20));
		borderPane.setBackground(background());
		Scene scene = new Scene(borderPane, 300, 150);
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

	private void createComboBoxes(int count, FlowPane hBox2) {

		hBox2.getChildren().clear();

		List<String> items = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			items.add(String.valueOf(i));
		}

		for (int i = 1; i <= count; i++) {
			ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(items));
			hBox2.getChildren().add(comboBox);

			comboBox.setOnAction(event -> {
				Object newValue = comboBox.getValue();

				if (newValue != null) {

					for (Node node : hBox2.getChildren()) {
						if (node instanceof ComboBox && node != comboBox) {//
							ComboBox<String> otherComboBox = (ComboBox<String>) node;
							otherComboBox.getItems().remove(newValue);
						}
					}
					String[] Sinter = new String[count];
					for (int j = 0; j < count; j++) {
						Sinter[j] = ((ComboBoxBase<Integer>) hBox2.getChildren().get(j)).getValue() + "";
					}
					s = Sinter;

				}
			});
		}
		Button finishButton = new Button("finishButton");
		finishButton.setOnAction(event -> {
			for (int j = 0; j < s.length; j++) {
				if (s[j].equals("null")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("INFORMATION");
					alert.setContentText("ERROR");
					alert.show();
					break;
				}
			}

		});
		hBox2.getChildren().add(finishButton);
	}

	public String[] leds() {
		return s;
	}

	public static int findIndexInArray(String[] array, String target) {
		// Iterate through the array
		for (int i = 0; i < array.length; i++) {
			// Use indexOf to check if the target is present in the current string
			int indexInString = array[i].indexOf(target);

			// If the target is found in the current string, return the overall index
			if (indexInString != -1) {
				return i;
			}
		}

		// Target not found in any string in the array
		return -1;
	}

}

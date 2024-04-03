package application;

import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ByRandom {

	Label LByRandom = new Label("LByRandom");
	Button genarate = new Button("genarate");
	int count;
	public static String[] leds1;
	String[] sorses;

	public static RadioButton expected_result1_9 = new RadioButton("expected_result1_9");

	public static RadioButton DP_table = new RadioButton("DP_table");
	public static RadioButton The_LEDs = new RadioButton("The_LEDs");
	public static RadioButton Demonstrate1_9 = new RadioButton("Demonstrate");
	public static RadioButton Demonstrate10_30 = new RadioButton("Demonstrate1020");
	public static RadioButton Demonstrate30_90 = new RadioButton("Demonstrate1020");
	public static RadioButton Demonstrate90_100 = new RadioButton("Demonstrate1020");
	public static HBox CHOOSE = new HBox();
	public static Button back = new Button("back");

	public Scene Scene_ByRandom(int num1, int num2) {

		HBox HBox1 = new HBox();
		HBox1.setAlignment(Pos.CENTER);
		ComboBox<Integer> comboBoxCount = new ComboBox<>();
		for (int i = num1; i <= num2; i++) {
			comboBoxCount.getItems().addAll(i);
		}
		HBox1.getChildren().addAll(comboBoxCount, genarate);
		comboBoxCount.setValue(null);

		BorderPane borderPane = new BorderPane();

		genarate.setOnAction(e -> {

			borderPane.setBottom(null);
			count = Integer.parseInt(comboBoxCount.getValue() + "");
			sorses = new String[count];
			for (int i = 0; i < count; i++) {
				sorses[i] = i + 1 + "";
				System.out.println(sorses[i]);
			}

			Random Generator1 = new Random();

			System.out.println(count);
			leds1 = new String[count];
			for (int i = 0; i < count; i++) {
				leds1[i] = "";

			}
			for (int i = 0; i < count;) {

				int randomNumber = Generator1.nextInt(count + 1);
				if (randomNumber >= 1 && containsSpaceSeparatedStrings(leds1, (randomNumber + "")) == false) {
					leds1[i] = randomNumber + "";
					i++;
				}

			}
			System.out.println("Random Numbers:");
			for (String number : leds1) {
				System.out.println(number);
			}

// ==============================expected_result=========================================

			expected_result1_9.setOnAction(t -> {
				expected_result1_9.setSelected(false);
				TextField expected_result_tf = new TextField();
				expected_result_tf.setText(Main.DynamicProgramming.numofLedsnew(sorses, leds1) + ""); // b)
				HBox HBox2 = new HBox();
				HBox2.getChildren().addAll(expected_result_tf);
				HBox2.setAlignment(Pos.CENTER);
				borderPane.setBottom(HBox2);
			});

//==============================DP_table=========================================

			DP_table.setOnAction(W -> {
				TextArea DP_table_tf = new TextArea();
				DP_table.setSelected(false);
				DP_table_tf.setText(Main.DynamicProgramming.tableofAULsnew(sorses, leds1) + "");
				HBox HBox2 = new HBox();
				HBox2.getChildren().addAll(DP_table_tf);
				HBox2.setAlignment(Pos.CENTER);
				borderPane.setBottom(HBox2);
			});
// ==============================The_LEDs=========================================
			The_LEDs.setOnAction(r -> {// print_LCS_ReturnS
				The_LEDs.setSelected(false);
				TextField The_LEDs_tf = new TextField();
				The_LEDs_tf.setText(Main.DynamicProgramming.CommomSubsequencesnew(sorses, leds1));
				HBox HBox2 = new HBox();
				HBox2.getChildren().addAll(The_LEDs_tf);
				HBox2.setAlignment(Pos.CENTER);
				borderPane.setBottom(HBox2);
			});

// ==============================Demonstrate=========================================
			Demonstrate1_9.setOnAction(t -> {
				Demonstrate1_9.setSelected(false);
				borderPane.setTop(HBox1);

				Pane Pane = new Pane();
				Pane.setPrefWidth(1000);
				Pane.setPrefHeight(300);
				Pane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"); // no color pane 0.5%
				int x = -100;// Label1.setLayoutX
				int z = -100;// Label2.setLayoutX
				for (int i = 0; i < count; i++) {
					int y = i + 1;
					Label Label1 = new Label("" + y + "");
					Label Label2 = new Label("" + leds1[i] + "");

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

				for (int i = 0; i < Main.DynamicProgramming.numofLedsnew(sorses, leds1); i++) {
					int z1 = Integer.parseInt(Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds1)[i] + "");
					int z2 = findIndexInArray(leds1,
							Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds1)[i]);
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

// ==============================Demonstrate=========================================
			Demonstrate10_30.setOnAction(t -> {
				Demonstrate10_30.setSelected(false);
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
					Label Label2 = new Label("" + leds1[i] + "");

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

				for (int i = 0; i < Main.DynamicProgramming.numofLedsnew(sorses, leds1); i++) {
					int z1 = Integer.parseInt(Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds1)[i] + "");
					int z2 = findIndexInArray(leds1,
							Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds1)[i]);
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

//=====================================================================================
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
					Label Label2 = new Label("" + leds1[i] + "");
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
				}
				for (int i = 0; i < Main.DynamicProgramming.numofLedsnew(sorses, leds1); i++) {
					int z1 = Integer.parseInt(Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds1)[i] + "");
					int z2 = findIndexInArray(leds1,
							Main.DynamicProgramming.CommomSubsequencesnewaray(sorses, leds1)[i]);
					Line Line = new Line();
					Line line = new Line((20 * z2) + 10, 100, ((z1 - 1) * 20) + 10, 25);
					line.setStroke(Color.BLACK);
					line.setStrokeWidth(2);
					Pane.getChildren().add(line);
				}
				HBox HBox2 = new HBox();
				HBox2.getChildren().addAll(Pane);
				HBox2.setAlignment(Pos.CENTER);
				// HBox1.setSpacing(10);
				borderPane.setBottom(HBox2);

			});
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("INFORMATION");
			alert.setContentText("The operation was completed successfully");
			alert.show();
		});
//======================================================================================

		expected_result1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		DP_table.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		The_LEDs.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		Demonstrate1_9.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		Demonstrate10_30.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");
		Demonstrate30_90.setStyle("-fx-background-radius:30;-fx-font-size:30px;-fx-font-weight:bold;");

		CHOOSE.setAlignment(Pos.CENTER);

		borderPane.setPadding(new Insets(0, 0, 0, 0));
		borderPane.setBackground(background());
		borderPane.setTop(HBox1);
		borderPane.setCenter(CHOOSE);
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

	public static boolean containsSpaceSeparatedString(String[] array, String target) {
		// Iterate through the array
		for (String element : array) {
			// Check if the target space-separated string is contained in the current
			// element
			if (element.contains(target)) {
				return true;
			}
		}

		// Target string not found in any element of the array
		return false;
	}

	public static boolean containsSpaceSeparatedStrings(String[] array, String target) {
		// Iterate through the array
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(target)) {
				return true;

			}
		}
		return false;
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

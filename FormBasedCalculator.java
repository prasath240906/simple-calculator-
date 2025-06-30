
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormBasedCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels
        Label label1 = new Label("Enter First Value");
        Label label2 = new Label("Enter Second Value");
        Label label3 = new Label("Select Operation");
        Label label4 = new Label("TOTAL");

        // TextFields
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        // ComboBox for operators
        ComboBox<String> operatorBox = new ComboBox<>();
        operatorBox.getItems().addAll("+", "-", "*", "/");
        operatorBox.setValue("+");

        // Calculate Button
        Button calcButton = new Button("CALCULATE");

        // Event Handling
        calcButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                String op = operatorBox.getValue();
                double result = 0;

                switch (op) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            resultField.setText("Error: Divide by zero");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input");
            }
        });

        // Layout using GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(15);

        // Adding nodes to the grid
        grid.add(label1, 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(label3, 0, 2);
        grid.add(operatorBox, 1, 2);
        grid.add(calcButton, 1, 3);
        grid.add(label4, 0, 4);
        grid.add(resultField, 1, 4);

        // Scene and stage setup
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Form-Based Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

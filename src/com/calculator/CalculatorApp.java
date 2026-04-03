package com.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @Override
    public void start(Stage stage) {
        display = new TextField();
        display.setEditable(false);
        display.setFocusTraversable(false);
        display.setPrefHeight(60);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.getStyleClass().add("display");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        String[][] buttons = {
                {"sin", "cos", "tan", "DEL"},
                {"log", "ln", "sqrt", "C"},
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "x²", "+"},
                {"="}
        };

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String text = buttons[row][col];
                Button button = createButton(text);

                if ("=".equals(text)) {
                    button.setPrefWidth(290);
                    grid.add(button, 0, row, 4, 1);
                } else {
                    grid.add(button, col, row);
                }
            }
        }

        VBox root = new VBox(15, display, grid);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 360, 520);
        scene.getStylesheets().add(
                getClass().getResource("/styles.css").toExternalForm()
        );

        stage.setTitle("Scientific Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(65, 50);
        button.getStyleClass().add("calc-button");

        button.setOnAction(e -> handleButtonClick(text));
        return button;
    }

    private void handleButtonClick(String value) {
        try {
            switch (value) {
                case "C":
                    display.clear();
                    firstNumber = 0;
                    operator = "";
                    startNewNumber = true;
                    break;

                case "DEL":
                    String currentText = display.getText();
                    if (!currentText.isEmpty()) {
                        display.setText(currentText.substring(0, currentText.length() - 1));
                    }
                    break;

                case "+":
                case "-":
                case "*":
                case "/":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText());
                        operator = value;
                        startNewNumber = true;
                    }
                    break;

                case "=":
                    if (!display.getText().isEmpty() && !operator.isEmpty()) {
                        double secondNumber = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.calculate(firstNumber, secondNumber, operator);
                        display.setText(CalculatorLogic.formatResult(result));
                        operator = "";
                        startNewNumber = true;
                    }
                    break;

                case "sqrt":
                    if (!display.getText().isEmpty()) {
                        double number = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.squareRoot(number);
                        display.setText(CalculatorLogic.formatResult(result));
                        startNewNumber = true;
                    }
                    break;

                case "x²":
                    if (!display.getText().isEmpty()) {
                        double number = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.square(number);
                        display.setText(CalculatorLogic.formatResult(result));
                        startNewNumber = true;
                    }
                    break;

                case "sin":
                    if (!display.getText().isEmpty()) {
                        double number = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.sin(number);
                        display.setText(CalculatorLogic.formatResult(result));
                        startNewNumber = true;
                    }
                    break;

                case "cos":
                    if (!display.getText().isEmpty()) {
                        double number = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.cos(number);
                        display.setText(CalculatorLogic.formatResult(result));
                        startNewNumber = true;
                    }
                    break;

                case "tan":
                    if (!display.getText().isEmpty()) {
                        double number = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.tan(number);
                        display.setText(CalculatorLogic.formatResult(result));
                        startNewNumber = true;
                    }
                    break;

                case "log":
                    if (!display.getText().isEmpty()) {
                        double number = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.log(number);
                        display.setText(CalculatorLogic.formatResult(result));
                        startNewNumber = true;
                    }
                    break;

                case "ln":
                    if (!display.getText().isEmpty()) {
                        double number = Double.parseDouble(display.getText());
                        double result = CalculatorLogic.ln(number);
                        display.setText(CalculatorLogic.formatResult(result));
                        startNewNumber = true;
                    }
                    break;

                case ".":
                    if (startNewNumber) {
                        display.setText("0.");
                        startNewNumber = false;
                    } else if (!display.getText().contains(".")) {
                        display.setText(display.getText() + ".");
                    }
                    break;

                default:
                    if (startNewNumber) {
                        display.setText(value);
                        startNewNumber = false;
                    } else {
                        display.setText(display.getText() + value);
                    }
                    break;
            }
        } catch (Exception e) {
            display.setText("Error");
            startNewNumber = true;
            operator = "";
        }
    }
}
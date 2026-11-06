package br.pucpr.codigomorse;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Map;

public class TreeVisualizer extends Application {

    private static final int WINDOW_WIDTH = 1100;
    private static final int WINDOW_HEIGHT = 750;

    private final MorseBST bst = new MorseBST();
    private final MorseSoundPlayer soundPlayer = new MorseSoundPlayer();

    private TextField inputField;
    private TextArea resultArea;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Código Morse com Árvore Binária de Busca");

        fillTree(bst);

        BorderPane root = new BorderPane();
        root.setTop(createControlPanel());
        root.setCenter(createTreePanel());

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private VBox createControlPanel() {
        Label inputLabel = new Label("Digite um texto ou um código Morse (letras separadas por espaço, palavras por /):");

        inputField = new TextField();
        inputField.setPromptText("Ex.: SOS   ou   ... --- ...");
        inputField.setOnAction(event -> handleEncode());

        Button encodeButton = new Button("Codificar");
        Button decodeButton = new Button("Decodificar");
        Button soundButton = new Button("Tocar som");
        Button clearButton = new Button("Limpar");

        encodeButton.setOnAction(event -> handleEncode());
        decodeButton.setOnAction(event -> handleDecode());
        soundButton.setOnAction(event -> handlePlaySound());
        clearButton.setOnAction(event -> handleClear());

        HBox buttonRow = new HBox(10, encodeButton, decodeButton, soundButton, clearButton);

        resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);
        resultArea.setPrefRowCount(3);
        resultArea.setPromptText("O resultado aparece aqui");

        statusLabel = new Label();

        VBox panel = new VBox(8, inputLabel, inputField, buttonRow, new Label("Resultado:"), resultArea, statusLabel);
        panel.setPadding(new Insets(12));
        return panel;
    }

    private ScrollPane createTreePanel() {
        int height = bst.getHeight();
        int canvasHeight = 100 + height * 100;
        int canvasWidth = (int) Math.pow(2, height) * 40;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        new TreeDrawer().drawTree(canvas, bst.getRoot());


        ScrollPane scrollPane = new ScrollPane(canvas);
        scrollPane.setPannable(true);
        scrollPane.setHvalue(0.5);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        return scrollPane;
    }



    private void handleEncode() {
        String text = inputField.getText();
        if (text.isBlank()) {
            showError("Digite um texto para codificar.");
            return;
        }

        String morse = bst.encodeMessage(text);
        resultArea.setText(morse);

        if (morse.contains("?")) {
            showWarning("Alguns caracteres não têm código Morse e viraram '?'. Use apenas letras A–Z e números.");
        } else {
            showInfo("Texto codificado com sucesso.");
        }
    }

    private void handleDecode() {
        String morse = inputField.getText();
        if (morse.isBlank()) {
            showError("Digite um código Morse para decodificar.");
            return;
        }
        if (!isMorse(morse)) {
            showError("Código Morse inválido: use apenas ponto (.), traço (-), espaço e barra (/).");
            return;
        }

        String text = bst.decodeMessage(morse);
        resultArea.setText(text);

        if (text.contains("?")) {
            showWarning("Algumas sequências não existem no Morse e viraram '?'.");
        } else {
            showInfo("Código decodificado com sucesso.");
        }
    }

    private void handlePlaySound() {
        String input = inputField.getText();
        if (input.isBlank()) {
            showError("Digite um texto ou código Morse para tocar.");
            return;
        }


        String morse = isMorse(input) ? input : bst.encodeMessage(input);
        resultArea.setText(morse);
        soundPlayer.playMorse(morse);
        showInfo("Tocando: " + morse);
    }

    private void handleClear() {
        inputField.clear();
        resultArea.clear();
        statusLabel.setText("");
        inputField.requestFocus();
    }


    private boolean isMorse(String input) {
        return input.matches("[.\\-/\\s]+");
    }

    private void showInfo(String message) {
        showStatus(message, Color.DARKGREEN);
    }

    private void showWarning(String message) {
        showStatus(message, Color.DARKORANGE);
    }

    private void showError(String message) {
        showStatus(message, Color.FIREBRICK);
    }

    private void showStatus(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setTextFill(color);
    }

    private void fillTree(MorseBST tree) {
        for (Map.Entry<Character, String> entry : MorseAlphabet.getAlphabet().entrySet()) {
            tree.insert(entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
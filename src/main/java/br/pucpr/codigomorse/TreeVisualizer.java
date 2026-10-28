package br.pucpr.codigomorse;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.util.Map;

/**
 * Janela principal (interface JavaFX) do projeto.
 *
 * ==================================================================
 *  ARQUIVO DO PEDRO (Interface JavaFX)
 *  Todas as modificações da interface devem ser feitas AQUI,
 *  principalmente dentro do método start().
 *
 *  O que fazer neste arquivo:
 *   - Campo de texto para o usuário digitar
 *   - Botões "Codificar", "Decodificar" e "Tocar som"
 *   - Área na tela para mostrar o resultado
 *   - Colocar o Canvas da árvore dentro de um ScrollPane
 *   - Mensagens de erro amigáveis
 *
 *  Métodos das outras partes que você vai chamar (não edite essas classes):
 *   - bst.encodeMessage(texto)      -> texto para Morse   (Isabelle)
 *   - bst.decodeMessage(morse)      -> Morse para texto   (Isabelle)
 *   - soundPlayer.playMorse(morse)  -> toca o som         (Laura)
 *
 *  Dica: se a interface crescer, crie classes novas para a tela
 *  (por exemplo, um painel de entrada e saída) em vez de deixar
 *  tudo neste arquivo.
 * ==================================================================
 */
public class TreeVisualizer extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visualizador de Árvore Binária");

        MorseBST bst = new MorseBST();
        fillTree(bst);

        int height = bst.getHeight();
        int canvasHeight = 100 + height * 100;
        int canvasWidth = (int) Math.pow(2, height) * 40;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        new TreeDrawer().drawTree(canvas, bst.getRoot());

        // TODO (Pedro): criar aqui os componentes da interface
        //  (campo de texto, botões Codificar / Decodificar / Tocar som,
        //  área de resultado) e ligar cada botão aos métodos da MorseBST
        //  e da MorseSoundPlayer.

        Group root = new Group();
        root.getChildren().add(canvas);

        // TODO (Pedro): trocar este Group por um layout que comporte os
        //  componentes acima (por exemplo, VBox ou BorderPane) e colocar
        //  o canvas dentro de um ScrollPane, porque a árvore fica larga.

        Scene scene = new Scene(root, canvasWidth, canvasHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fillTree(MorseBST bst) {
        for (Map.Entry<Character, String> entry : MorseAlphabet.getAlphabet().entrySet()) {
            bst.insert(entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
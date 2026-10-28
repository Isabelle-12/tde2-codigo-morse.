package br.pucpr.codigomorse;

public class MorseBST {
    private Node root;

    public MorseBST() {
        root = new Node(' ');
    }

    public Node getRoot() {
        return root;
    }

    // TODO (Gabriela): ponto (.) vai para a esquerda, traço (-) vai para a direita
    public void insert(char letter, String morseCode) {
    }

    // TODO (Isabelle)
    public char decodeLetter(String morseCode) {
        return '?';
    }

    // TODO (Isabelle)
    public String encodeLetter(char letter) {
        return "";
    }

    // TODO (Isabelle)
    public String decodeMessage(String morse) {
        return "";
    }

    // TODO (Isabelle)
    public String encodeMessage(String text) {
        return "";
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
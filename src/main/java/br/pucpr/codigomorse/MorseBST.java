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
        if (morseCode == null || morseCode.isEmpty()) {
            throw new IllegalArgumentException("Código Morse vazio para a letra " + letter);
        }

        Node current = root;

        for (int i = 0; i < morseCode.length(); i++) {
            char symbol = morseCode.charAt(i);

            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new Node(' '); // nó intermediário vazio
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new Node(' '); // nó intermediário vazio
                }
                current = current.right;
            } else {
                throw new IllegalArgumentException(
                        "Símbolo inválido '" + symbol + "' no código " + morseCode);
            }
        }

        // último nó do caminho: é aqui que a letra fica
        current.letter = letter;
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
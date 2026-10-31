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
    // Entrada inválida não lança exceção: vira '?' na saída e o resto da
    // mensagem é processado normalmente. A interface pode checar se o
    // resultado contém '?' para avisar o usuário. O insert lança exceção
    // porque ali o erro seria do alfabeto, não do que o usuário digitou.

    public char decodeLetter(String morseCode) {
        if (morseCode == null || morseCode.isEmpty()) {
            return '?';
        }

        Node current = root;

        for (int i = 0; i < morseCode.length(); i++) {
            char symbol = morseCode.charAt(i);

            if (symbol == '.') {
                current = current.left;
            } else if (symbol == '-') {
                current = current.right;
            } else {
                return '?';
            }

            if (current == null) {
                return '?';
            }
        }

        // nó intermediário (sem letra) significa que o código não existe
        return current.letter == ' ' ? '?' : current.letter;
    }


    // TODO (Isabelle)
    public String encodeLetter(char letter) {
        char upperLetter = Character.toUpperCase(letter);

        // ' ' é a marca dos nós vazios, então nunca é uma letra procurada
        if (upperLetter == ' ') {
            return "";
        }

        StringBuilder path = new StringBuilder();
        boolean found = findPath(root, upperLetter, path);

        return found ? path.toString() : "";
    }

    private boolean findPath(Node node, char letter, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.letter == letter) {
            return true;
        }

        path.append('.');
        if (findPath(node.left, letter, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // volta atrás (backtracking)

        path.append('-');
        if (findPath(node.right, letter, path)) {
            return true;
        }
        path.setLength(path.length() - 1);

        return false;
    }

    // TODO (Isabelle)
    public String decodeMessage(String morse) {
        if (morse == null || morse.isBlank()) {
            return "";
        }

        StringBuilder message = new StringBuilder();

        for (String word : morse.trim().split("/")) {
            String decodedWord = decodeWord(word.trim());

            if (decodedWord.isEmpty()) {
                continue;
            }
            if (message.length() > 0) {
                message.append(' ');
            }
            message.append(decodedWord);
        }

        return message.toString();
    }

    private String decodeWord(String word) {
        if (word.isEmpty()) {
            return "";
        }

        StringBuilder decoded = new StringBuilder();

        for (String code : word.split("\\s+")) {
            decoded.append(decodeLetter(code));
        }

        return decoded.toString();
    }

    // TODO (Isabelle)
    public String encodeMessage(String text) {
        if (text == null || text.isBlank()) {
            return "";
        }

        StringBuilder morse = new StringBuilder();

        for (String word : text.trim().split("\\s+")) {
            if (morse.length() > 0) {
                morse.append(" / ");
            }
            morse.append(encodeWord(word));
        }

        return morse.toString();
    }

    private String encodeWord(String word) {
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            String code = encodeLetter(word.charAt(i));

            if (i > 0) {
                encoded.append(' ');
            }
            encoded.append(code.isEmpty() ? "?" : code);
        }

        return encoded.toString();
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
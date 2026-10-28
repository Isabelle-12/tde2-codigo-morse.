package br.pucpr.codigomorse;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TreeDrawer {

    private static final double NODE_RADIUS = 15;
    private static final double VERTICAL_SPACING = 120;

    public void drawTree(Canvas canvas, Node root) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        drawNode(gc, root, canvas.getWidth() / 2, 40, canvas.getWidth() / 4);
    }

    private void drawNode(GraphicsContext gc, Node node, double x, double y, double xOffset) {
        if (node == null) {
            return;
        }

        gc.setStroke(Color.BLACK);
        gc.strokeOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        gc.strokeText(String.valueOf(node.letter), x - 5, y + 5);

        if (node.left != null) {
            double newX = x - xOffset;
            double newY = y + VERTICAL_SPACING;
            gc.strokeLine(x, y + NODE_RADIUS, newX, newY - NODE_RADIUS);
            drawNode(gc, node.left, newX, newY, xOffset / 2);
        }

        if (node.right != null) {
            double newX = x + xOffset;
            double newY = y + VERTICAL_SPACING;
            gc.strokeLine(x, y + NODE_RADIUS, newX, newY - NODE_RADIUS);
            drawNode(gc, node.right, newX, newY, xOffset / 2);
        }
    }
}
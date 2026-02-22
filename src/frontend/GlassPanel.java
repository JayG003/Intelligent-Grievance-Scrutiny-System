package frontend;

import javax.swing.*;
import java.awt.*;

public class GlassPanel extends JPanel {

    private int cornerRadius = 25;
    private Color borderColor = new Color(255, 255, 255, 80);
    private Color backgroundColor = new Color(255, 255, 255, 40); // glass effect

    public GlassPanel() {
        setOpaque(false);
    }

    public GlassPanel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Glass background
        g2.setColor(backgroundColor);
        Shape shape;

        if (roundLeft && roundRight) {
            shape = new java.awt.geom.RoundRectangle2D.Float(
                    0, 0, width - 1, height - 1,
                    cornerRadius, cornerRadius);
        } else if (roundLeft) {
            shape = new java.awt.geom.RoundRectangle2D.Float(
                    0, 0, width + cornerRadius, height - 1,
                    cornerRadius, cornerRadius);
        } else if (roundRight) {
            shape = new java.awt.geom.RoundRectangle2D.Float(
                    -cornerRadius, 0, width + cornerRadius, height - 1,
                    cornerRadius, cornerRadius);
        } else {
            shape = new Rectangle(0, 0, width, height);
        }

        g2.setColor(backgroundColor);
        g2.fill(shape);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(1.5f));

        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1,cornerRadius, cornerRadius);

        g2.dispose();
    }

    private boolean roundLeft = true;
    private boolean roundRight = true;

    public void setRoundLeft(boolean value) {
        this.roundLeft = value;
    }

    public void setRoundRight(boolean value) {
        this.roundRight = value;
    }

    public void setGlassBackground(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    public void setGlassBorder(Color color) {
        this.borderColor = color;
        repaint();
    }

    // ✅ TEST MAIN METHOD
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("GlassPanel Test");
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Background to prove transparency
            JPanel bg = new JPanel();
            bg.setBackground(new Color(225, 225, 45));
            bg.setLayout(new GridBagLayout());

            GlassPanel glass = new GlassPanel(30);
            glass.setPreferredSize(new Dimension(300, 200));
            glass.setLayout(new BorderLayout());

            JLabel label = new JLabel("Glass Panel", SwingConstants.CENTER);
            label.setForeground(Color.WHITE);
            glass.add(label, BorderLayout.CENTER);

            bg.add(glass);
            frame.setContentPane(bg);

            frame.setVisible(true);
        });
    }
}
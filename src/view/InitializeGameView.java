package view;

import interface_adapter.initialize_game.InitializeGameController;
import interface_adapter.initialize_game.InitializeGameViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InitializeGameView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "initialize game";

    private final InitializeGameViewModel initializeGameViewModel;

    private final InitializeGameController initializeGameController;

    private final JLabel titleLabel = new JLabel("Game Initialization");

    private final JLabel widthLabel = new JLabel("Width of the game board: ");

    private final JTextField widthTextField = new JTextField();

    private final JLabel heightLabel = new JLabel("Height of the game board: ");

    private final JTextField heightTextField = new JTextField();

    private final JLabel widthErrorMessageLabel = new JLabel("");

    private final JLabel heightErrorMessageLabel = new JLabel("");

    private final JButton finishButton = new JButton("Finish");

    private static final float widthCoefficient = 0.3f;

    private static final float heightCoefficient = 0.6f;


    public InitializeGameView(InitializeGameViewModel initializeGameViewModel,
                              InitializeGameController initializeGameController) {
        this.initializeGameViewModel = initializeGameViewModel;
        this.initializeGameController = initializeGameController;

        // Set the dimension of the view based on the screen size
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenDimension.width * widthCoefficient);
        int height = (int) (screenDimension.height * heightCoefficient);
        setPreferredSize(new Dimension(width, height));

        setLayout(new BorderLayout());

        Font titleFont = new Font("titleFont", Font.BOLD, 25);
        Font labelFont = new Font("labelFont", Font.BOLD, 13);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        int currentX = width / 5;
        int currentY = height / 15;
        int dY = height / 18;
        int componentWidth = width * 3 / 5;
        int componentHeight = height / 15;

        titleLabel.setFont(titleFont);
        titleLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(titleLabel);
        // Move the current Y, move dY within a section and move dY + componentHeight between sections
        currentY += dY + 2 * componentHeight;

        widthLabel.setFont(labelFont);
        widthLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(widthLabel);
        currentY += dY;

        widthTextField.setFont(labelFont);
        widthTextField.setBounds(currentX, currentY, componentWidth, componentHeight);
        // Set the width to the default value
        widthTextField.setText(initializeGameViewModel.getInitializeGameState().getWidth());
        mainPanel.add(widthTextField);
        currentY += dY;

        widthErrorMessageLabel.setFont(labelFont);
        widthErrorMessageLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(widthErrorMessageLabel);
        currentY += dY + 2 * componentHeight;

        heightLabel.setFont(labelFont);
        heightLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(heightLabel);
        currentY += dY;

        heightTextField.setFont(labelFont);
        heightTextField.setBounds(currentX, currentY, componentWidth, componentHeight);

        // Set the height to the default value
        heightTextField.setText(initializeGameViewModel.getInitializeGameState().getHeight());
        mainPanel.add(heightTextField);
        currentY += dY;

        heightErrorMessageLabel.setFont(labelFont);
        heightErrorMessageLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(heightErrorMessageLabel);
        currentY += dY + 2 * componentHeight;

        add(mainPanel, BorderLayout.CENTER);

        finishButton.setPreferredSize(new Dimension(width, height / 8));
        finishButton.setBackground(Color.BLACK);
        finishButton.setForeground(Color.WHITE);
        finishButton.setFont(titleFont);
        add(finishButton, BorderLayout.SOUTH);
        finishButton.addActionListener(this);

        widthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                checkInput();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkInput();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkInput();
            }
            private void checkInput() {
                String input = widthTextField.getText();
                initializeGameViewModel.validateAndSetWidth(input);
            }
        }
        );
        heightTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkInput();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkInput();
            }

            private void checkInput() {
                String input = heightTextField.getText();
                initializeGameViewModel.validateAndSetHeight(input);
            }

        });
        initializeGameViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == finishButton) {
            System.out.println("Reach here");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

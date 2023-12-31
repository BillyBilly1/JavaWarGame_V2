package view;

import interface_adapter.set_up_players.SetUpPlayersController;
import interface_adapter.set_up_players.SetUpPlayersState;
import interface_adapter.set_up_players.SetUpPlayersViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SetUpPlayersView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "set up players";

    private final SetUpPlayersViewModel setUpPlayersViewModel;

    private final SetUpPlayersController setUpPlayersController;

    private final JLabel titleLabel = new JLabel("Player Configuration");

    private final JLabel player1NameLabel = new JLabel("Player1's name: ");

    private final JTextField player1NameTextField = new JTextField();

    private final JLabel player2NameLabel = new JLabel("Player2's name: ");

    private final JTextField player2NameTextField = new JTextField();

    private final JLabel initialMoneyLabel = new JLabel("Initial money is: ");

    private final JTextField initialMoneyTextField = new JTextField();

    private final JLabel initialFoodAmountLabel = new JLabel("Initial food amount is: ");

    private final JTextField initialFoodAmountTextField = new JTextField();

    private final JLabel moneyErrorMessageLabel = new JLabel();

    private final JLabel foodAmountErrorMessageLabel = new JLabel();

    private final JButton finishButton = new JButton("Finish");

    private static final float widthCoefficient = 0.3f;
    private static final float heightCoefficient = 0.6f;

    public SetUpPlayersView(SetUpPlayersViewModel setUpPlayersViewModel,
                            SetUpPlayersController setUpPlayersController) {

        this.setUpPlayersViewModel = setUpPlayersViewModel;
        this.setUpPlayersController = setUpPlayersController;

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

        // Positioning variables for components
        int currentX = width / 5;
        int currentY = height / 30;
        int dY = height / 20;
        int componentWidth = width * 3 / 5;
        int componentHeight = height / 18;

        titleLabel.setFont(titleFont);
        titleLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(titleLabel);
        // Move the current Y, move dY within a section and move dY + componentHeight between sections
        currentY += dY + componentHeight;

        player1NameLabel.setFont(labelFont);
        player1NameLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(player1NameLabel);
        currentY += dY;

        player1NameTextField.setFont(labelFont);
        player1NameTextField.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(player1NameTextField);
        currentY += dY + componentHeight;

        player2NameLabel.setFont(labelFont);
        player2NameLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(player2NameLabel);
        currentY += dY;

        player2NameTextField.setFont(labelFont);
        player2NameTextField.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(player2NameTextField);
        currentY += dY + componentHeight;

        initialMoneyLabel.setFont(labelFont);
        initialMoneyLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(initialMoneyLabel);
        currentY += dY;

        initialMoneyTextField.setFont(labelFont);
        initialMoneyTextField.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(initialMoneyTextField);
        currentY += dY;

        moneyErrorMessageLabel.setFont(labelFont);
        moneyErrorMessageLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(moneyErrorMessageLabel);
        currentY += dY + componentHeight;

        initialFoodAmountLabel.setFont(labelFont);
        initialFoodAmountLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(initialFoodAmountLabel);
        currentY += dY;

        initialFoodAmountTextField.setFont(labelFont);
        initialFoodAmountTextField.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(initialFoodAmountTextField);
        currentY += dY;

        foodAmountErrorMessageLabel.setFont(labelFont);
        foodAmountErrorMessageLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(foodAmountErrorMessageLabel);
        currentY += dY + componentHeight;

        add(mainPanel, BorderLayout.CENTER);

        finishButton.setPreferredSize(new Dimension(width, height / 8));
        finishButton.setBackground(Color.BLACK);
        finishButton.setForeground(Color.WHITE);
        finishButton.setFont(titleFont);
        add(finishButton, BorderLayout.SOUTH);
        finishButton.addActionListener(this);


        // Add ActionListener to both InputTextField

        initialMoneyTextField.getDocument().addDocumentListener(new DocumentListener() {
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
                String input = initialMoneyTextField.getText();
                setUpPlayersViewModel.validateAndSetMoney(input);
            }
        }
        );
        initialFoodAmountTextField.getDocument().addDocumentListener(new DocumentListener() {

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
                String input = initialFoodAmountTextField.getText();
                setUpPlayersViewModel.validateAndSetFoodAmount(input);
            }

        });
        setUpPlayersViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SetUpPlayersState currentState = new SetUpPlayersState(setUpPlayersViewModel.getSetUpPlayersState());
        if (e.getSource() == finishButton) {
            if (player1NameTextField.getText().trim().isEmpty() ||
                    player2NameTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Either Player1's name or Player2's name is empty",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            } else if (!currentState.isValidMoneyInput() || !currentState.isValidFoodAmountInput()) {
                JOptionPane.showMessageDialog(this,
                        "Check carefully the error messages under each of the inputTextFields",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String player1Name = player1NameTextField.getText();
                String player2Name = player2NameTextField.getText();
                String initialMoney = initialMoneyTextField.getText();
                String initialFoodAmount = initialFoodAmountTextField.getText();

                currentState.setPlayer1Name(player1Name);
                currentState.setPlayer2Name(player2Name);
                currentState.setInitialMoney(initialMoney);
                currentState.setInitialFoodAmount(initialFoodAmount);

                setUpPlayersViewModel.setSetUpPlayersState(currentState);

                setUpPlayersController.execute(player1Name, player2Name, initialMoney, initialFoodAmount);
            }
        }

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("moneyErrorMessage".equals(evt.getPropertyName())) {
            String errorMessage = setUpPlayersViewModel.getSetUpPlayersState().getMoneyErrorMessage();
            moneyErrorMessageLabel.setText(errorMessage);
        };

        if ("foodAmountErrorMessage".equals(evt.getPropertyName())) {
            String errorMessage = setUpPlayersViewModel.getSetUpPlayersState().getFoodAmountErrorMessage();
            foodAmountErrorMessageLabel.setText(errorMessage);
        }

        if ("sameName".equals(evt.getPropertyName())) {
            player1NameTextField.setText(setUpPlayersViewModel.getSetUpPlayersState().getPlayer1Name());
            player2NameTextField.setText(setUpPlayersViewModel.getSetUpPlayersState().getPlayer2Name());
        }
    }
}
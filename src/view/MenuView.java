package view;

import interface_adapter.MenuViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.load_game.LoadGameController;
import interface_adapter.set_up_players.SetUpPlayersViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {

    private final ViewManagerModel viewManagerModel;

    private final MenuViewModel menuViewModel;

    private final LoadGameController loadGameController;

    private final JLabel titleLabel = new JLabel("Matchstick Chess");

    private final JButton newGameButton = new JButton("New Game");

    private final JButton loadGameButton = new JButton("Load Game");

    private static final float widthCoefficient = 0.3f;

    private static final float heightCoefficient = 0.6f;


    public MenuView(ViewManagerModel viewManagerModel,
                    MenuViewModel menuViewModel, LoadGameController loadGameController) {
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
        this.loadGameController = loadGameController;

        // Set the dimension of the view based on the screen size
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenDimension.width * widthCoefficient);
        int height = (int) (screenDimension.height * heightCoefficient);
        setPreferredSize(new Dimension(width, height));

        setLayout(new BorderLayout());

        Font titleFont = new Font("titleFont", Font.BOLD, 30);
        Font buttonFont = new Font("buttonFont", Font.BOLD, 22);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        int currentX = width / 5;
        int currentY = height / 15;
        int dY = height / 18;
        int componentWidth = width * 3 / 5;
        int componentHeight = height / 6;

        titleLabel.setFont(titleFont);
        titleLabel.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(titleLabel);
        // Move the current Y, move dY within a section and move dY + componentHeight between sections
        currentY += dY + componentHeight;

        newGameButton.setFont(buttonFont);
        newGameButton.setBounds(currentX, currentY, componentWidth, componentHeight);
        mainPanel.add(newGameButton);
        currentY += dY + componentHeight;
        newGameButton.addActionListener(this);
        newGameButton.setBackground(Color.BLACK);
        newGameButton.setForeground(Color.WHITE);

        loadGameButton.setFont(buttonFont);
        loadGameButton.setBounds(currentX, currentY, componentWidth,  componentHeight);
        mainPanel.add(loadGameButton);
        loadGameButton.addActionListener(this);
        loadGameButton.setBackground(Color.BLACK);
        loadGameButton.setForeground(Color.WHITE);

        add(mainPanel, BorderLayout.CENTER);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            viewManagerModel.setActiveView(SetUpPlayersViewModel.viewName);
            viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

package UI;

import Core.Game;
import GameObjects.Clickable;
import GameObjects.Currency;
import GameObjects.Producer;
import GameObjects.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends WindowAdapter implements ActionListener {
    protected final static String EXIT_GAME = "exit_game";

    protected static CurrenyDisplay water;

    protected JFrame frame;
    protected int maxX = 500;
    protected int maxY = 500;


    public Window() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        maxX = screenSize.width - 50;
        maxY = screenSize.width - 50;
        water = new CurrenyDisplay(0, 0, "assets/255794e8a47f328.jpg", Type.WATER);
    }

    public boolean showNewWindow() {
        frame = new JFrame("Water Clicker");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Game.exit();
            }
        });

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        contentPane.add(water.getBox());

        contentPane.add(Box.createVerticalGlue());

        JButton button = new JButton("Exit Game");
        button.addActionListener(this);
        contentPane.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(EXIT_GAME);

        frame.setSize(new Dimension(1280,720));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return true;
    }


    public Box initBuildingsUI() {
        Box box = Box.createVerticalBox();

        for(Producer p : Game.getProducers()) {

        }

        return box;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(EXIT_GAME)) {
            frame.setVisible(false);
            frame.dispose();
            Game.exit();
        }
    }

    public static void updateWater() {
        water.updateAmount(Game.getCurrency(Type.WATER).getAmount());
        water.updateProduction(Game.getCurrency(Type.WATER).getProduction());
    }
}

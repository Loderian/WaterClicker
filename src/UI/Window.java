package UI;

import Core.Game;
import GameObjects.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends WindowAdapter implements ActionListener {
    protected final static String EXIT_GAME = "exit_game";

    protected static WaterLabel waterLabel;
    protected static WaterProdLabel waterProdLabel;

    protected JFrame frame;
    protected int maxX = 500;
    protected int maxY = 500;


    public Window() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        maxX = screenSize.width - 50;
        maxY = screenSize.width - 50;
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

        contentPane.add(initWaterUI());

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

    public Box initWaterUI() {
        Box box = Box.createVerticalBox();

        waterLabel = new WaterLabel("l");
        waterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(waterLabel);

        waterProdLabel = new WaterProdLabel();
        waterProdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(waterProdLabel);

        ImageIcon waterIcon = new ImageIcon("assets/255794e8a47f328.jpg");
        Image image = waterIcon.getImage();
        image = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        waterIcon = new ImageIcon(image);
        JLabel waterImg = new JLabel(waterIcon);
        waterImg.setAlignmentX(Component.CENTER_ALIGNMENT);
        waterImg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game.getCurrency(Type.WATER).click();
            }
        });

        box.add(waterImg);
        box.add(Box.createHorizontalStrut(5));

        return box;
    }

    public Box initBuildingsUI() {
        Box box = Box.createVerticalBox();



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

    public static void updateWater(double amount) {
        waterLabel.update(amount);
        waterProdLabel.update();
    }
}

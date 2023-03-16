package mf;

import tools.SafeFrame;
import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel implements ActionListener {
    private ControlPanel controls;
    private MineField view;
    private String fName;

    public AppPanel() {
        view = new MineField();
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);

        SafeFrame frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("MineField");
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"North", "South", "East", "West", "Clear", "Pen", "Color", "steps"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {

                case "North":

                    break;

                case "South":

                    break;

                case "East":

                    break;

                case "West":

                    break;

                case "Northeast":

                    break;

                case "Northwest":

                    break;

                case "Southeast":

                    break;

                case "Southwest":

                    break;

                case "Clear":

                    break;

                case "steps": {
                    boolean gotGoodInput = false;
                    int input = 0;
                    while (gotGoodInput != true) {
                        String s = (String) JOptionPane.showInputDialog( controls, "how far?",
                                "Input", JOptionPane.PLAIN_MESSAGE);
                        try {
                            input = Integer.parseInt(s);
                            gotGoodInput = true;
                        } catch (NumberFormatException ex) {
                            Utilities.error("# steps must be a non-negative integer");
                        }
                    }
                    break;
                }
                case "Save": {
                    if (fName == null)
                        fName = Utilities.getFileName((String) null, false);

                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.view);
                    os.close();
                    break;
                }
                case "SaveAs": {
                    fName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.view);
                    os.close();
                    break;
                }
                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        view = (MineField) is.readObject();
                        is.close();
                    }
                    break;
                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        view = new MineField();
                    }
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                        System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform("Cyberdellic Designs Turtle Graphics, March 4, 2023. All rights reserved. By Ronak Shankar.");
                    break;
                }

                case "Help": {
                    String[] cmmds = new String[]{
                            "North: move the head above the shell", "South: move the head below the shell",
                            "East: move the head to the right of the shell", "West: move the head to the left of the shell",
                            "Clear: erases the drawing of lines", "Pen: changes the head from filled to empty and vice versa",
                            "Color: changes color of the head", "steps: moves turtle a specified number of steps in a current direction "
                    };
                    Utilities.inform(cmmds);
                    break;
                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }
        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    class ControlPanel extends JPanel {
        public ControlPanel() {
            setLayout(new BorderLayout());
            setBackground(Color.PINK);

            JPanel p = new JPanel();
            p.setLayout(new GridLayout(4, 2));
            p.setBackground(Color.PINK);

            JButton north = new JButton("North");
            JPanel p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(north);
            p.add(p2);
            JButton south = new JButton("South");
            p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(south);
            p.add(p2);
            JButton east = new JButton("East");
            p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(east);
            p.add(p2);
            JButton west = new JButton("West");
            p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(west);
            p.add(p2);
            JButton northeast = new JButton("Northeast");
            p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(northeast);
            p.add(p2);
            JButton northwest = new JButton("Northwest");
            p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(northwest);
            p.add(p2);
            JButton southeast = new JButton("Southeast");
            p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(southeast);
            p.add(p2);
            JButton southwest = new JButton("Southwest");
            p2 = new JPanel();
            p2.setBackground(Color.PINK);
            p2.add(southwest);
            p.add(p2);
            add(p, "North");
            north.addActionListener(AppPanel.this);
            south.addActionListener(AppPanel.this);
            east.addActionListener(AppPanel.this);
            west.addActionListener(AppPanel.this);
            northeast.addActionListener(AppPanel.this);
            northwest.addActionListener(AppPanel.this);
            southeast.addActionListener(AppPanel.this);
            southwest.addActionListener(AppPanel.this);
        }
    }

    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
}

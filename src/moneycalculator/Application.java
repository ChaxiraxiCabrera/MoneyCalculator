package moneycalculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.control.Command;
import moneycalculator.control.ExchangeCommand;
import moneycalculator.model.Currency;
import moneycalculator.persitence.SQLiteCurrencyReader;
import moneycalculator.ui.SwingCurrencyDialog;
import moneycalculator.ui.SwingMoneyDialog;
import moneycalculator.ui.SwingMoneyDisplay;

public class Application extends JFrame{

    private Command command;
    private SwingMoneyDialog swingMoneyDialog;
    private SwingMoneyDisplay swingMoneyDisplay;
    private SwingCurrencyDialog swingCurrencyDialog;
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    public Application() {
        deployUI();
        createCommands();
    }

    private void deployUI() {
        this.setTitle("MoneyCalculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(components());
        this.setPreferredSize(new Dimension(300, 100));
        this.pack();
        this.setResizable(false);
    }

    private void createCommands() {
        this.command = new ExchangeCommand(swingMoneyDialog, swingCurrencyDialog, swingMoneyDisplay);
    }

    private JPanel components() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ArrayList<Currency> list = new SQLiteCurrencyReader().get();
        panel.add(fromComponents(list));
        panel.add(toComponents(list));
        return panel;
    }

    private SwingMoneyDialog fromComponents(ArrayList<Currency> list) {
        JTextField textField = new JTextField("0");
        textField.addKeyListener(doCommandOnType("Exchange"));
        this.swingMoneyDialog = new SwingMoneyDialog(textField, fromOptions(list));
        return swingMoneyDialog;
    }

    private JPanel toComponents(ArrayList<Currency> list) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        this.swingMoneyDisplay = new SwingMoneyDisplay();
        panel.add(swingMoneyDisplay);
        panel.add(toOptions(list));
        return panel;
    }

    private KeyListener doCommandOnType(String exchange) {
        return new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if(!swingMoneyDialog.getTextField().getText().equals("")){
                    command.execute();
                }else{
                    swingMoneyDisplay.getTextField().setText("");
                }
            }
        };
    }
    
    private JComboBox fromOptions(ArrayList<Currency> list) {
        JComboBox comboBox = new JComboBox();
        for (Currency currency : list) {
            comboBox.addItem(currency.getCode());
        }
        comboBox.addActionListener(doCommandOnComboBox("Exchange"));
        return comboBox;
    }

    private SwingCurrencyDialog toOptions(ArrayList<Currency> list) {
        JComboBox comboBox = new JComboBox();
        for (Currency currency : list) {
            comboBox.addItem(currency.getCode());
        }
        swingCurrencyDialog = new SwingCurrencyDialog(comboBox);
        comboBox.addActionListener(doCommandOnComboBox("Exchange"));
        return swingCurrencyDialog;
    }
    
    private ActionListener doCommandOnComboBox(String exchange) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!swingMoneyDialog.getTextField().getText().equals("")){
                    command.execute();
                }else{
                    swingMoneyDisplay.getTextField().setText("");
                }
            }
        };
    }
    
}

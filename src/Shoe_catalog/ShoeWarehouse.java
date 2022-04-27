package Shoe_catalog;

import javax.swing.*;
import java.awt.*;

public class ShoeWarehouse extends JFrame{
    ShoeWarehouse(){
        try {
            setTitle("Shoe warehouse");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLayout(new BorderLayout());

            ScorollTablePanel tablePanel = new ScorollTablePanel(this);
            add(tablePanel, BorderLayout.CENTER);
            setVisible(true);
        }catch(Exception ex){System.out.println("It`s in warehouse "+ ex);}
    }
    public static void main(String args[]) {
        new ShoeWarehouse();
    }
}

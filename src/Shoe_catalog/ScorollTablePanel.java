package Shoe_catalog;

import javax.swing.*;
import java.awt.*;

public class ScorollTablePanel extends JPanel{
    ShoeWarehouseTableModel shoeWarehouseTableModel;
    public ScorollTablePanel(JFrame owner) {
        try {
            this.setLayout(new BorderLayout());
            shoeWarehouseTableModel = new ShoeWarehouseTableModel(Shoe.getNames());
            JTable table = new JTable(shoeWarehouseTableModel);
            JScrollPane scrollTable = new JScrollPane(table);
            scrollTable.setPreferredSize(new Dimension(400,400));
            FuncPanel funcPanel = new FuncPanel(shoeWarehouseTableModel, owner);
            this.add(scrollTable, BorderLayout.CENTER);
            this.add(funcPanel, BorderLayout.SOUTH);
        }catch(Exception ex){System.out.println("It`s in scroll table panel "+ex); throw(ex);}
    }
}

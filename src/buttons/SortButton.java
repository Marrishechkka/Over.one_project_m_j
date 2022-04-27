package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Shoe_catalog.*;

import javax.swing.*;

public class SortButton implements ActionListener {
    private ShoeWarehouseTableModel shoeWarehouseTableModel;
    private JFrame owner;

    public SortButton(ShoeWarehouseTableModel newShoeWarehouseTableModel, JFrame owner){
        shoeWarehouseTableModel = newShoeWarehouseTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        shoeWarehouseTableModel.sortDataByName();
        shoeWarehouseTableModel.fireTableDataChanged();
    }
}

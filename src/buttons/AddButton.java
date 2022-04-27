package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Shoe_catalog.*;

import javax.swing.*;

public class AddButton implements ActionListener {
    private ShoeWarehouseTableModel shoeWarehouseTableModel;
    private JFrame owner;

    public AddButton(ShoeWarehouseTableModel newShoeWarehouseTableModel, JFrame owner){
        shoeWarehouseTableModel = newShoeWarehouseTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Shoe shoe = new Factory().createShoe(owner);
        if(shoe.getName().equals("")) return;
        if(!shoeWarehouseTableModel.addData(shoe)){
            JOptionPane.showMessageDialog(owner,
                    "Объект на записан. Обувь с таким именем уже существует",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        shoeWarehouseTableModel.fireTableDataChanged();
    }
}

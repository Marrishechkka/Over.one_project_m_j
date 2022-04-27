package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Shoe_catalog.*;

import javax.swing.*;

public class DelButton implements ActionListener {
    private ShoeWarehouseTableModel shoeWarehouseTableModel;
    private JFrame owner;

    public DelButton(ShoeWarehouseTableModel newShoeWarehouseTableModel, JFrame owner){
        shoeWarehouseTableModel = newShoeWarehouseTableModel;
        this.owner = owner;
    }

    public void actionPerformed(ActionEvent e){
        String name = (String)JOptionPane.showInputDialog(
                owner,
                "Введите наименование",
                "Удаление",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "Наименование");
        if(name.equals("")){
            return;
        }
        if(!shoeWarehouseTableModel.removeData(name)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        shoeWarehouseTableModel.fireTableDataChanged();
    }
}

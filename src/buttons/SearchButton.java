package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Shoe_catalog.*;

import javax.swing.*;

public class SearchButton implements ActionListener {
    private ShoeWarehouseTableModel shoeWarehouseTableModel;
    private JFrame owner;

    public SearchButton(ShoeWarehouseTableModel newShoeWarehouseTableModel, JFrame owner){
        shoeWarehouseTableModel = newShoeWarehouseTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String size = (String) JOptionPane.showInputDialog(owner, "Введите производителя", "Поиск", JOptionPane.QUESTION_MESSAGE, null, null, "Производитель");
        if(size.equals("")){
            return;
        }
        if(!shoeWarehouseTableModel.searchData(size, owner)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        shoeWarehouseTableModel.fireTableDataChanged();
    }
}

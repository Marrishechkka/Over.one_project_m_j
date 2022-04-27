package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Shoe_catalog.*;

import javax.swing.*;

public class RedactButton implements ActionListener {
    private ShoeWarehouseTableModel shoeWarehouseTableModel;
    private JFrame owner;

    public RedactButton(ShoeWarehouseTableModel newShoeWarehouseTableModel, JFrame owner){
        shoeWarehouseTableModel = newShoeWarehouseTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String)JOptionPane.showInputDialog(
                owner,
                "Введите наименование которое надо изменить",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "Наименование");
        if(name.equals("")){
            return;
        }
        String chosenField = (String)JOptionPane.showInputDialog(
                owner,
                "Выберите поле для редактирования",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Shoe.getNames(),
                "Наименование");
        if(chosenField.equals("")){
            return;
        }
        String newStr = (String)JOptionPane.showInputDialog(
                owner,
                "Введите новые данные",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "Новые данные");
        if(newStr.equals("")){
            return;
        }
        if(!shoeWarehouseTableModel.redactData(name, chosenField, newStr)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        shoeWarehouseTableModel.fireTableDataChanged();
    }
}

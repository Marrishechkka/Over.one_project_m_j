package Shoe_catalog;

import javax.swing.*;
import java.awt.*;


public class FuncPanel extends JPanel {
    private JButton addButton;
    private JButton delButton;
    private JButton redactButton;
    private JButton searchButton;
    private JButton sortButton;
    public FuncPanel(ShoeWarehouseTableModel shoeWarehouseTableModel, JFrame owner){
        setLayout(new GridLayout(1,6,50,0));
        addButton = new JButton("Добавить");
        delButton = new JButton("Удалить");
        redactButton = new JButton("Изменить");
        searchButton = new JButton("Найти записи");
        sortButton = new JButton("Отсортировать по наименованию");
        addButton.addActionListener(new buttons.AddButton(shoeWarehouseTableModel, owner));
        delButton.addActionListener(new buttons.DelButton(shoeWarehouseTableModel, owner));
        redactButton.addActionListener(new buttons.RedactButton(shoeWarehouseTableModel, owner));
        searchButton.addActionListener(new buttons.SearchButton(shoeWarehouseTableModel, owner));
        sortButton.addActionListener(new buttons.SortButton(shoeWarehouseTableModel, owner));
        this.add(addButton);
        this.add(delButton);
        this.add(redactButton);
        this.add(searchButton);
        this.add(sortButton);
    }
}

package Shoe_catalog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Factory {

    public Shoe createShoe(JFrame owner){
        Object []names = Shoe.getNames();
        JLabel labName = new JLabel(names[0].toString());
        JTextField textName = new JTextField(50);
        JLabel labType = new JLabel(names[1].toString());
        JTextField textType = new JTextField(50);
        JLabel labColor = new JLabel(names[2].toString());
        JTextField textColor = new JTextField(50);
        JLabel labSize = new JLabel(names[3].toString());
        JTextField textSize = new JTextField(50);
        JLabel labMaterial = new JLabel(names[4].toString());
        JTextField textMaterial = new JTextField(50);
        JLabel labManufacturer = new JLabel(names[5].toString());
        JTextField textManufacturer = new JTextField(50);
        JButton completeButton = new JButton("Добавить");
        JLabel labRes =  new JLabel ("Впишите данные");

        Shoe mainShoe = new Shoe();

        JDialog dialog = new JDialog(owner,"Окно добавления записи" , Dialog.ModalityType.DOCUMENT_MODAL);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(500, 350);
        dialog.setLayout(new GridLayout(8,2,11,7));
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textName.getText().equals("")||textType.getText().equals("")||textColor.getText().equals("")||textSize.getText().equals("")||textMaterial.getText().equals("")||textManufacturer.getText().equals("")){
                    labRes.setText("Необходимо ввести все данные!");
                }
                else{
                    mainShoe.setName(textName.getText());
                    mainShoe.setType(textType.getText());
                    mainShoe.setColor(textColor.getText());
                    mainShoe.setSize(Double.parseDouble(textSize.getText()));
                    mainShoe.setMaterial(textMaterial.getText());
                    mainShoe.setManufacturer(textManufacturer.getText());
                    dialog.dispose();
                }
            }
        });
        dialog.add(labName);
        dialog.add(textName);
        dialog.add(labType);
        dialog.add(textType);
        dialog.add(labColor);
        dialog.add(textColor);
        dialog.add(labSize);
        dialog.add(textSize);
        dialog.add(labMaterial);
        dialog.add(textMaterial);
        dialog.add(labManufacturer);
        dialog.add(textManufacturer);
        dialog.add(labRes);
        dialog.add(completeButton);
        dialog.setVisible(true);
        return mainShoe;
    }
}

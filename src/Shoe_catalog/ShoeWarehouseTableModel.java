package Shoe_catalog;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class ShoeWarehouseTableModel extends AbstractTableModel {

    private int colls;
    private ArrayList<Shoe> arrayList;
    private Object[] collNames;

    public ShoeWarehouseTableModel(Object []newCollNames){
        colls = newCollNames.length;
        arrayList = new ArrayList<>();
        collNames = newCollNames.clone();
    }

    @Override
    public int getRowCount() {
        return arrayList.size();
    }

    @Override
    public int getColumnCount() {
        return collNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return arrayList.get(rowIndex).getSomeInfo(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex){
        return String.valueOf(collNames[columnIndex]);
    }

    public boolean addData(Shoe newData){
        int i=0;
        Shoe shoe;
        ListIterator<Shoe> iterator = arrayList.listIterator();
        while(iterator.hasNext()){
            shoe = (Shoe) iterator.next();
            if(newData.getName().equals(shoe.getName()))
                return false;
        }
        iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            shoe = (Shoe) iterator.next();
            if(newData.getName().compareTo(shoe.getName())<0)
                break;
        }
        arrayList.add(i, newData);
        return true;
    }

    public boolean removeData(String nameToDel){
        int i=0;
        Shoe shoe;
        boolean chekFound=false;
        ListIterator<Shoe> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            shoe = (Shoe) iterator.next();
            if(nameToDel.equals(shoe.getName())) {
                chekFound = true;
                break;
            }
        }
        if(!chekFound){
            return false;
        }
        arrayList.remove(i);
        return true;
    }

    public boolean redactData(String nameToRedact, String chosenField, String newStr){
        int i=0;
        Shoe shoe;
        boolean chekFound=false;
        ListIterator<Shoe> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            shoe = (Shoe) iterator.next();
            if(nameToRedact.equals(shoe.getName())) {
                chekFound = true;
                break;
            }
        }
        if(!chekFound){
            return false;
        }
        shoe = arrayList.get(i);
        switch (chosenField){
            case "Наименование": shoe.setName(newStr);
                break;
            case "Вид обуви":   shoe.setType(newStr);
                break;
            case "Цвет": shoe.setColor(newStr);
                break;
            case  "Размер": shoe.setSize(Double.parseDouble(newStr));
                break;
            case  "Материал":  shoe.setMaterial(newStr);
                break;
            case  "Производитель": shoe.setManufacturer(newStr);
                break;
            default: break;
        }
        arrayList.set(i, shoe);
        return true;
    }

    public boolean searchData(String manufacturer, JFrame owner){
        int i=0;
        Shoe shoe;
        boolean chekFound=false;
        ListIterator<Shoe> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            shoe = (Shoe) iterator.next();
            Shoe row = arrayList.get(i);
            String currBrand = row.getManufacturer();

            if(currBrand.equals(manufacturer)) {
                chekFound = true;
                JOptionPane.showMessageDialog(owner,
                        shoe.toString(),
                        "Вывод найденных записей",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        return chekFound;
    }


    public void sortDataByName(){
        Collections.reverse(arrayList);
    }
}

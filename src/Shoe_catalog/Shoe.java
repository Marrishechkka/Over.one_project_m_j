package Shoe_catalog;

public class Shoe implements Comparable<Shoe>{
    private String name;
    private String type;
    private String color;
    private Double size;
    private String material;
    private String manufacturer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public static Object[] getNames(){
        return new Object[]{"Наименование", "Вид обуви", "Цвет", "Размер", "Материал", "Производитель"};
    }


    public String getSomeInfo(int indexOfField){
        switch(indexOfField){
            case 0: return name;
            case 1: return type;
            case 2: return color;
            case 3: return String.valueOf(size);
            case 4: return material;
            case 5: return manufacturer;
            default: return "error(no field)";
        }
    }

    public String toString(){
        return "Наименование: "+name+" \nВид обуви: "+ type +"\nЦвет: "+ color +"\nРазмер: "+ size +"\nМатериал: "+ material+"\nПроизводитель: "+ manufacturer;
    }

    @Override
    public int compareTo(Shoe shoe) {
        if(shoe.name.compareTo(this.name)>0)
            return 1;
        if(shoe.name.compareTo(this.name)<0)
            return -1;
        return 0;
    }
}


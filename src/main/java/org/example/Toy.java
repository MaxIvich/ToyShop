package org.example;

public class Toy {
    int id;
    String name;
    int quantity;
    double weight;


    public void setId(int id) {
        if( id > 0 )
        {
            this.id = id;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 0)
        {
            this.quantity = quantity;
        }

    }

    public Toy(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        if(weight <= 100 && weight >= 1){
            this.weight = weight;
        }else System.out.println("Вес не может быть больше 100 и меньше 1 ");

    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", weight=" + weight +
                '}';
    }

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }
}

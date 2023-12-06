package org.example;

import java.net.Socket;
import java.util.*;

public class functions {

    private double total = 0;

    ArrayList<String> toyList = new ArrayList<>();
    NavigableMap <Double, Toy> treemap = new TreeMap<>();


    public void createToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        treemap.put(weight,toy);
        total += weight;

    }







    public void getWinner(){
        Random random = new Random();
        double value = random.nextDouble() * total;
        System.out.println(total);
        System.out.println(value);

        if(treemap.ceilingKey(value)==null) {
            if(treemap.floorEntry(value).getValue().getQuantity()>0){
                System.out.println(treemap.floorEntry(value).getValue().toString());
                treemap.floorEntry(value).getValue().setQuantity(treemap.floorEntry(value).getValue().getQuantity()-1);
                toyList.add(treemap.floorEntry(value).getValue().name);
                //System.out.println("Осталось   " + treemap.floorEntry(value).getValue().getQuantity());
                howMuch();
                userContinue();
            }else {
                System.out.println(treemap.floorEntry(value).getValue().getName() + "  Закончились ");
                treemap.remove(treemap.floorEntry(value).getKey());

                userContinue();
            }
        }
        else {
            if(treemap.ceilingEntry(value).getValue().getQuantity()>0){
                System.out.println(treemap.ceilingEntry(value).getValue().toString());
                treemap.ceilingEntry(value).getValue().setQuantity(treemap.ceilingEntry(value).getValue().getQuantity()-1);
                toyList.add(treemap.ceilingEntry(value).getValue().name);
                //System.out.println("Осталось   " + treemap.ceilingEntry(value).getValue().getQuantity());
                howMuch();
                userContinue();
            }else {
                System.out.println(treemap.ceilingEntry(value).getValue().getName() + "  Закончились ");
                treemap.remove(treemap.ceilingEntry(value).getKey());
                userContinue();
            }


        }



    }
    public void userContinue(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        if(treemap.size()==0){
            System.out.println(" вса подарки закончились ");
            System.out.println(toyList.toString());

        }else {
            getWinner();

        }

    }
    public void howMuch(){
        for (Toy key :treemap.values()){
            System.out.println(key.getName()+ " - "+ key.getQuantity());
        }
    }

    public void setWeight(int id, double weight){
        for (Toy toy :treemap.values()){
            if(toy.getId()==id){
                toy.setWeight(weight);
            }
        }

    }
}

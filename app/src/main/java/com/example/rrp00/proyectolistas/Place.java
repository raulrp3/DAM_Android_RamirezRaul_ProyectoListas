package com.example.rrp00.proyectolistas;

public class Place {
    private String mName;

    public Place(String name){
        mName = name;
    }

    public String getName(){ return  mName;}
    public void setName(String name){ mName = name;}

    @Override
    public String toString(){
        return "Place{ nombre: " + mName + "}";
    }
}

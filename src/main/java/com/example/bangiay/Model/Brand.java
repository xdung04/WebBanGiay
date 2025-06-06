/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bangiay.Model;

/**
 *
 * @author ADMIN
 */
public class Brand {

    private int id;
    private String name;
    private int count;
    
    public Brand() {
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", name=" + name + '}';
    }

}

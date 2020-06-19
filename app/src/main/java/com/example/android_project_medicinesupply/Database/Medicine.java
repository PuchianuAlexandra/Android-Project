package com.example.android_project_medicinesupply.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Medicine {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "manufacturer")
    private String manufacturer;
    @ColumnInfo(name = "noPills")
    private int noPills;
    @ColumnInfo(name = "concentration")
    private int concentration;
    @ColumnInfo(name = "quantity")
    private int quantity;
    @ColumnInfo(name = "price")
    private double price;

    public Medicine(int id, String name, String manufacturer, int noPills, int concentration, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.noPills = noPills;
        this.concentration = concentration;
        this.quantity = quantity;
        this.price = price;
    }

    public Medicine() {
        this.id = 0;
        this.name = "";
        this.manufacturer = "";
        this.noPills = 0;
        this.concentration = 0;
        this.quantity = 0;
        this.price = 0.0;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getNoPills() {
        return noPills;
    }

    public void setNoPills(int noPills) {
        this.noPills = noPills;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

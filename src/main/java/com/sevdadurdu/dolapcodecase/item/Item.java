package com.sevdadurdu.dolapcodecase.item;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "items")
public class Item {
    @Id
    private ObjectId _id;
    private String name;
    private String category;
    private double price;
    private int order;

    public Item(ObjectId _id, String name, String category, double price, int order) {
        this._id = _id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.order = order;
    }

    public Item() {
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

package com.sevdadurdu.dolapcodecase.category;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "categories")
public class Category {

    @Id
    private ObjectId _id;
    private String name;
    private int order;

    public Category(ObjectId _id, String name, int order) {
        this._id = _id;
        this.name = name;
        this.order = order;
    }

    public Category() {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

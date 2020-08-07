package com.sevdadurdu.dolapcodecase.item;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface ItemRepository extends MongoRepository<Item, ObjectId> {
    Optional<Item> findById(ObjectId _id);

    List<Item> findAllByCategory(ObjectId category);

    void deleteById(ObjectId _id);
}

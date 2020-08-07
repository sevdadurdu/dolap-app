package com.sevdadurdu.dolapcodecase.category;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
    Optional<Category> findById(ObjectId _id);
}
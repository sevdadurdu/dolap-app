package com.sevdadurdu.dolapcodecase.item;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> getById(ObjectId _id) {
        return itemRepository.findById(_id);
    }

    public List<Item> getByCategory(ObjectId category) {
        return itemRepository.findAllByCategory(category);
    }

    public void deleteItemById(ObjectId _id) {
        itemRepository.deleteById(_id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Item item, ObjectId _id) throws Exception {
        Item foundItem = itemRepository.findById(_id).orElseThrow(() -> new Exception("Item not found."));
        Item toModified = new Item();
        toModified.set_id(_id);
        toModified.setCategory(foundItem.getCategory());
        toModified.setPrice(foundItem.getPrice());
        toModified.setName(foundItem.getName());
        toModified.setOrder(foundItem.getOrder());

        if (item.getName() != null) {
            toModified.setName(item.getName());
        }
        if (item.getOrder() != 0) {
            toModified.setOrder(item.getOrder());
        }
        if (item.getPrice() != 0) {
            toModified.setPrice(item.getPrice());
        }

        return itemRepository.save(toModified);
    }

}
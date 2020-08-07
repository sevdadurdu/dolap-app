package com.sevdadurdu.dolapcodecase.item;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public
class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    List<Item> all() {
        return itemService.findAll();
    }

    @GetMapping("/items/{id}")
    Optional<Item> one(@PathVariable("id") ObjectId _id) {
        return itemService.getById(_id);
    }

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable("id") ObjectId _id) {
        itemService.deleteItemById(_id);
    }

    @PostMapping
    Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PatchMapping("/items/{id}")
    Item updateItem(@RequestBody Item item, @PathVariable("id") ObjectId _id) throws Exception {
        return itemService.updateItem(item, _id);
    }
}

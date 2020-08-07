package com.sevdadurdu.dolapcodecase.category;

import com.sevdadurdu.dolapcodecase.item.Item;
import com.sevdadurdu.dolapcodecase.item.ItemService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/categories")
    List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    Optional<Category> getCategory(@PathVariable("id") ObjectId _id) {
        return categoryService.findById(_id);
    }

    @GetMapping("/categories/{id}/items")
    List<Item> getItemsByCategory(@PathVariable("id") ObjectId _id) {
        return itemService.getByCategory(_id);
    }
}

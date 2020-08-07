package com.sevdadurdu.dolapcodecase.service;

import com.sevdadurdu.dolapcodecase.category.Category;
import com.sevdadurdu.dolapcodecase.category.CategoryRepository;
import com.sevdadurdu.dolapcodecase.category.CategoryService;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void atGetByIdWhenGivenValidId_ExpectedValidValue() {
        ObjectId _id = ObjectId.get();
        Category category = new Category(_id, "test", 1);
        given(categoryRepository.findById(_id)).willReturn(Optional.of(category));
        final Optional<Category> expected = categoryService.findById(_id);
        assertNotNull(expected);
    }

    @Test
    public void shouldReturnFindAll() {
        List<Category> categoryList = Arrays.asList(
                new Category(ObjectId.get(), "giyim", 2),
                new Category(ObjectId.get(), "canta", 3));

        given(categoryRepository.findAll()).willReturn(categoryList);

        List<Category> expected = categoryService.findAll();
        assertEquals(expected, categoryList);
    }
}

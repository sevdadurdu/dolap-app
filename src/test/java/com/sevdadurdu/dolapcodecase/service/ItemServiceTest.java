package com.sevdadurdu.dolapcodecase.service;

import com.sevdadurdu.dolapcodecase.item.Item;
import com.sevdadurdu.dolapcodecase.item.ItemRepository;
import com.sevdadurdu.dolapcodecase.item.ItemService;
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
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void atGetByIdWhenGivenValidId_ExpectedValidValue() {
        ObjectId _id = ObjectId.get();
        Item item = new Item(_id, "cuzdan", "5f2d074492f4ab988816c1ef", 67, 4);
        given(itemRepository.findById(_id)).willReturn(Optional.of(item));
        final Optional<Item> expected = itemService.getById(_id);
        assertNotNull(expected);
    }

    @Test
    public void atDeleteByIdGivenValidId() {
        ObjectId _id = ObjectId.get();
        itemService.deleteItemById(_id);
        verify(itemRepository).deleteById(_id);
    }

   /* @Test
    public void atUpdateItemByIdGivenValidId() throws Exception {
        ObjectId _id = ObjectId.get();
        Item item = new Item(_id, "cuzdan", "5f2d074492f4ab988816c1ef", 67, 4);
        given(itemRepository.findById(_id)).willReturn(Optional.of(item));
        given(itemRepository.save(item)).willReturn(item);
        final Item expected = itemService.updateItem(item, _id);
        assertNotNull(expected);
        verify(itemRepository).save(expected);
    } */

    @Test
    public void shouldReturnFindAll() {
        List<Item> itemList = Arrays.asList(
                new Item(ObjectId.get(), "cuzdan", "5f2d074492f4ab988816c1ef", 67, 4),
                new Item(ObjectId.get(), "sirt cantasi", "5f2d074492f4ab988816c1ef", 67, 3));

        given(itemRepository.findAll()).willReturn(itemList);

        List<Item> expected = itemService.findAll();
        assertEquals(expected, itemList);
    }
}

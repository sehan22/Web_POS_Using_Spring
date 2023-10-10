package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    public ArrayList<ItemDTO> getAllItems();

    public void saveItem(ItemDTO itemDTO);

    public void updateItem(ItemDTO itemDTO);

    public void deleteItem(String code, ItemDTO itemDTO);
}

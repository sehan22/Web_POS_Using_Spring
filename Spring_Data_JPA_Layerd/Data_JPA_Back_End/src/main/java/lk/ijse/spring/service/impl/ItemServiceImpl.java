package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        return modelMapper.map(itemRepo.findAll(), new TypeToken<ArrayList<ItemDTO>>() {
        }.getType());
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())) {
            throw new RuntimeException("Add : Wrong Item ID.Please Enter Correct ID..!");
        }

        Item item = modelMapper.map(itemDTO, Item.class);
        itemRepo.save(item);
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (!itemRepo.existsById(itemDTO.getCode())) {
            throw new RuntimeException("Update : Wrong Item ID.Please Enter Correct ID..!");
        }
        Item item = modelMapper.map(itemDTO, Item.class);
        itemRepo.save(item);
    }

    @Override
    public void deleteItem(String code, ItemDTO itemDTO) {
        if (!itemRepo.existsById(itemDTO.getCode())) {
            throw new RuntimeException("Update : Wrong Item ID.Please Enter Correct ID..!");
        }
        itemRepo.deleteById(code);
    }
}

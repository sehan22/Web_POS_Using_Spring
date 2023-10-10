package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemCRUDController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseUtil getAllItems() {
        return new ResponseUtil("OK", "Items Load Successfully..!", itemService.getAllItems());
    }

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
        return new ResponseUtil("OK", "Item Save Successfully..!", itemDTO);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
        return new ResponseUtil("OK", "Item Update Successfully..!", itemDTO);
    }

    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteItem(@RequestParam String code, ItemDTO itemDTO) {
        itemService.deleteItem(code, itemDTO);
        return new ResponseUtil("OK", "Item Delete Successfully..!", code);
    }
}

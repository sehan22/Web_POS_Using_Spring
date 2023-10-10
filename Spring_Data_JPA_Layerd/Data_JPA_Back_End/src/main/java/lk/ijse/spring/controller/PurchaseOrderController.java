package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController() {
        System.out.println("PurchaseOrderController : Instantiated..!");
    }

    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO ordersDTO) {
        purchaseOrderService.purchaseOrder(ordersDTO);
        return new ResponseUtil("OK", "Successfully Purchased..!", ordersDTO);
    }
}

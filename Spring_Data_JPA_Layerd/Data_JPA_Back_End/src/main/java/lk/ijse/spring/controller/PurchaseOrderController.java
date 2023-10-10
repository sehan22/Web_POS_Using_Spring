package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private ModelMapper modelMapper;

    public PurchaseOrderController() {
        System.out.println("PurchaseOrderController : Instantiated..!");
    }

    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO ordersDTO) {
        Orders customer = modelMapper.map(ordersDTO, Orders.class);
        ordersRepo.save(customer);
        return new ResponseUtil();
    }
}

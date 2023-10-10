package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    OrdersRepo ordersRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ItemRepo itemRepo;

    @Override
    public void purchaseOrder(OrdersDTO ordersDTO) {
        if (ordersRepo.existsById(ordersDTO.getOid())) {
            throw new RuntimeException("Purchase Order : Wrong Order ID.Please Enter Correct ID..!");
        }

        Orders customer = modelMapper.map(ordersDTO, Orders.class);
        ordersRepo.save(customer);

        for (OrderDetailsDTO orderDetail : ordersDTO.getOrderDetails()) {
            Item item = itemRepo.findById(orderDetail.getItemCode()).get();
            item.setQty(item.getQty()-orderDetail.getQty());
            itemRepo.save(item);
        }
    }
}

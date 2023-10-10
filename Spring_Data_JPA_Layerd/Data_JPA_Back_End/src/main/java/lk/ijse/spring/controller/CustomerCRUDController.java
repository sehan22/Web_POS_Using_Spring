package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin

public class CustomerCRUDController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil("OK", "Customers Load Successfully..!", customerService.getAllCustomers());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Customer Save Successfully..!", customerDTO);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil("OK", "Customer Update Successfully..!", customerDTO);
    }

    @DeleteMapping(params = {"cusID"})
    public ResponseUtil deleteCustomer(@RequestParam String cusID, CustomerDTO customerDTO) {
        customerService.deleteCustomer(cusID, customerDTO);
        return new ResponseUtil("OK", "Customer Delete Successfully..!", cusID);
    }
}

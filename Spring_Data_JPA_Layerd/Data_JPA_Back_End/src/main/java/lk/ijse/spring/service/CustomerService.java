package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public ArrayList<CustomerDTO> getAllCustomers();
    public void saveCustomer(CustomerDTO customerDTO);
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String cusID,CustomerDTO customerDTO);
}


package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return modelMapper.map(customerRepo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Add : Wrong Customer ID.Please Enter Correct ID..!");
        }
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Update : Wrong Customer ID.Please Enter Correct ID..!");
        }
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);

    }

    @Override
    public void deleteCustomer(String cusID, CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Delete : Wrong Customer ID.Please Enter Correct ID..!");
        }
        // 1st method
        customerRepo.deleteById(cusID);
    }
}

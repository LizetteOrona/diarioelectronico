package com.lilith.diarioelectronico.dao;

import com.lilith.diarioelectronico.model.Customer;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getAllCustomers();

    public Boolean insertNewCustomer (Customer customer);

    public Boolean deleteCustomer(int id);

    public Boolean updateCustomer(Customer customer);
}

package com.lilith.diarioelectronico.controller;

import com.lilith.diarioelectronico.dao.CustomerDao;
import com.lilith.diarioelectronico.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/findall")
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customer", customerDao.getAllCustomers());
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    /*
    @RequestMapping(value = "/insertcustomer")
    public Customer addCustomer(Customer customer){
        customerDao.insertNewCustomer(customer);
        return customer;
    }
    */
    @RequestMapping(value = "/insertcustomer")
    public String addCustomer(){
        Customer customer = new Customer();
        customer.setFirstname("Pepe");
        customer.setLastname("Perez");
        customerDao.insertNewCustomer(customer);
        return "/findall";
    }

    /*
    @RequestMapping(value = "/deletecustomer")
    public Customer deleteCustomer(Customer customer){
        customerDao.deleteCustomer(customer);
        return customer;
    }
    */
    @RequestMapping(value = "/deletecustomer")
    public String deleteCustomer(){
        customerDao.deleteCustomer(25);
        return "/findall";
    }

    /*
    @RequestMapping(value = "/updatecustomer")
    public Customer updateCustomer(Customer customer){
        customerDao.updateCustomer(customer);
        return customer;
    }
    */
    @RequestMapping(value = "/updatecustomer")
    public String updateCustomer(){
        Customer customer = new Customer();
        customer.setId(22);
        customer.setFirstname("Lola");
        customer.setLastname("Gamez");
        customerDao.updateCustomer(customer);
        return "/findall";
    }

}

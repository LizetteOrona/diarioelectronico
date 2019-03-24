package com.lilith.diarioelectronico.dao.impl;

import com.lilith.diarioelectronico.dao.CustomerDao;
import com.lilith.diarioelectronico.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("SELECT * FROM customer", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                return customer;
            }
        });
    }

    /*
    public void insertNewCustomer(Customer customer){
        int insert = jdbcTemplate.update("INSERT INTO customer( firstname, lastname) VALUES ( ?, ?)", new Object[]{customer.getFirstname(), customer.getLastname()});
    }
     */
    @Override
    public Boolean insertNewCustomer(Customer customer) {
        int insert = jdbcTemplate.update("INSERT INTO customer( firstname, lastname) VALUES ( ?, ?)", new Object[]{customer.getFirstname(), customer.getLastname()});
        if(insert > 0 ) return true;
        return false;
    }


    /*
    public void deleteCustomer(Customer customer){
        int insert = jdbcTemplate.update("DELETE FROM customer WHERE id = ?", customer.getId());
    }
    */
    @Override
    public Boolean deleteCustomer(int id) {
        int delete = jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
        if(delete > 0 ) return true;
        return false;
    }

    /*
   public void updateCustomer(Customer customer){
       int insert = jdbcTemplate.update("DELETE FROM customer WHERE id = ?", new Object[]{customer.getId()});
   }
   */
    @Override
    public Boolean updateCustomer(Customer customer) {
        int update = jdbcTemplate.update("UPDATE customer SET firstname = ?, lastname = ? WHERE id = ?", customer.getFirstname(), customer.getLastname(), customer.getId());
        if(update > 0 ) return true;
        return false;
    }


}

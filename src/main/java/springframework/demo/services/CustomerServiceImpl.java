package springframework.demo.services;

import springframework.demo.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{
    private Map<Integer, Customer> customers;

    public CustomerServiceImpl(){
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers(){
        return new ArrayList<>(customers.values());
    }
    @Override
    public Customer getCustomerById(Integer id){
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer){
        if (customer != null){
            if (customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Product Can't be nill");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }


    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers(){
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Nafisa");
        customer1.setLastName("Tojiboyeva");
        customer1.setEmail("nafisa.tojiboyeva1999@gmail.com");
        customer1.setPhoneNumber("+998998245650");
        customer1.setCity("Tashkent");
        customer1.setState("Uzbekistan");
        customer1.setZipCode("100000");

        customers.put(1,customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Munisa");
        customer2.setLastName("Tojiboyeva");
        customer2.setEmail("munisa.tojiboyeva1999@gmail.com");
        customer2.setPhoneNumber("+998998245650");
        customer2.setCity("Tashkent");
        customer2.setState("Uzbekistan");
        customer2.setZipCode("100000");

        customers.put(2,customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Lola");
        customer3.setLastName("Tojiboyeva");
        customer3.setEmail("Lola.tojiboyeva1999@gmail.com");
        customer3.setPhoneNumber("+998998245650");
        customer3.setCity("Tashkent");
        customer3.setState("Uzbekistan");
        customer3.setZipCode("100000");

        customers.put(3,customer3);
    }
}

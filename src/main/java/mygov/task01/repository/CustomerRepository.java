package mygov.task01.repository;

import org.springframework.stereotype.Repository;
import mygov.task01.Customer;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {
    private final ConcurrentHashMap<Long, Customer> customers = new ConcurrentHashMap<>();

    public Collection<Customer> findAll() {
        return customers.values();
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    public Customer save(Customer customer) {
        customers.put(customer.id(), customer);
        return customer;
    }
}

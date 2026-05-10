package ma.enset.digitalbankingbackend.repositories;

import ma.enset.digitalbankingbackend.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    Page<Customer> findByNameContains(
            String keyword,
            Pageable pageable
    );
}
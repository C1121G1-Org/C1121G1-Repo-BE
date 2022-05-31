package api.repositories;

import api.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where customer_name like concat('%', :name ,'%')" +
            " and phone_number like concat('%', :phone,'%')"
            , nativeQuery = true)
    Page<Customer> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("phone") String keyWord2);
}

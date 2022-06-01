package api.repositories;

import api.models.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into invoice (create_date, create_time ,payments, customer_id) value (?1,?2,?3,?4);", nativeQuery = true)
    void saveInvoice(String createDate, String createTime, String payments, Long customerId);


    @Query(value = "select * from  invocie " +
            "inner join customer on invocie.id = customer.id " +
            "inner join product on invocie.id = product.id " +
            "where (create_time like concat('%',:keyword,'%') " +
            "or  create_date like concat('%',:keyword,'%')  " +
            "or  total_money like concat('%',:keyword,'%')  " +
            "or  customer_id like concat('%',:keyword,'%')  " +
            "or  product_id like concat('%',:keyword,'%')) and flag = 1 " +
            "order by case when :sorts = 'sortDateAsc' then create_date end desc ," +
            "case when :sorts = 'sortCustomerAsc' then customer_id end desc ," +
            "case when :sorts = 'sortProductAsc' then product_id end desc ," +
            "case when :sorts = 'sortTotalMoneyAsc' then total_money end desc"
            , nativeQuery = true)
    Page<Invoice> findAllByKeyWord(@Param("keyword") String keyword, Pageable pageable , @Param("sorts") String sort);

//    @Query(value = "select * from land_information join direction on direction.id = land_information.direction_id " +
//            "where price like concat('%', :prices ,'%')" +
//            " and area like concat('%', :areas ,'%')" +
//            " and direction.`name` like concat('%', :directions ,'%')" +
//            " order by case when :sorts = 'sortDateAsc' then start_date end asc , " +
//            "case when :sorts = 'sortDateDesc' then start_date end desc ," +
//            "case when :sorts ='sortPriceAsc'then price end asc , " +
//            "case when :sorts ='sortPriceDesc' then price end desc ",
//            countQuery = "select count(*) from land_information" +
//                    " join direction on direction.id = land_information.direction_id " +
//                    "where price like concat('%', :prices ,'%')" +
//                    "and area like concat('%', :areas ,'%') " +
//                    "and direction.`name` like concat('%', :directions ,'%') " +
//                    "order by case when :sorts = 'sortDateAsc' then start_date end asc , " +
//                    "case when :sorts = 'sortDateDesc' then start_date end desc," +
//                    "case when :sorts ='sortPriceAsc'then price end asc ," +
//                    "case when :sorts ='sortPriceDesc' then price end desc ", nativeQuery = true)
//    Page<LandInformation> pageFindAll(Pageable pageable, @Param("prices") String keyWord1, @Param("areas") String keyWord2, @Param("directions") String keyWord3, @Param("sorts") String sort);
}


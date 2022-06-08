package api.repositories;

import api.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
//    Create by chienLV
//    Time: 7h00 07/06/2022
//    Function: get list category from database
    @Query(value = "select id, category_name, category_image from category;", nativeQuery = true)
    List<Category> findListCategory();
}

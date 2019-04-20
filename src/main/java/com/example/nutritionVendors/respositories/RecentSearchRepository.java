package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.entities.RecentSearch;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecentSearchRepository extends JpaRepository<RecentSearch, Integer> {

//    @SQLUpdate(sql = "insert into recent_search(entity_id, user_id, is_shop) values( ?1, ?2, ?3)")
//    RecentSearch saveOne(Integer entity_id, Integer user_id, Integer is_shop);

    @Query(value = "select * from recent_search where user_id = ?1 order by update_date desc limit ?2, ?3", nativeQuery = true)
    List<RecentSearch> findAllByUserId(Integer user_id, Integer offset, Integer limit);
}

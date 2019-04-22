package com.example.nutritionVendors.respositories;

import com.example.nutritionVendors.EntitiesDTO.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDTORepository extends JpaRepository<CommentDTO, Integer> {

    @Query(value = "SELECT comment.*, shopitem.id as entity_id, item.name as entity_name, '' as entity_avatar" +
            " FROM comment " +
            " left join shopitem on comment.shopitem_id = shopitem.id" +
            " left join item on shopitem.item_id = item.id" +
            " where user_id = ?1 order by comment.update_date desc limit ?2, ?3", nativeQuery = true)
    List<CommentDTO> findAllDTOByUser(Integer user_id, Integer offset, Integer limit);
}

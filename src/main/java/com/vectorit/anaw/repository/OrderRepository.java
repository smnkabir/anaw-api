package com.vectorit.anaw.repository;

import com.vectorit.anaw.model.DBOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<DBOrder,Long> {
    List<DBOrder> findByStatus(int status);
    List<DBOrder> findByUserName(String userName);
    Optional<DBOrder> findById(Long id);
}

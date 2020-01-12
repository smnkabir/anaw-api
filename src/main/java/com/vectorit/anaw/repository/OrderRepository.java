package com.vectorit.anaw.repository;

import com.vectorit.anaw.model.DBOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<DBOrder,Long> {

}

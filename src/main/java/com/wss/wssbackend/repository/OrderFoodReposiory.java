package com.wss.wssbackend.repository;

import com.wss.wssbackend.model.orderFood;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderFoodReposiory extends CrudRepository<orderFood, Integer> {


    List<orderFood> findByEmployeeId(String employeeId);

}

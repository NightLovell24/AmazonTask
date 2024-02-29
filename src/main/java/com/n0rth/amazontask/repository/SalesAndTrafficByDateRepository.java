package com.n0rth.amazontask.repository;

import com.n0rth.amazontask.model.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesAndTrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {
    SalesAndTrafficByDate findByDate(String date);


    @Query("{ 'date' : { $gte: ?0, $lte: ?1 } }")
    List<SalesAndTrafficByDate> findByDateDateBetween(String start, String end);;



}

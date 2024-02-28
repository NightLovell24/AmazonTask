package com.n0rth.amazontask.repository;

import com.n0rth.amazontask.model.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAndTrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {
}

package com.n0rth.amazontask.repository;

import com.n0rth.amazontask.model.SalesAndTrafficByAsin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAndTrafficByAsinRepository extends MongoRepository<SalesAndTrafficByAsin, String> {
}

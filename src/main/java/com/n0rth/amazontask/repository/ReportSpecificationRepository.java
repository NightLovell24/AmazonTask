package com.n0rth.amazontask.repository;

import com.n0rth.amazontask.model.ReportSpecification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportSpecificationRepository extends MongoRepository<ReportSpecification, String> {
}

package com.metlife.hackathon.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RiskRepository extends MongoRepository<RiskRecord, String> {
}

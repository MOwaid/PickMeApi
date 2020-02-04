package com.pickme.webapi.repo.mongo;

import com.pickme.webapi.document.HttpUserSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpUserSessionRepository  extends MongoRepository<HttpUserSession, String> {
    HttpUserSession findByToken(String token);
    HttpUserSession findByTokenAndUserId(String token,String userId);

}

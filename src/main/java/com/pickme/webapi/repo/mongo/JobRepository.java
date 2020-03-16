package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Job;
import com.pickme.webapi.repo.mongo.custom.JobCustomRepository;

public interface JobRepository extends MongoRepository<Job, String>,JobCustomRepository {
	public List<Job> findByStartTime(String startTime);
	public List<Job> findByEndTime(String endTime);
	public List<Job> findByMaxJobsAllowed(String maxAllowedJobs);
	public List<Job> findByCreatedBy(String createdBy);
	public List<Job> findByUpdatedBy(String updatedBy);
	public List<Job> findByDeleted(boolean deleted);
	Page<Job> findByDeleted(boolean deleted, Pageable pageable);

}

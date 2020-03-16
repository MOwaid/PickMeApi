package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Job;
import com.pickme.webapi.repo.mongo.JobRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class JobService {

	@Autowired JobRepository jobRepo;
	@Autowired LogRepository logRepo;
	public List<Job> getAllJobs() {
		List<Job> jobs = jobRepo.findByDeleted(false); 
		return jobs;
	}
	
	public Job getJobById(String id) {
		Optional<Job> job = jobRepo.findById(id);
		return job.get();
	}
	public List<Job> getJobByStartTime(String startTime) {
		List<Job> jobs = jobRepo.findByStartTime(startTime);
		return jobs;
	}
	public List<Job> getJobByEndTime(String endTime) {
		List<Job> jobs = jobRepo.findByEndTime(endTime);
		return jobs;
	}
	public List<Job> getJobByMaxAllowedJobs(String maxAllowedJobs) {
		List<Job> jobs = jobRepo.findByMaxJobsAllowed(maxAllowedJobs);
		return jobs;
	}
	public List<Job>  getJobByCreatedBy(String createdBy) {
		List<Job> jobs=  jobRepo.findByCreatedBy(createdBy);
		return jobs;
	}
	public List<Job>  getJobByUpdatedBy(String updatedBy) {
		List<Job> jobs=  jobRepo.findByUpdatedBy(updatedBy);
		return jobs;
	}

	public Job updateJob(Job job) {
		Job newJob = jobRepo.save(job);
		return newJob;
	}
	public boolean deleteJob(String id) {
		return jobRepo.deleteJob(id);
	}
}

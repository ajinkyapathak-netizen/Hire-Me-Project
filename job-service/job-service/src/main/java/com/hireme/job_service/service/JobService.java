package com.hireme.job_service.service;

import com.hireme.job_service.dto.JobDTO;
import org.springframework.data.domain.Page;



public interface JobService {

    JobDTO createJob(JobDTO jobDTO);
    Page<JobDTO> getAllJobs(int page, int size, String sortBy,  String direction);
    JobDTO getJobById(Long id);
    JobDTO updateJob(Long id,JobDTO jobDTO);
    void deleteJobById(Long id);
    Page<JobDTO> searchJobs(String keyword, int page, int size);
}

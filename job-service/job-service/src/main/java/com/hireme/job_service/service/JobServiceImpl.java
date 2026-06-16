package com.hireme.job_service.service;

import com.hireme.job_service.dto.JobDTO;
import com.hireme.job_service.entity.Job;
import com.hireme.job_service.exception.JobNotFoundException;
import com.hireme.job_service.mapper.JobMapper;
import com.hireme.job_service.repository.JobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobDTO createJob(JobDTO jobDTO) {
        Job job = JobMapper.mapToEntity(jobDTO);
        Job saved =  jobRepository.save(job);
        return JobMapper.mapToDTO(saved);
    }

    @Override
    public Page<JobDTO> getAllJobs(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return jobRepository.findAll(pageable)
                .map(JobMapper::mapToDTO);
    }

    @Override
    public JobDTO getJobById(Long id) {

       return JobMapper.mapToDTO(findJobById(id));
    }



    @Override
    public JobDTO updateJob(Long id, JobDTO jobDTO) {

        Job job = findJobById(id);

        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setCompany(jobDTO.getCompany());
        job.setLocation(jobDTO.getLocation());

        return JobMapper.mapToDTO(jobRepository.save(job));
    }

    @Override
    public void deleteJobById(Long id) {

        jobRepository.delete(findJobById(id));

    }

    @Override
    public Page<JobDTO> searchJobs(String keyword,  int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return jobRepository
                .findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrLocationContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        pageable
                )
                .map(JobMapper::mapToDTO);
    }

    private Job findJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException("Job Not Found With Id : " + id));
    }
}

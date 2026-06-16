package com.hireme.job_service.repository;

import com.hireme.job_service.dto.JobDTO;
import com.hireme.job_service.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    Page<Job> findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrLocationContainingIgnoreCase(
            String title,
            String company,
            String location,
            Pageable pageable
    );

}

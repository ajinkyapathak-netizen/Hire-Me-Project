package com.hireme.job_service.mapper;

import com.hireme.job_service.dto.JobDTO;
import com.hireme.job_service.entity.Job;

public final class JobMapper {

    private JobMapper() {
        // prevent instantiations.
    }

    public static JobDTO mapToDTO(Job job) {
        if (job == null) {
            return null;
        }

        JobDTO dto = new JobDTO();

        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setCompany(job.getCompany());
        dto.setLocation(job.getLocation());
        dto.setDescription(job.getDescription());

        return dto;
    }

    public static Job mapToEntity(JobDTO dto) {
        if (dto == null) {
            return null;
        }

        Job job = new Job();

        job.setId(dto.getId());
        job.setTitle(dto.getTitle());
        job.setCompany(dto.getCompany());
        job.setLocation(dto.getLocation());
        job.setDescription(dto.getDescription());

        return job;
    }
}

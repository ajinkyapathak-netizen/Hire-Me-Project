     package com.hireme.job_service.dto;

     import jakarta.validation.constraints.NotBlank;
     import jakarta.validation.constraints.NotNull;
     import lombok.Data;

     @Data
     public class JobDTO {

          private Long id;

          @NotBlank(message = "Title Name Is Required")
          private String title;

          @NotBlank(message = "Company Name Is Required")
          private String company;

          private String location;
          private String description;
     }

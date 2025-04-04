package com.wiseowls.StudentLink.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wiseowls.StudentLink.Services.JobService;
import com.wiseowls.StudentLink.models.Job;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/jobs")
public class AdminJobController {
    @Autowired
    private JobService jobService;

    // Add a new job
    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    // Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Get a job by ID
    @GetMapping("/{id}")
    public Optional<Job> getJobById(@PathVariable Integer id) {
        return jobService.getJobById(id);
    }

    // Update a job
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Integer id, @RequestBody Job updatedJob) {
        return jobService.updateJob(id, updatedJob);
    }

    // Delete a job
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
    }
}
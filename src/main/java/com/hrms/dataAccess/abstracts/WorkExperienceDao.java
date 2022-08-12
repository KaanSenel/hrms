package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {

    //iş arayanın id'ye göre iş arayanın iş tecrübelerini tersten listeler.
    List<WorkExperience> getByJobseekerCv_IdOrderByEndYearDesc(int id);

    //iş arayanın id'ye göre iş arayanın iş tecrübelerini listeler.
    List<WorkExperience> getByJobseekerCvId(int id);
}
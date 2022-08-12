package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {

    List<ForeignLanguage> getByJobseekerCv_Id(int id);
}
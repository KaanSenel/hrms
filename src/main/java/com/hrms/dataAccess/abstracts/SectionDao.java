package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionDao extends JpaRepository<Section, Integer> {
}
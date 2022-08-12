package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureDao extends JpaRepository<Picture, Integer> {
}
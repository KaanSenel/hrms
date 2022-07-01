package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.SystemPersonel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemPersonelDao extends JpaRepository<SystemPersonel,Integer> {

}

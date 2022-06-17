package com.hrms.business.abstracts;

import com.hrms.entities.concretes.SystemPersonel;

import java.util.List;

public interface SystemPersonelService {

    List<SystemPersonel> getAllPersonels();
    List<String> getAllPositions();
}
package com.hrms.business.concretes;

import com.hrms.business.abstracts.SystemPersonelService;
import com.hrms.dataAccess.abstracts.SystemPersonelDao;
import com.hrms.entities.concretes.SystemPersonel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonelManager implements SystemPersonelService {

    private SystemPersonelDao systemPersonelDao;

    @Autowired
    public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
        this.systemPersonelDao = systemPersonelDao;
    }

    @Override
    public List<SystemPersonel> getAllPersonels() {
        return this.systemPersonelDao.findAll();
    }

    @Override
    public List<String> getAllPositions() {
        return this.systemPersonelDao.findAll().stream().map(SystemPersonel::getPosition).toList();
    }
}
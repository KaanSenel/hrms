package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.business.abstracts.PictureUploadService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobseekerCvDao;
import com.hrms.dataAccess.abstracts.PictureDao;
import com.hrms.entities.concretes.JobseekerCv;
import com.hrms.entities.concretes.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JobSeekerCvManager implements JobSeekerCvService {

    private final JobseekerCvDao jobseekerCvDao;
    private final PictureDao pictureDao;
    private final PictureUploadService pictureUploadService;

    @Autowired
    public JobSeekerCvManager(
                              JobseekerCvDao jobseekerCvDao,
                              PictureDao pictureDao,
                              PictureUploadService pictureUploadService){
        this.jobseekerCvDao=jobseekerCvDao;
        this.pictureDao=pictureDao;
        this.pictureUploadService=pictureUploadService;
    }

    @Override
    public DataResult<List<JobseekerCv>> getAll() {
        return new SuccessDataResult<>(this.jobseekerCvDao.findAll(),
                "Cv verileri getirildi.");
    }

    @Override
    public Result add(JobseekerCv jobseekerCv){
        this.jobseekerCvDao.save(jobseekerCv);
        return new SuccessResult("Cv Başarıyla kaydedildi.");
    }

    /*
        Cloduinary servisini aktif edebilirsen kullanacağın fonksiyon
        bu ama hatalardan dolayı eskisine döndüm.
     */
    @Override
    public Result addWithPicture(JobseekerCv jobseekerCv, MultipartFile file) throws IOException {
        /*
        Picture picture=new Picture();
        picture.setUrl(this.pictureUploadService.uploadPicture(file).getData());
        picture.setJobseekerCv(jobseekerCv);
        this.jobseekerCvDao.save(jobseekerCv);
        this.pictureDao.save(picture);
        return new SuccessResult("Cv Başarıyla kaydedildi.");
         */
        return null;
    }

    @Override
    public JobseekerCv getById(int id) {
        return this.jobseekerCvDao.getById(id);
    }
}
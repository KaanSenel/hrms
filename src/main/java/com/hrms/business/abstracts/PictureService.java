package com.hrms.business.abstracts;

import com.hrms.core.results.Result;
import com.hrms.entities.concretes.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureService {

    Result add(Picture picture, MultipartFile file) throws IOException;
}

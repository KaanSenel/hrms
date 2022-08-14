package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureUploadService {

    DataResult<String> uploadPicture(MultipartFile multipartFile) throws IOException;
}

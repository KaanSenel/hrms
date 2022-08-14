package com.hrms.core.adapters;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.business.abstracts.PictureUploadService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class CloudinaryServiceAdapter implements PictureUploadService {
    @Override
    public DataResult<String> uploadPicture(MultipartFile multipartFile) throws IOException {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "kaan",
                "api_key", "884751842895681",
                "api_secret", "PStWWSTLq_qvcz45PTqLdaUWm2g",
                "secure",true));
        File file=convert(multipartFile);
        String uploadResult=cloudinary.uploader().upload(file,ObjectUtils.emptyMap()).get("url").toString();
        file.delete();
        return new
                SuccessDataResult<>(uploadResult,"Başarıyla yüklendi");
    }

    private File convert(MultipartFile multipartFile) throws IOException{
        File file=new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
}

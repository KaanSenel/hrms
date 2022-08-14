package com.hrms.api.controllers;

import com.hrms.business.abstracts.PictureService;
import com.hrms.entities.concretes.JobseekerCv;
import com.hrms.entities.concretes.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/picture")
public class PictureController {
}
  /*  private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService){
        this.pictureService=pictureService;
    }

    @PostMapping(value = "/add"*//*,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE}*//*)
    public ResponseEntity<?> add(@ModelAttribute("file") @RequestPart MultipartFile file,
                                 @RequestBody Picture picture)
                      throws IOException {
        //Picture picture=new Picture(); requestpart var idi
        return ResponseEntity.ok(this.pictureService.add(picture,file));
    }

}*/

package com.vectorit.anaw.controller;

import com.google.common.io.ByteStreams;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.activation.FileTypeMap;
import java.io.*;
import java.nio.file.Files;

@RestController
@RequestMapping(value = "/api/v1/img")
public class ImgController {

    @PostMapping(value = "",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadImage(@RequestParam("file")MultipartFile file ) throws IOException {
        File imgFile = new File("/home/nk/Anaw_app/anaw-api/img/" + file.getOriginalFilename());
        imgFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(imgFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("uploaded!!", HttpStatus.OK);
    }
    @GetMapping(value = "/{image:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable String image) throws IOException {
        /*InputStream in = getClass()
                .getResourceAsStream("/home/nk/Anaw_app/anaw-api/img/" + image);
        byte[] bytes = ByteStreams.toByteArray(in);
        return bytes;*/

        File imgFile = new File("/home/nk/Anaw_app/anaw-api/img/" + image);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" +imgFile.getName())
                .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(imgFile)))
                .body(Files.readAllBytes(imgFile.toPath()));
    }
}

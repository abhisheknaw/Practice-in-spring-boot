package com.api.book.bootrestbook.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//code to upload our file

@Component
public class FileUploadHelper {

    //public final String UPLOAD_DIR="F:\\rest api\\bootrestbook\\src\\main\\resources\\static\\image"; //file will upload here ,this is static method

    public final String UPLOAD_DIR= new ClassPathResource("static/image/").getFile().getAbsolutePath();   //for getting path dynamically,,classpathresource will help to get out path till the resources

    public FileUploadHelper()throws IOException
    {
         
    }
    public boolean uploadFile(MultipartFile multipartFile)
    {
        boolean f=false;

        try 
        {
           Files.copy(multipartFile.getInputStream() ,Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
           f=true;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }


    
}

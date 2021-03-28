package com.api.book.bootrestbook.Controller;

import com.api.book.bootrestbook.Helper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController                                    //files are uploaded using this controller
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")                               
    public ResponseEntity<String> Uploadfile(@RequestParam("file") MultipartFile file)  //multipart is used to handle file object
    {  
        //  System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());             //extra functions to learn about 
        // System.out.println(file.getName());


        try
        {
            //Validation
            if(file.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }

            if(!file.getContentType().equals("image/jpeg"))
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg files are allowed");
            }
            //if both conditions are fine then we will upload our file we will make a helper class for it....
            //for this we will need our directory where to upload our file..

            boolean f = fileUploadHelper.uploadFile(file);
            if(f)
            {
                //return ResponseEntity.ok("File is successfully uploaded");


                //now we will return the url of our image
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString()); //first it will get our localhost and port then image folder and then our file name and then convert it to uristring

            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.Try again!!!!");
    }
    
}

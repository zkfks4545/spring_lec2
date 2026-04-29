package com.js.spring_lec2.service;

import com.js.spring_lec2.mapper.FileMapper;
import com.js.spring_lec2.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    // db
    @Autowired
    private FileMapper fileMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public void upload(FileVO fileVO, MultipartFile fFile) {

        // 확장자 추출
        String ext = fFile.getOriginalFilename()
                .substring(fFile.getOriginalFilename().lastIndexOf("."));


        // 파일명 재생성 (중복 방지.)
        String uuid = UUID.randomUUID().toString().split("-")[0];
        System.out.println(uuid + ext);

        String fileName = uuid + ext;
        File saveFile = new File(uploadDir + "/" + fileName);

        try {
            fFile.transferTo(saveFile);

            fileVO.setF_name(fileName);
            // db 저장
            fileMapper.saveFile(fileVO);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] upload2(MultipartFile[] files) {

        String fNames = "";
        for (MultipartFile fFile : files) {
            // 확장자 추출
            String ext = fFile.getOriginalFilename()
                    .substring(fFile.getOriginalFilename().lastIndexOf("."));

            // 파일명 재생성 (중복 방지.)
            String uuid = UUID.randomUUID().toString().split("-")[0];
            System.out.println(uuid + ext);

            String fileName = uuid + ext;
            File saveFile = new File(uploadDir + "/" + fileName);

            fNames += fileName + "!";
            System.out.println(fNames);

            try {
                fFile.transferTo(saveFile);

                // db 저장

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(fNames);
        FileMapper.saveFile2(fNames);
        String[] fileNames = fNames.split("!");
        return fileNames;
    }
}

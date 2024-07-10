package com.ohgiraffers.chap06fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    private ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("single-file")
    public String singFileUpload(@RequestParam MultipartFile singleFile,String singleFileDescription, Model model) throws IOException {

        //ㅍㅏ일 저장할 경로를 설정한다.
        Resource resource = resourceLoader.getResource("classpath:static:/img/single");

        String filePath = null;

        // 절대경로는 ex) d:\class\gangnam~~ 등 드라이브 루트부터 시작됨
        // 상대경로는 내가 지금 있는 폴더에서부터 시작됨 ex) src\main\resources ~
        //만약 해당 경로가 없다면
        if(!resource.exists()) {
            String root = "src/main/resources/static/img/single";
            File file = new File(root);

            file.mkdirs();

            filePath = file.getAbsolutePath();
        }else{
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();
        }

        String originFileName = singleFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String saveName = UUID.randomUUID().toString().replace("-","") + ext;

        try{
            singleFile.transferTo(new File(filePath + "/" + saveName));
            model.addAttribute("message","파일 업로드 성공");
            model.addAttribute("img","static/img/single/"+saveName);
        }catch (Exception exception){
            exception.printStackTrace();
            model.addAttribute("message","파일 업로드 실패");
        }
        return "result";
    }

}

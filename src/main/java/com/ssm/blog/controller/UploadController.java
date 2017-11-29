package com.ssm.blog.controller;

import com.ssm.blog.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Houxudong
 **/
@Controller
@RequestMapping("/up")
public class UploadController {
    @RequestMapping(value = "/upload.html")
    @ResponseBody
    public String fileUpload1(@RequestParam("file") MultipartFile file) {
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = System.currentTimeMillis() + extName;
        try {

            //将上传的文件存在E:/upload/下
//            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/upload/",
//                    fileName));
            File newFile = new File("E:/upload/", fileName);
            //通过CommonsMultipartFile的方法直接写文件
            file.transferTo(newFile);

            ImageUtil.imgThumb(newFile, "E:/upload/"+ fileName, 500, 500, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传成功返回原来页面
        return  fileName;
    }
    @RequestMapping("cut.html")
    @ResponseBody
    public String cutImg(String fileName, int x1, int y1, int w, int h) throws Exception {
        ImageUtil.imgSourceRegion("e:/upload/" + fileName, "e:/upload/" + fileName, x1, y1, w, h, 100, 100, true);
        return fileName;
    }
}

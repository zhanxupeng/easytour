package com.mr.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/image")
public class ImageController {
    private final static String DEFAULT_PATH = File.separator + "pictures";
    private final static String CLASSPATH = "classpath:";

    /**
     * 显示图片接口
     */
    @GetMapping("/show.do")
    public void showImage(String imagePath, HttpServletResponse response) throws IOException {
        if (StrUtil.isBlank(imagePath)) {
            return;
        }

        imagePath = URLDecoder.decode(imagePath, "utf-8");
        File file = ResourceUtils.getFile(CLASSPATH + imagePath);

        FileInputStream inputStream = new FileInputStream(file);
        response.setContentType("multipart/form-data");
        ServletOutputStream out = response.getOutputStream();
        int i;
        byte[] buffer = new byte[4096];
        while ((i = inputStream.read(buffer)) != -1) {
            out.write(buffer, 0, i);
        }
        out.flush();
        inputStream.close();
        out.close();
    }

    /**
     * 上传图片
     */
    @PostMapping("/upload.do")
    @ResponseBody
    public Map uploadImage(MultipartFile file) {

        Map<String, Object> map = null;
        try {
            String fileName = file.getOriginalFilename();//文件原名称
            //自定义的文件名称
            String newFileName = String.valueOf(System.currentTimeMillis()) + fileName;

            File currentFile = new File(DEFAULT_PATH, newFileName);
            if (!currentFile.getParentFile().exists()) {
                currentFile.getParentFile().mkdirs();
            }
            if (!currentFile.exists()) {
                currentFile.createNewFile();
            }

            file.transferTo(currentFile);

            map = new TreeMap<>();

            //图片保存路径
            String urlStr = "\\image\\show?imagePath=" + URLEncoder.encode(DEFAULT_PATH + File.separator + newFileName, "utf-8");
            map.put("status", 0);
            map.put("url", urlStr);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("msg", "系统异常，上传失败");
            return map;
        }
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(URLEncoder.encode("pictures" + File.separator + "nous_eg.jpg", "utf-8"));
        System.out.println("\\image\\show?imagePath=" +
                URLEncoder.encode("pictures" + File.separator + "tab" + File.separator
                        + "recommend.png", "utf-8"));
    }
}

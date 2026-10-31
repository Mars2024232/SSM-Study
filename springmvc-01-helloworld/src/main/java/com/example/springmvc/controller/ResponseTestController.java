package com.example.springmvc.controller;

import com.example.springmvc.bean.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class ResponseTestController {
/*
* 会自动把返回的对象转为ujson格式
* */
@ResponseBody//把返回的内容返回响应体中
@RequestMapping("/resp01")
    public Person test01(){
    Person person = new Person();
    person.setUsername("amy");
    person.setPassword("123");
    person.setCellphone("1111");
    person.setAgreement(true);

    return person;
}

/*
* 文件下载模板;
*   ResponseEntity:拿到整个响应数据(响应头,响应体)
* */
@RequestMapping("/download")
public ResponseEntity<byte[]> download() throws IOException {
    FileInputStream inputStream = new FileInputStream("D/img");
    byte[] bytes = inputStream.readAllBytes();

    //1.文件名是中文:会乱码 解决:进行编码

    String encode = URLEncoder.encode("大大王", "UTF-8");

    //2.如果文件太大oom(文件会溢出)

    InputStreamResource resource = new InputStreamResource(inputStream);

    return ResponseEntity.ok()
            //内容类型:流
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            //内容长度
            .contentLength(bytes.length)
            //内容处理方式 contont-Disposition
            .header("Content-Disposition","hh.jpg")
            .body(bytes);

}
}

package com.iwuhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Yuxilai
 * @Date: 2022/1/20 - 10:02
 * @Description: com.iwuhu.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/iwuhu")
public class ExcelController {
   @Autowired
   private HttpServletRequest httpServletRequest;

   /* @PostMapping("/list-export")
    public void getDeviceExcelList(@RequestBody DeviceExcelFormBean deviceExcelFormBean, HttpServletResponse httpServletResponse) throws IllegalAccessException {
        deviceManageService.getDeviceExcelList(deviceExcelFormBean, httpServletResponse);
    }*/

   @PostMapping("/test")
   public void test(){
      String abc = httpServletRequest.getHeader("ABC");
      System.out.println(abc);
      System.out.println("test");
   }


}

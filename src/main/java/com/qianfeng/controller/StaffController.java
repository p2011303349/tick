package com.qianfeng.controller;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.SysCourse;
import com.qianfeng.entity.SysDepart;
import com.qianfeng.entity.SysGrade;
import com.qianfeng.entity.SysStaff;
import com.qianfeng.service.CourseService;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.ImportExcel;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by Administrator on 2019/4/16 0016.
 */
@Controller
@ResponseBody
public class StaffController {
    @Autowired
    private StaffService staffService;


    @RequestMapping("/staffpage.do")



    public Map<String, Object> staffList(int page){
        PageHelper.startPage(page, 5);
        Map<String, Object> map = new HashMap<>();

        try {
            List<SysStaff> list =  staffService.staffList();
            long total = ((Page)list).getTotal();
            /*response.sendRedirect(request.getContextPath() + "/index.html");*/
            System.out.println("sdfsfd");
            map.put("code", 0); // 0 表示成功
            map.put("msg", "");
            map.put("count", total);
            map.put("data", list);

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }
    }

    @RequestMapping("/staffdelete.do")

    public JsonBean deleteStaff(String no){
        staffService.deleteStaff(no);
        return JsonUtils.createJsonBean(1, null);
    }

    @RequestMapping("/departall.do")

    public List<SysDepart> departall(){




        List<SysDepart> list =  staffService.departall();
            /*response.sendRedirect(request.getContextPath() + "/index.html");*/
        return list;

    }
    @RequestMapping(value = "/photoupload.do", method = RequestMethod.POST)

    public Map<String, Object> uploadHead(@RequestParam("file") MultipartFile file, HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        try {
            if (file != null) {
                //获取文件名
                String fileName = file.getOriginalFilename();
                //截取扩展名
                String extName = fileName.substring(fileName.lastIndexOf("."));
                List list = new ArrayList();
                list.add(".jpg");
                list.add(".png");
                list.add(".jpeg");
                list.add(".gif");
                if(list.contains(extName.toLowerCase())){

                    //01获取服务器项目部署的路径，并在根目录下创建 myphoto 目录
                    String realPath = session.getServletContext().getRealPath("photos");
                    //02也可以直接定义文件路径
                    /*String realPath = "D:\\space\\SSMBase\\src\\main\\webapp\\img";*/

                    String photoFileName = new Date().getTime()+extName;
                    String descPath = "photos\\" + photoFileName;

                    /*System.out.println(descPath);*/
                    file.transferTo(new File(realPath,photoFileName));
                    map.put("code", 0); // 0 表示成功
                    map.put("msg", descPath);

                    System.out.println(map.get("msg"));


                    return map;//成功
                }else {
                    map.put("code", 1);
                    return map;//文件类型不正确
                }
            }else {
                map.put("code", 1);
                return map;//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 1);
            return map;//上传异常
        }
    }

    @RequestMapping("/staffupdate.do")
    public void updateStaff(SysStaff sysStaff,HttpServletRequest request, HttpServletResponse response){
        try {

            staffService.updateStaff(sysStaff);

            response.sendRedirect(request.getContextPath() + "/stafflist.html");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/staffadd.do")
    public void addStaff(SysStaff sysStaff,HttpServletRequest request, HttpServletResponse response){
        try {

            staffService.addStaff(sysStaff);

            response.sendRedirect(request.getContextPath() + "/stafflist.html");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/importBatch.do")
    @ResponseBody
    public JsonBean importExcel(@RequestParam MultipartFile excelfile,HttpServletResponse response,HttpServletRequest request) {
        try {
            String filename = excelfile.getOriginalFilename();
            //获取上传文件的输入流
            InputStream inputStream = excelfile.getInputStream();
            List<Map<String, Object>> scorceList =	ImportExcel.readExcel(filename, inputStream);
            ObjectMapper objectMapper = new ObjectMapper();

            String infos = objectMapper.writeValueAsString(scorceList);

            List<SysStaff> list = objectMapper.readValue(infos, new TypeReference<List<SysStaff>>() {});

            staffService.addUserBatch(list);
            response.sendRedirect(request.getContextPath() + "/index.html");

            return JsonUtils.createJsonBean(1, null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return JsonUtils.createJsonBean(0, e.getMessage());
        }

    }



   /* @RequestMapping("/gradeupdate.do")
    public void updateGrade(SysGrade sysGrade, HttpServletRequest request, HttpServletResponse response){
        try {
            gradeService.updateGrade(sysGrade);

            response.sendRedirect(request.getContextPath() + "/gradelist.html");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
*/

}

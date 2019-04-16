package com.qianfeng.service;

import com.qianfeng.entity.SysGrade;
import com.qianfeng.vo.VGrade;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;


import java.util.List;

/**
 * Created by Administrator on 2019/4/15 0015.
 */
public interface GradeService {
    public List<VGrade> gradeList();

    public void deleteGrade(Integer id);

    public void updateGrade(SysGrade sysGrade);
}

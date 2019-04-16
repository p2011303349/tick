package com.qianfeng.service.impl;

import com.qianfeng.dao.SysCourseMapper;
import com.qianfeng.dao.SysGradeMapper;
import com.qianfeng.entity.SysGrade;
import com.qianfeng.service.GradeService;
import com.qianfeng.vo.VGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/15 0015.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private SysGradeMapper gradeDao;

    @Override
    public List<VGrade> gradeList() {
        return gradeDao.gradeList();


    }

    @Override
    public void deleteGrade(Integer id) {
        gradeDao.deleteGrade(id);
    }

    @Override
    public void updateGrade(SysGrade sysGrade) {
        gradeDao.updateGrade(sysGrade);
    }
}

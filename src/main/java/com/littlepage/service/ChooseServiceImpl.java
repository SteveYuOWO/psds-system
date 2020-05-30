package com.littlepage.service;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChooseServiceImpl implements ChooseService {
    CommonDao<DualChoose> dualChooseDao = new CommonDao<>();

    CommonDao<Teacher> teacherDao = new CommonDao<>();

    /**
     * 插入双选
     * @param teacherId
     * @param studentId
     * @return
     */
    @Override
    public boolean insertDualChoose(int teacherId, int studentId) {
        Map<String, Object> map = new TreeMap<>();
        map.put("teacherId", teacherId);
        map.put("studentId", studentId);
        List<DualChoose> list = dualChooseDao.selectEqual("t_dualChoose", map, DualChoose.class);
        if(list.size() != 0) return false;
        DualChoose dualChoose = new DualChoose();
        dualChoose.setStudentId(studentId); dualChoose.setTeacherId(teacherId);
        dualChoose.setStatus(0);
        return dualChooseDao.insert(dualChoose);
    }

    /**
     * 计算选课数量
     * @return
     */
    @Override
    public int countStudentChooseNum(int studentId) {
        Map<String, Object> map = new TreeMap<>();
        map.put("studentId", studentId);
        List<DualChoose> list = dualChooseDao.selectEqual("t_dualChoose", map, DualChoose.class);
        return list.size();
    }

    /**
     * 选择双选
     * @param studentId
     * @return
     */
    @Override
    public List<Teacher> selectDualChooseByStudent(int studentId) {
        List<Teacher> teacherList = new ArrayList<>();
        Map<String, Object> map = new TreeMap<>();
        map.put("studentId", studentId);
        List<DualChoose> dualChooseList = dualChooseDao.selectEqual("t_dualChoose", map, DualChoose.class);
        dualChooseList.forEach(dualChoose -> {
            Integer teacherId = dualChoose.getTeacherId();
            map.clear();
            map.put("id", teacherId);
            List<Teacher> list = teacherDao.selectEqual("t_teacher", map, Teacher.class);
            list.forEach(teacher -> teacherList.add(teacher));
        });
        return teacherList;
    }
}

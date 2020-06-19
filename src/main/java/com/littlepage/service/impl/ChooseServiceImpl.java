package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Major;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.ChooseService;
import com.littlepage.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChooseServiceImpl implements ChooseService {
    CommonDao<DualChoose> dualChooseDao = new CommonDao<>();

    CommonDao<Teacher> teacherDao = new CommonDao<>();

    StudentService studentService = new StudentServiceImpl();

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
    public List<Teacher> selectTeachersByStudent(int studentId) {
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

    @Override
    public List<DualChoose> selectDualChooseByStudent(int studentId) {
        List<Teacher> teacherList = new ArrayList<>();
        Map<String, Object> map = new TreeMap<>();
        map.put("studentId", studentId);
        return dualChooseDao.selectEqual("t_dualChoose", map, DualChoose.class);
    }

    @Override
    public boolean deleteDualChoose(int teacherId, int studentId) {
        Map<String, Object> map = new TreeMap<>();
        map.put("studentId", studentId);
        map.put("teacherId", teacherId);
        return dualChooseDao.deleteEqual("t_dualChoose", map, DualChoose.class);
    }

    @Override
    public boolean updateStatus(int studentId, int teacherId, int status) {
        Map<String, Object> map = new TreeMap<>();
        map.put("studentId", studentId);
        map.put("teacherId", teacherId);
        List<DualChoose> list = dualChooseDao.selectEqual("t_dualChoose", map, DualChoose.class);
        if(list.size() == 0) return false;
        DualChoose dualChoose = list.get(0);
        dualChoose.setStatus(status);
        boolean success = dualChooseDao.update(dualChoose);
        return success;
    }

    /**
     * 选择Major数量
     * @return
     */
    @Override
    public Integer selectMajorCount(String major) {
        List<DualChoose> dualChooseList = dualChooseDao.selectBatch(DualChoose.class, 0, 100000);
        int cnt = (int) dualChooseList.stream().
                filter(dualChoose -> dualChoose.getStatus() == 2).
                map(dualChoose -> studentService.selectStudent(dualChoose.getStudentId())).
                filter(student -> student.getMajor().equals(major)).count();
        return cnt + 1;
    }

    @Override
    public boolean confirmNullUpdate(int parseInt, int parseInt1, int i) {
        return false;
    }

    @Override
    public boolean confirmNullUpdate(int studentId, int status) {
        Map<String, Object> map = new TreeMap<>();
        map.put("studentId", studentId);
        map.put("status", status);
        List<DualChoose> dualChooseList = dualChooseDao.selectEqual("t_dualChoose", map, DualChoose.class);
        return dualChooseList.size() == 0;
    }
}

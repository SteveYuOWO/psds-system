package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.DualChoose;
import com.littlepage.entity.Student;
import com.littlepage.entity.Teacher;
import com.littlepage.service.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TeacherServiceImpl implements TeacherService {
    CommonDao<Teacher> teacherDao = new CommonDao<>();
    CommonDao<DualChoose> dualChooseDao = new CommonDao<>();
    CommonDao<Student> studentDao = new CommonDao<>();

    @Override
    public List<Teacher> selectTeachers(int start, int count) {
        return teacherDao.selectBatch(Teacher.class, start, count);
    }

    @Override
    public Teacher selectTeacher(int id) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", id);
        List<Teacher> list = teacherDao.selectEqual("t_teacher", map, Teacher.class);
        return list.size() == 0 ? null: list.get(0);
    }

    @Override
    public boolean insertTeacher(Teacher teacher) {
        return teacherDao.insert(teacher);
    }

    @Override
    public boolean deleteTeacher(int id) {
        return teacherDao.delete(id, Teacher.class);
    }

    @Override
    public List<Teacher> search(String message) {
        return teacherDao.selectLike("t_teacher", message, Teacher.class);
    }

    @Override
    public boolean update(Teacher teacher) {
        return teacherDao.update(teacher);
    }

    @Override
    public int makePageList(int pageSize) {
        int size = teacherDao.count("t_teacher");
        return size / pageSize;
    }

    @Override
    public List<Teacher> selectTeacherByMajor(String major) {
        Map<String, Object> map = new TreeMap<>();
        map.put("major", major);
        return teacherDao.selectEqual("t_teacher", map, Teacher.class);
    }

    @Override
    public Teacher selectTeacherByTeaNum(String loginName) {
        Map<String, Object> map = new TreeMap<>();
        map.put("teaNum", loginName);
        List<Teacher> list = teacherDao.selectEqual("t_teacher", map, Teacher.class);
        return list.size() == 0 ? null: list.get(0) ;
    }

    @Override
    public List<Student> selectHasChooseStudentsByTeaId(Integer teacherId) {
        List<Student> ret = new ArrayList<>();
        Map<String, Object> dualChooseMap = new TreeMap<>();
        dualChooseMap.put("teacherId", teacherId);
        List<DualChoose> list = dualChooseDao.selectEqual("t_dualChoose", dualChooseMap, DualChoose.class);
        list.forEach(dualChoose -> {
            if(dualChoose.getStatus() == 0) {
                Map<String, Object> studentMap = new TreeMap<>();
                studentMap.put("id", dualChoose.getStudentId());
                List<Student> studentList = studentDao.selectEqual("t_student", studentMap, Student.class);
                if (studentList.size() != 0) ret.add(studentList.get(0));
            }
        });
        return ret;
    }

    @Override
    public List<Student> selectHasConfirmedChooseStudentsByTeaId(Integer teacherId) {
        List<Student> ret = new ArrayList<>();
        Map<String, Object> dualChooseMap = new TreeMap<>();
        dualChooseMap.put("teacherId", teacherId);
        List<DualChoose> list = dualChooseDao.selectEqual("t_dualChoose", dualChooseMap, DualChoose.class);
        list.forEach(dualChoose -> {
            if(dualChoose.getStatus() == 1) {
                Map<String, Object> studentMap = new TreeMap<>();
                studentMap.put("id", dualChoose.getStudentId());
                List<Student> studentList = studentDao.selectEqual("t_student", studentMap, Student.class);
                if (studentList.size() != 0) ret.add(studentList.get(0));
            }
        });
        return ret;
    }

    @Override
    public Teacher selectTeacherByTeaId(Integer teacherId) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", teacherId);
        List<Teacher> list = teacherDao.selectEqual("t_teacher", map, Teacher.class);
        return list.size() == 0 ? null: list.get(0) ;
    }
}

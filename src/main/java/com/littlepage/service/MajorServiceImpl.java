package com.littlepage.service;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Major;
import com.littlepage.entity.Student;

import java.util.List;

/**
 * Major Service
 */
public class MajorServiceImpl implements MajorService {
    CommonDao<Major> commonDao = new CommonDao<>();

    @Override
    public boolean insertMajor(Major major) {
        return commonDao.insert(major);
    }

    @Override
    public boolean deleteMajor(int id) {
        return commonDao.delete(id, Major.class);
    }

    @Override
    public boolean updateMajor(Major major) {
        return commonDao.update(major);
    }

    @Override
    public List<Major> selectMajorByName(String name) {
        return commonDao.selectByStringParam("t_major", "name", name, Major.class);
    }

    @Override
    public List<Major> selectMajors(int start, int count) {
        return commonDao.selectBatch(Major.class, start, count);
    }

    @Override
    public int makePageList(int pageSize) {
        int size = commonDao.count("t_major");
        return size / pageSize;
    }
}

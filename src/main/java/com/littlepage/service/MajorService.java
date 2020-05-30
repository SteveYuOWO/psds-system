package com.littlepage.service;

import com.littlepage.entity.Major;
import com.littlepage.entity.Student;

import java.util.List;

public interface MajorService {
    boolean insertMajor(Major major);

    boolean deleteMajor(int id);

    boolean updateMajor(Major major);

    List<Major> selectMajorByName(String name);

    List<Major> selectMajors(int start, int count);

    int makePageList(int pageSize);
}

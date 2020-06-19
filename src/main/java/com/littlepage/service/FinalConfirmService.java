package com.littlepage.service;

import com.littlepage.entity.FinalTableView;

import java.util.List;

public interface FinalConfirmService {
    List<FinalTableView> selectManageChoosesNotFinal();

    List<FinalTableView> selectManageChoosesAlready();

    List<FinalTableView> selectAll();
}

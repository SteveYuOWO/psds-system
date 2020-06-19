package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.Root;
import com.littlepage.service.RootService;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RootServiceImpl implements RootService {
    CommonDao<Root> rootCommonDao = new CommonDao<>();

    /**
     * 由名字查找Root用户
     * @param loginName
     * @return
     */
    @Override
    public Root selectRootByRootAdminName(String loginName) {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", loginName);
        List<Root> list = rootCommonDao.selectEqual("t_root", map, Root.class);
        return list.size() != 0 ? list.get(0): null;
    }
}

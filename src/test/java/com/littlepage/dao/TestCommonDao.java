package com.littlepage.dao;

import com.littlepage.entity.Admin;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCommonDao {
    @Test
    public void testInsert() {
        CommonDao<Admin> commonDao = new CommonDao<>();
        Admin admin = new Admin();
        admin.setId(0).setName("root").setPasswd("root").setRole("root").setSex("男");
        boolean insert = commonDao.insert(admin);
        System.out.println(insert);
    }

    @Test
    public void testDelete() {
        CommonDao<Admin> commonDao = new CommonDao<>();
        boolean delete = commonDao.delete(11, Admin.class);
        System.out.println(delete);
    }

    /**
     * 测试批量查询
     */
    @Test
    public void testSelectBatch() {
        CommonDao<Admin> commonDao = new CommonDao<>();
        List<Admin> admins = commonDao.selectBatch(Admin.class, 0, 5);
        admins.forEach(System.out::println);
    }

    @Test
    public void testSelectAnd() {
        CommonDao<Admin> commonDao = new CommonDao<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "root");
        List<Admin> list1 = commonDao.selectEqual("t_admin", map, Admin.class);
        System.out.println(list1);
        System.out.println();

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 19);
        List<Admin> list2 = commonDao.selectEqual("t_admin", map2, Admin.class);
        System.out.println(list2);
        System.out.println();

        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", 18);
        map3.put("name", "root1");
        List<Admin> list3 = commonDao.selectEqual("t_admin", map3, Admin.class);
        System.out.println(list3);
        System.out.println();
    }

    @Test
    public void testSelectLike() {
        CommonDao<Admin> commonDao = new CommonDao<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ro");
        map.put("role", "ro");
        List<Admin> list1 = commonDao.selectLike("t_admin", map, Admin.class);
        list1.forEach(System.out::println);
        System.out.println();
    }

    @Test
    public void testUpdate() {
        CommonDao<Admin> commonDao = new CommonDao<>();
        Admin admin = new Admin();
        admin.setId(19).setName("root1212").setPasswd("root12121").setRole("root121221").setSex("女");
        boolean update = commonDao.update(admin);
        System.out.println(update);
    }
}

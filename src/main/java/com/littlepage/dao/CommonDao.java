package com.littlepage.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 通用Dao
 * @param <T>
 */
public class CommonDao<T> {
    static Connection conn = null;
    static Statement stmt = null;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psds?characterEncoding=utf8", "root", "Root123..");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入
     * @param t 是否成功插入
     */
    public boolean insert(T t) {
        int success = 0;
        try {
            Class<?> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            String[] splits = clazz.getName().split("\\.");
            String clazzName = splits[splits.length - 1];
            clazzName = "t_" + Character.toLowerCase(clazzName.charAt(0)) + clazzName.substring(1);
            StringBuffer sql = new StringBuffer("insert " + clazzName + " values(");
            for (Field field : fields) {
                field.setAccessible(true);
                if(field.getName().equals("id")) sql.append("null, ");
                else if(field.getType().toString().endsWith("String")) sql.append("'" + field.get(t) + "', ");
                else if(field.getType().toString().endsWith("Integer")) sql.append(field.get(t) + ", ");
            }
            sql.replace(sql.length() - 2, sql.length(), ")");
            success = stmt.executeUpdate(sql.toString());
            logger.info(sql.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return success == 1;
    }

    /**
     * 删除
     * @param id 主键id
     * @param clazz 类
     * @return 是否成功删除
     */
    public boolean delete(int id, Class<T> clazz) {
        int success = 0;
        try {
            String[] splits = clazz.getName().split("\\.");
            String clazzName = splits[splits.length - 1];
            clazzName = "t_" + Character.toLowerCase(clazzName.charAt(0)) + clazzName.substring(1);
            String sql = "delete from " + clazzName + " where id="+id;
            logger.info(sql);
            success = stmt.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return success == 1;
    }

    /**
     *
     * @param t
     * @return
     */
    public boolean update(T t) {
        int success = 0;
        Object id = null;
        try {
            String[] splits = t.getClass().getName().split("\\.");
            String clazzName = splits[splits.length - 1];
            clazzName = "t_" + Character.toLowerCase(clazzName.charAt(0)) + clazzName.substring(1);
            StringBuffer sql = new StringBuffer("update " + clazzName + " set");
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if(field.getName().equals("id")) id = field.get(t);
                else if(field.getType().toString().endsWith("String")) sql.append(" "+field.getName()+"='" + field.get(t) + "', ");
                else if(field.getType().toString().endsWith("Integer")) sql.append(" "+ field.getName() + "=" + field.get(t) + ", ");
            }
            sql.delete(sql.length() - 2, sql.length());
            sql.append(" where id=" + id.toString());
            success = stmt.executeUpdate(sql.toString());
            logger.info(sql.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return success == 1;
    }

    /**
     * 选择所有
     * @param clazz 类
     * @param start 开始
     * @param count 数量
     * @return
     */
    public List<T> selectBatch(Class<T> clazz, int start, int count) {
        List<T> list = new ArrayList<>();
        try {
            String[] splits = clazz.getName().split("\\.");
            String clazzName = splits[splits.length - 1];
            clazzName = "t_" + Character.toLowerCase(clazzName.charAt(0)) + clazzName.substring(1);
            String sql = "select * from " + clazzName + " limit " + start + "," + count;
            logger.info(sql);
            ResultSet rs = stmt.executeQuery(sql);
            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if(field.getType().toString().endsWith("String")) {
                        String value = rs.getString(field.getName());
                        // set 注入
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), String.class);
                        method0.invoke(t, value);
                    }
                    else if(field.getType().toString().endsWith("Integer")) {
                        Integer value = rs.getInt(field.getName());
                        rs.getInt(field.getName());
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), Integer.class);
                        method0.invoke(t, value);
                    }
                }
                list.add(t);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 降序批量查询
     * @param clazz
     * @param start
     * @param count
     * @param descName 降序字段
     * @return
     */
    public List<T> selectBatchDesc(Class<T> clazz, int start, int count, String descName) {
        List<T> list = new ArrayList<>();
        try {
            String[] splits = clazz.getName().split("\\.");
            String clazzName = splits[splits.length - 1];
            clazzName = "t_" + Character.toLowerCase(clazzName.charAt(0)) + clazzName.substring(1);
            String sql = "select * from " + clazzName + " order by " + descName + " desc" + " limit " + start + "," + count;
            logger.info(sql);
            ResultSet rs = stmt.executeQuery(sql);
            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if(field.getType().toString().endsWith("String")) {
                        String value = rs.getString(field.getName());
                        // set 注入
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), String.class);
                        method0.invoke(t, value);
                    }
                    else if(field.getType().toString().endsWith("Integer")) {
                        Integer value = rs.getInt(field.getName());
                        rs.getInt(field.getName());
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), Integer.class);
                        method0.invoke(t, value);
                    }
                }
                list.add(t);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * select * from t_tableName where x=x and ...的抽象
     * @param tableName
     * @param params
     * @param clazz
     * @return
     */
    public List<T> selectEqual(String tableName, Map<String, Object> params, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer("select * from " + tableName + " where");
            Set<String> keys = params.keySet();
            boolean start = true;
            for (String key : keys) {
                if(start) start = false;
                else sql.append(" and");
                Object value = params.get(key);
                if(value instanceof String) {
                    sql.append(" " + key + "='" + value + "'");
                } else {
                    sql.append(" " + key + "=" + value);
                }
            }
            logger.info(sql.toString());
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    if(field.getType().toString().endsWith("String")) {
                        String value = rs.getString(field.getName());
                        // set 注入
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), String.class);
                        method0.invoke(t, value);
                    }
                    else if(field.getType().toString().endsWith("Integer")) {
                        Integer value = rs.getInt(field.getName());
                        rs.getInt(field.getName());
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), Integer.class);
                        method0.invoke(t, value);
                    }
                }
                list.add(t);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * select * from t_tableName where x like x or ...的抽象
     * @param tableName
     * @param clazz
     * @return
     */
    public List<T> selectLike(String tableName, String keyword, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer("select * from " + tableName + " where");
            for (Field field : clazz.getDeclaredFields()) {
                if(field.getType().toString().endsWith("String"))
                    sql.append(" " + field.getName() + " like " + "'%" + keyword + "%'" + " or");
            }
            String sqlStr = sql.substring(0, sql.length() - 2);
            logger.info(sqlStr);
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    if(field.getType().toString().endsWith("String")) {
                        String value = rs.getString(field.getName());
                        // set 注入
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), String.class);
                        method0.invoke(t, value);
                    }
                    else if(field.getType().toString().endsWith("Integer")) {
                        Integer value = rs.getInt(field.getName());
                        rs.getInt(field.getName());
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), Integer.class);
                        method0.invoke(t, value);
                    }
                }
                list.add(t);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 计数
     * @param tableName
     * @return
     */
    public int count(String tableName) {
        try {
            String sql = "select count(*) from " + tableName;
            logger.info(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查找一个table 存在key value
     * @param tableName
     * @param key
     * @param value
     * @param clazz
     * @return
     */
    public List<T> selectByStringParam(String tableName, String key, String value, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        try {
            String sql = "select * from " + tableName + " where " + key + "='" + value + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                T t = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if(field.getType().toString().endsWith("String")) {
                        field.set(t, rs.getString(field.getName()));
                    } else if(field.getType().toString().endsWith("Integer")) {
                        field.set(t, rs.getInt(field.getName()));
                    }
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * deleteEqual
     * @param tableName
     * @param params
     * @param clazz
     * @return
     */
    public boolean deleteEqual(String tableName, Map<String, Object> params, Class<T> clazz) {
        int cnt = 0;
        try {
            StringBuffer sql = new StringBuffer("delete from " + tableName + " where");
            Set<String> keys = params.keySet();
            boolean start = true;
            for (String key : keys) {
                if(start) start = false;
                else sql.append(" and");
                Object value = params.get(key);
                if(value instanceof String) {
                    sql.append(" " + key + "='" + value + "'");
                } else {
                    sql.append(" " + key + "=" + value);
                }
            }
            cnt = stmt.executeUpdate(sql.toString());
            logger.info(sql.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return cnt != 0;
    }

    public List<T> selectLike(String tableName, String keyword, Class<T> clazz, int start, int count) {
        List<T> list = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer("select * from " + tableName + " where");
            for (Field field : clazz.getDeclaredFields()) {
                if(field.getType().toString().endsWith("String"))
                    sql.append(" " + field.getName() + " like " + "'%" + keyword + "%'" + " or");
            }
            String sqlStr = sql.substring(0, sql.length() - 2) + " limit " + start + "," + count;
            logger.info(sqlStr);
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    if(field.getType().toString().endsWith("String")) {
                        String value = rs.getString(field.getName());
                        // set 注入
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), String.class);
                        method0.invoke(t, value);
                    }
                    else if(field.getType().toString().endsWith("Integer")) {
                        Integer value = rs.getInt(field.getName());
                        rs.getInt(field.getName());
                        Method method0 = clazz.getDeclaredMethod("set" +
                                Character.toUpperCase(field.getName().charAt(0)) +
                                field.getName().substring(1), Integer.class);
                        method0.invoke(t, value);
                    }
                }
                list.add(t);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

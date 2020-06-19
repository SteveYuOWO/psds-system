package com.littlepage.entity;

public class Root {
    private Integer id;

    private String name;

    private String sex;

    private String passwd;

    public Root() {
    }

    public Root(Integer id, String name, String sex, String passwd) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.passwd = passwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}

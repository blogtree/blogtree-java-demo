package org.blogtree.java.demo.jdk.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserVo implements Cloneable, Serializable {

    private static final long serialVersionUID = 5357091716443212892L;

    private Integer id;

    private String name;


    public UserVo() {

    }

    public UserVo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 实现浅克隆
     */
    public UserVo clone() {
        UserVo employee = null;
        try {
            employee = (UserVo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

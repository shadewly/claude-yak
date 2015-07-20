package com.shine.his.usrcenter.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by claude on 15-6-11.
 */
public class User implements Serializable {
    private String name;
    private String email;
    private Integer id;
    private String password;
    private Integer createId;
    private Integer updateId;
    private Date createDate;
    private Date updateDate;

    public User() {
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getName().equals(user.getName())) return false;
        return getEmail().equals(user.getEmail());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getId();
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}

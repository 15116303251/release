package com.example.shiro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SysPermission implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    //名称
    private String name;

    //资源类型
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;

    //资源路径
    private String url;

    //权限字符串，menu例子：role:*,button例子：role:create,role:update,role:delete,role:view
    private String permission;

    //父编号
    private Long parentId;

    private Boolean available=Boolean.FALSE;

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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}

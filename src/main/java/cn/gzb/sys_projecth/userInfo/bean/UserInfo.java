package cn.gzb.sys_projecth.userInfo.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer age;
    @Column(name = "name",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;
}

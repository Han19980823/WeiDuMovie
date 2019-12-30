package com.bw.movie.green.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * auto：王飞 on 2019/9/7 15:53
 * function：
 */
@Entity
public class WechatLoginBean {
    @Id(autoincrement = true)
    private Long id;
    String nickName;
    String phone;
    String birthday;
    String sex;
    String lastLoginTime;
    String headPic;
    @Generated(hash = 615081760)
    public WechatLoginBean(Long id, String nickName, String phone, String birthday,
            String sex, String lastLoginTime, String headPic) {
        this.id = id;
        this.nickName = nickName;
        this.phone = phone;
        this.birthday = birthday;
        this.sex = sex;
        this.lastLoginTime = lastLoginTime;
        this.headPic = headPic;
    }
    @Generated(hash = 2146510058)
    public WechatLoginBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getLastLoginTime() {
        return this.lastLoginTime;
    }
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String getHeadPic() {
        return this.headPic;
    }
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
   
    
}

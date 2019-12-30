package com.bw.movie.green.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * auto：王飞 on 2019/9/6 14:31
 * function：
 */
@Entity
public class LoginDaoBean {
    @Id(autoincrement = true)
    private Long mId;
    private String email;
    private String headPic;
    private int id;
    private long lastLoginTime;
    private String nickName;
    private int sex;
    @Generated(hash = 856840359)
    public LoginDaoBean(Long mId, String email, String headPic, int id,
            long lastLoginTime, String nickName, int sex) {
        this.mId = mId;
        this.email = email;
        this.headPic = headPic;
        this.id = id;
        this.lastLoginTime = lastLoginTime;
        this.nickName = nickName;
        this.sex = sex;
    }
    @Generated(hash = 420063402)
    public LoginDaoBean() {
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHeadPic() {
        return this.headPic;
    }
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getLastLoginTime() {
        return this.lastLoginTime;
    }
    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
   

}

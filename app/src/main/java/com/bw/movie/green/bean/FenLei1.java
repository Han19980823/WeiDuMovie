package com.bw.movie.green.bean;

import com.bw.movie.bean.RegionListBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：Han98
 * 创建时间：2019/12/14
 * 描述：TODO
 * 最近修改：2019/12/14 10:34 modify by liujc
 */
@Entity
public class FenLei1 {
    @Id(autoincrement = true)
    private long id;
    private int regionId;
    private String regionName;
    @Generated(hash = 1253552235)
    public FenLei1(long id, int regionId, String regionName) {
        this.id = id;
        this.regionId = regionId;
        this.regionName = regionName;
    }
    @Generated(hash = 616059073)
    public FenLei1() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getRegionId() {
        return this.regionId;
    }
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    public String getRegionName() {
        return this.regionName;
    }
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}

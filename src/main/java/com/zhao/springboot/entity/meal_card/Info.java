package com.zhao.springboot.entity.meal_card;

public class Info {

    private long id;
    private int number;
    private String name;
    private long entranceTime;
    private long createTime;
    private long updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(long entranceTime) {
        this.entranceTime = entranceTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", entranceTime=" + entranceTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

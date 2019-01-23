package com.zhao.springboot.entity.meal_card;

public class Consume {

    private long id;
    private float money;

    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

    private long consumeTime;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Consume{" +
                "id=" + id +
                ", money=" + money +
                ", consumeTime=" + consumeTime +
                ", number=" + number +
                '}';
    }
}

package com.mavsforlife.victor.mylab.network.aikucun.model;

/**
 * Created by victor on 2017/11/22.
 * Email: wwmdirk@gmail.com
 */
public class LivingBean {
    /**
     * flag : 0
     * max : 37
     * min : 10
     * period : 30
     */

    private int flag;
    private int max;
    private int min;
    private int period;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}

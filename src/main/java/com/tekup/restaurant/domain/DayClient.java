package com.tekup.restaurant.domain;

import com.tekup.restaurant.model.Client;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DayClient implements Serializable, Comparable<DayClient>{
    private int day;
    private Long dayUse;

    public DayClient() {
    }

    public DayClient(int day, Long dayUse) {
        this.day = day;
        this.dayUse = dayUse;
    }

     

    public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Long getDayUse() {
        return dayUse;
    }

    public void setDayUse(Long dayUse) {
        this.dayUse = dayUse;
    }

    @Override
    public int compareTo(DayClient dayClient) {
        if (this.getDayUse() > dayClient.getDayUse()) {
            return 1;
        }
        else if (this.getDayUse()  < dayClient.getDayUse()) {
            return  -1;
        }
        return 0;
    }
}

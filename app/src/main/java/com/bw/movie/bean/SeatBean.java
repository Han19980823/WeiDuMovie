package com.bw.movie.bean;


public class SeatBean {
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public SeatBean(int seats, int status) {
        this.seats = seats;
        this.status = status;
    }

    private int seats;
    private int status;
}

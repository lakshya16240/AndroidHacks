package com.cb.android.badminton;

/**
 * Created by GhanshamBansal on 11/06/17.
 */

public class badminton {
    String player;
    String country;
    String record;
    int rank;

    public badminton(String player, String country, String record, int rank) {
        this.player = player;
        this.country = country;
        this.record = record;
        this.rank = rank;
    }

    public String getPlayer() {
        return player;
    }

    public String getCountry() {
        return country;
    }

    public String getRecord() {
        return record;
    }

    public int getRank() {
        return rank;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

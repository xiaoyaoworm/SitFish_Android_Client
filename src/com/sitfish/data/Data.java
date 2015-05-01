package com.sitfish.data;

import java.util.List;

/**
 * Created by leon on 5/1/15.
 */
public class Data {
    public String code;
    public Equalizers equalizers;
    public List<Song> songs;
    public String status_code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Equalizers getEqualizers() {
        return equalizers;
    }

    public void setEqualizers(Equalizers equalizers) {
        this.equalizers = equalizers;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }
}

package com.sitfish.data;

/**
 * Created by leon on 5/1/15.
 */
public class Audition {

    public long bitrate;
    public long dfsId;
    public String extension;
    public long id;
    public String name;
    public long playtime;
    public long size;
    public long sr;
    public double volumeDelta;

    public long getBitrate() {
        return bitrate;
    }

    public void setBitrate(long bitrate) {
        this.bitrate = bitrate;
    }

    public long getDfsId() {
        return dfsId;
    }

    public void setDfsId(long dfsId) {
        this.dfsId = dfsId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPlaytime() {
        return playtime;
    }

    public void setPlaytime(long playtime) {
        this.playtime = playtime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSr() {
        return sr;
    }

    public void setSr(long sr) {
        this.sr = sr;
    }

    public double getVolumeDelta() {
        return volumeDelta;
    }

    public void setVolumeDelta(double volumeDelta) {
        this.volumeDelta = volumeDelta;
    }
}

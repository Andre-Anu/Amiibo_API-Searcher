package org.example.amiibo_api;

public class releaseDate {
    public String au;
    public String eu;
    public String jp;
    public String na;

    public String getAu() {
        return au;
    }
    public String getEu() {
        return eu;
    }
    public String getJp() {
        return jp;
    }
    public String getNa() {
        return na;
    }

    public String toString()
    {
        return String.format("AU (%s)\nEU (%s)\nJP (%s)\nNA (%s)",au,eu,jp,na);
    }
}

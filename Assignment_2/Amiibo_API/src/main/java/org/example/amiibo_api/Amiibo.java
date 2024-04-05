package org.example.amiibo_api;

public class Amiibo implements Comparable<Amiibo>{
    public String amiiboSeries;
    public String character;
    public String gameSeries;
    public String head;
    public String image;
    public String name;
    public releaseDate release;
    public String tail;
    public String type;

    // Getters and setters

    public String getAmiiboSeries() { return amiiboSeries; }

    public String getCharacter() { return character; }

    public String getGameSeries() { return gameSeries; }

    public String getHead() { return head; }

    public String getImage() { return image; }

    public String getName() { return name; }

    public releaseDate getRelease() { return release; }
    public String getTail() { return tail; }

    public String getType() { return type; }

    public String toString() { return String.format("%s (%s)",name,gameSeries); }
    @Override
    public int compareTo(Amiibo o) { return this.getName().compareTo(o.getName()); }
}

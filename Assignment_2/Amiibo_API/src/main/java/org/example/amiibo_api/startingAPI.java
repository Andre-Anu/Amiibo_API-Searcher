package org.example.amiibo_api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class startingAPI {
    @SerializedName("amiibo")
    public ArrayList<Amiibo> amiibos;

    public ArrayList<Amiibo> getAmiibos() {
        return amiibos;
    }
}

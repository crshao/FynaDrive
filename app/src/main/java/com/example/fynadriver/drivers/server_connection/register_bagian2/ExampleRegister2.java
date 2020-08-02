package com.example.fynadriver.drivers.server_connection.register_bagian2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleRegister2 {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("REG2_PASSWORD")
    @Expose
    private String rEG2PASSWORD;
    @SerializedName("REG2_KENDARAAN")
    @Expose
    private String rEG2KENDARAAN;
    @SerializedName("REG2_PLAT_NOMOR")
    @Expose
    private String rEG2PLATNOMOR;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getREG2PASSWORD() {
        return rEG2PASSWORD;
    }

    public void setREG2PASSWORD(String rEG2PASSWORD) {
        this.rEG2PASSWORD = rEG2PASSWORD;
    }

    public String getREG2KENDARAAN() {
        return rEG2KENDARAAN;
    }

    public void setREG2KENDARAAN(String rEG2KENDARAAN) {
        this.rEG2KENDARAAN = rEG2KENDARAAN;
    }

    public String getREG2PLATNOMOR() {
        return rEG2PLATNOMOR;
    }

    public void setREG2PLATNOMOR(String rEG2PLATNOMOR) {
        this.rEG2PLATNOMOR = rEG2PLATNOMOR;
    }
}

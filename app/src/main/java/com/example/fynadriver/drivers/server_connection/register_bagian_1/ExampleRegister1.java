package com.example.fynadriver.drivers.server_connection.register_bagian_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleRegister1 {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("REG1_NAMA")
    @Expose
    private String rEG1NAMA;
    @SerializedName("REG1_TTL")
    @Expose
    private String rEG1TTL;
    @SerializedName("REG1_JENIS_KEL")
    @Expose
    private String rEG1JENISKEL;
    @SerializedName("REG1_PHONE")
    @Expose
    private String rEG1PHONE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getREG1NAMA() {
        return rEG1NAMA;
    }

    public void setREG1NAMA(String rEG1NAMA) {
        this.rEG1NAMA = rEG1NAMA;
    }

    public String getREG1TTL() {
        return rEG1TTL;
    }

    public void setREG1TTL(String rEG1TTL) {
        this.rEG1TTL = rEG1TTL;
    }

    public String getREG1JENISKEL() {
        return rEG1JENISKEL;
    }

    public void setREG1JENISKEL(String rEG1JENISKEL) {
        this.rEG1JENISKEL = rEG1JENISKEL;
    }

    public String getREG1PHONE() {
        return rEG1PHONE;
    }

    public void setREG1PHONE(String rEG1PHONE) {
        this.rEG1PHONE = rEG1PHONE;
    }

}

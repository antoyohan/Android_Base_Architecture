package com.example.ando.android_base_architecture.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Docs extends RealmObject {
    @SerializedName("ORDERNUM_s")
    @Expose
    private String oRDERNUMS;
    @SerializedName("OUNUM_s")
    @Expose
    private String oUNUMS;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("CONNECTIONTYPE_s")
    @Expose
    private String cONNECTIONTYPES;
    @SerializedName("SERIALNUM_s")
    @Expose
    private String sERIALNUMS;
    @SerializedName("ASSETROWID_s")
    @Expose
    private String aSSETROWIDS;
    @SerializedName("DATECOL_dt")
    @Expose
    private String dATECOLDt;
    @SerializedName("NAMEREF_s")
    @Expose
    private String nAMEREFS;
    @SerializedName("REGDATE_dt")
    @Expose
    private String rEGDATEDt;
    @SerializedName("ROOTASSET_s")
    @Expose
    private String rOOTASSETS;
    @SerializedName("DESCTEXT_s")
    @Expose
    private String dESCTEXTS;
    @SerializedName("BCN_s")
    @Expose
    private String bCNS;
    @SerializedName("ROW_ID_s")
    @Expose
    private String rOWIDS;
    @SerializedName("EXTNAME_s")
    @Expose
    private String eXTNAMES;
    @SerializedName("ASSETNUM_s")
    @Expose
    private String aSSETNUMS;
    @SerializedName("PRIMARYID_s")
    @Expose
    private String pRIMARYIDS;
    @SerializedName("ROOTSERVICEID_s")
    @Expose
    private String rOOTSERVICEIDS;
    @SerializedName("DATECOL1_s")
    @Expose
    private String dATECOL1S;
    @SerializedName("ADDRESS_s")
    @Expose
    private String aDDRESSS;
    @SerializedName("OCN_s")
    @Expose
    private String oCNS;
    @SerializedName("REGDATE1_s")
    @Expose
    private String rEGDATE1S;
    @SerializedName("LEGALNAME_s")
    @Expose
    private String lEGALNAMES;
    @SerializedName("_version_")
    @Expose
    private Double version;

    public String getORDERNUMS() {
        return oRDERNUMS;
    }

    public void setORDERNUMS(String oRDERNUMS) {
        this.oRDERNUMS = oRDERNUMS;
    }

    public String getOUNUMS() {
        return oUNUMS;
    }

    public void setOUNUMS(String oUNUMS) {
        this.oUNUMS = oUNUMS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCONNECTIONTYPES() {
        return cONNECTIONTYPES;
    }

    public void setCONNECTIONTYPES(String cONNECTIONTYPES) {
        this.cONNECTIONTYPES = cONNECTIONTYPES;
    }

    public String getSERIALNUMS() {
        return sERIALNUMS;
    }

    public void setSERIALNUMS(String sERIALNUMS) {
        this.sERIALNUMS = sERIALNUMS;
    }

    public String getASSETROWIDS() {
        return aSSETROWIDS;
    }

    public void setASSETROWIDS(String aSSETROWIDS) {
        this.aSSETROWIDS = aSSETROWIDS;
    }

    public String getDATECOLDt() {
        return dATECOLDt;
    }

    public void setDATECOLDt(String dATECOLDt) {
        this.dATECOLDt = dATECOLDt;
    }

    public String getNAMEREFS() {
        return nAMEREFS;
    }

    public void setNAMEREFS(String nAMEREFS) {
        this.nAMEREFS = nAMEREFS;
    }

    public String getREGDATEDt() {
        return rEGDATEDt;
    }

    public void setREGDATEDt(String rEGDATEDt) {
        this.rEGDATEDt = rEGDATEDt;
    }

    public String getROOTASSETS() {
        return rOOTASSETS;
    }

    public void setROOTASSETS(String rOOTASSETS) {
        this.rOOTASSETS = rOOTASSETS;
    }

    public String getDESCTEXTS() {
        return dESCTEXTS;
    }

    public void setDESCTEXTS(String dESCTEXTS) {
        this.dESCTEXTS = dESCTEXTS;
    }

    public String getBCNS() {
        return bCNS;
    }

    public void setBCNS(String bCNS) {
        this.bCNS = bCNS;
    }

    public String getROWIDS() {
        return rOWIDS;
    }

    public void setROWIDS(String rOWIDS) {
        this.rOWIDS = rOWIDS;
    }

    public String getEXTNAMES() {
        return eXTNAMES;
    }

    public void setEXTNAMES(String eXTNAMES) {
        this.eXTNAMES = eXTNAMES;
    }

    public String getASSETNUMS() {
        return aSSETNUMS;
    }

    public void setASSETNUMS(String aSSETNUMS) {
        this.aSSETNUMS = aSSETNUMS;
    }

    public String getPRIMARYIDS() {
        return pRIMARYIDS;
    }

    public void setPRIMARYIDS(String pRIMARYIDS) {
        this.pRIMARYIDS = pRIMARYIDS;
    }

    public String getROOTSERVICEIDS() {
        return rOOTSERVICEIDS;
    }

    public void setROOTSERVICEIDS(String rOOTSERVICEIDS) {
        this.rOOTSERVICEIDS = rOOTSERVICEIDS;
    }

    public String getDATECOL1S() {
        return dATECOL1S;
    }

    public void setDATECOL1S(String dATECOL1S) {
        this.dATECOL1S = dATECOL1S;
    }

    public String getADDRESSS() {
        return aDDRESSS;
    }

    public void setADDRESSS(String aDDRESSS) {
        this.aDDRESSS = aDDRESSS;
    }

    public String getOCNS() {
        return oCNS;
    }

    public void setOCNS(String oCNS) {
        this.oCNS = oCNS;
    }

    public String getREGDATE1S() {
        return rEGDATE1S;
    }

    public void setREGDATE1S(String rEGDATE1S) {
        this.rEGDATE1S = rEGDATE1S;
    }

    public String getLEGALNAMES() {
        return lEGALNAMES;
    }

    public void setLEGALNAMES(String lEGALNAMES) {
        this.lEGALNAMES = lEGALNAMES;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

}

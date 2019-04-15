package com.example.ando.android_base_architecture.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DocResponse {

    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {

        @SerializedName("docs")
        private List<Docs> docList;


        public List<Docs> getDocList() {
            return docList;
        }

        public void setDocList(List<Docs> docList) {
            this.docList = docList;
        }
    }
}

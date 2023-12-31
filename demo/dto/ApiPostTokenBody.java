package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiPostTokenBody {
    @JsonProperty(value = "access_token")
    private String access_token;
    @JsonProperty(value = "scope")
    private String scope;
    @JsonProperty(value = "expires_in")
    private String expires_in;
    @JsonProperty(value = "token_type")
    private String token_type;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}

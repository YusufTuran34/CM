package com.model.ReqRes.user;

import com.model.ReqRes.ResponseHeader;
import com.model.User;

public class GetUserResponse {
    private User user;
    private ResponseHeader responseHeader;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

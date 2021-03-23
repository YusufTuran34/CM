package com.model.ReqRes.page;

import com.model.Page;
import com.model.ReqRes.ResponseHeader;

public class GetPageResponse {
    private ResponseHeader responseHeader;
    private Page page;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

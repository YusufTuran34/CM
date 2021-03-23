package com.model.ReqRes.blog;

import com.model.Blog;
import com.model.ReqRes.ResponseHeader;

public class GetBlogResponse {
    private ResponseHeader responseHeader;
    private Blog blog;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}

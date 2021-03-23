package com.model.ReqRes.page;

import com.model.Blog;
import com.model.ReqRes.ResponseHeader;

import java.util.List;

public class GetPageSmallBlogResponse {
    private ResponseHeader responseHeader;
    private List<Blog> blogList;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}

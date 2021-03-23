package com.model.ReqRes.blog;

import com.model.Content;

public class DeleteBlogRequest {
    private String categoryUrl;
    private String blogId;

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}

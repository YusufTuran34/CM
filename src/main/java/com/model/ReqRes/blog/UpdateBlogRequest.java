package com.model.ReqRes.blog;

import com.model.Blog;
import com.model.Content;

public class UpdateBlogRequest {
    private String categoryUrl;
    private Blog blog;

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}

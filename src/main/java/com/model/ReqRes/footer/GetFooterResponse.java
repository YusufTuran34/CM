package com.model.ReqRes.footer;

import com.model.Blog;
import com.model.Content;
import com.model.SocialMedia;

import java.util.List;

public class GetFooterResponse {
    private List<Blog> blogList;
    private SocialMedia socialMedia;

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }
}

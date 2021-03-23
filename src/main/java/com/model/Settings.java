package com.model;

public class Settings {
    private Img logo;
    private Img favIcon;
    private String analyticsId;
    private String tagManagerId;
    private Seo seo;
    private SocialMedia socialMedia;

    public Img getLogo() {
        return logo;
    }

    public void setLogo(Img logo) {
        this.logo = logo;
    }

    public Img getFavIcon() {
        return favIcon;
    }

    public void setFavIcon(Img favIcon) {
        this.favIcon = favIcon;
    }

    public String getAnalyticsId() {
        return analyticsId;
    }

    public void setAnalyticsId(String analyticsId) {
        this.analyticsId = analyticsId;
    }

    public String getTagManagerId() {
        return tagManagerId;
    }

    public void setTagManagerId(String tagManagerId) {
        this.tagManagerId = tagManagerId;
    }

    public Seo getSeo() {
        return seo;
    }

    public void setSeo(Seo seo) {
        this.seo = seo;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }
}

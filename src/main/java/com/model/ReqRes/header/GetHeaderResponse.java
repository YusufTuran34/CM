package com.model.ReqRes.header;

import com.model.NavbarItem;
import com.model.ReqRes.ResponseHeader;
import com.model.Seo;

import java.util.List;

public class GetHeaderResponse {
    private ResponseHeader responseHeader;
    private List<NavbarItem> navbarItemList;
    private Seo seo;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public List<NavbarItem> getNavbarItemList() {
        return navbarItemList;
    }

    public void setNavbarItemList(List<NavbarItem> navbarItemList) {
        this.navbarItemList = navbarItemList;
    }

    public Seo getSeo() {
        return seo;
    }

    public void setSeo(Seo seo) {
        this.seo = seo;
    }
}

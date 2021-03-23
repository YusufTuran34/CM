package com.model.ReqRes.header;

import com.model.NavbarItem;

import java.util.List;

public class UpdateHeaderRequest {
    private List<NavbarItem> navbarItemList;

    public List<NavbarItem> getNavbarItemList() {
        return navbarItemList;
    }

    public void setNavbarItemList(List<NavbarItem> navbarItemList) {
        this.navbarItemList = navbarItemList;
    }
}

package com.model;

import java.util.HashMap;

public class Content {
    private String html_desktop;
    private HashMap usedComponent;
    private String html_mini;

    public String getHtml_desktop() {
        return html_desktop;
    }

    public void setHtml_desktop(String html_desktop) {
        this.html_desktop = html_desktop;
    }

    public String getHtml_mini() {
        return html_mini;
    }

    public void setHtml_mini(String html_mini) {
        this.html_mini = html_mini;
    }

    public HashMap getUsedComponent() {
        return usedComponent;
    }

    public void setUsedComponent(HashMap usedComponent) {
        this.usedComponent = usedComponent;
    }
}

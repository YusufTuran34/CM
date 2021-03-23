package com.model.ReqRes.settings;

import com.model.ReqRes.ResponseHeader;
import com.model.Settings;

public class GetSettingsResponse {
    private ResponseHeader responseHeader;
    private Settings settings;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}

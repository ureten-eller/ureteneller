package com.ureteneller.app;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 🔹 Reklam SDK YOK
        // 🔹 Sadece Capacitor WebView çalışır
    }

    @Override
    public void onBackPressed() {
        if (getBridge() != null && getBridge().getWebView() != null) {
            getBridge().getWebView().evaluateJavascript(
                "if (window.history.length > 1) { window.history.back(); } else { window.CapacitorApp.exitApp(); }",
                null
            );
        } else {
            super.onBackPressed();
        }
    }
}

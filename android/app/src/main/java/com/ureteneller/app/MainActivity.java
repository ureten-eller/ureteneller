package com.ureteneller.app;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

// 🔥 Appodeal'ın yeni API importları
import com.appodeal.ads.Appodeal;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ⭐ Yeni Appodeal API – initialize callback YOK
        Appodeal.initialize(
                this,
                "b0912cff2b315c94e3857c3514645163fe6356a2e7aa9f4c",  // App Key
                Appodeal.BANNER // yalnız banner
        );

        // ⭐ Alt sabit banner göster
        Appodeal.show(this, Appodeal.BANNER_BOTTOM);
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

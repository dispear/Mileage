package com.example.mileage;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class KakaoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 카카오 SDK 사용을 위해 초기화
        KakaoSdk.init(this, "49cfa7f550afa77b33051786bd934cee");
    }
}

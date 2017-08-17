package com.example.a58.tinker.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * 描述：对Tinker所有api做一层封装
 * 作者：zjy on 2017/8/15 16:24
 */

public class TinkerManager {
    private static boolean isInstalled = false;
    private static ApplicationLike mAppLike;

    /**
     * 完成Tinker初始化
     *
     * @param applicationLike
     */
    public static void installTiner(ApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }
        TinkerInstaller.install(applicationLike);
        isInstalled = true;
    }
    /**
     * 完成pach文件加载
     */
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    public static Context getApplicationContext() {
        if (mAppLike != null) {
            return mAppLike.getApplication();
        }
        return null;
    }
}

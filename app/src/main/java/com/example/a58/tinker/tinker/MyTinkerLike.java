package com.example.a58.tinker.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * 描述：
 * 作者：zjy on 2017/8/15 16:33
 */
@DefaultLifeCycle(application = ".MyTinkerApplication",
        /**
         * **
         * 支持的文件类型
         * ShareConstants.TINKERDISABLE:不支持任何类型的文件
         * ShareConstants.TINKERDEXONLY:只支持dex文件
         * ShareConstants.TINKERLIBRARYONLY:只支持library文件
         * ShareConstants.TINKERDEXANDLIBRARY:只支持dex与res的修改
         * ShareConstants.TINKERENABLEALL:支持任何类型的文件，也是我们通常的设置的模式
        */
        flags = ShareConstants.TINKER_ENABLE_ALL,

        /**
         * 是否每次都校验补丁包的MD5
        */
        loadVerifyFlag = false)
public class MyTinkerLike extends ApplicationLike {
    public MyTinkerLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //使应用支持分包
        MultiDex.install(base);
        TinkerManager.installTiner(this);
    }
}

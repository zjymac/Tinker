package com.example.a58.tinker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a58.tinker.tinker.TinkerManager;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = ".apk";
    private String mPatchDir;
    @Bind(R.id.tv1)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        File file = new File(mPatchDir);
        if (file == null || !file.exists()) {
            file.mkdirs();
        }

    }

    @OnClick(R.id.tv1)
    public void onClick(View view) {
        loadPatch("");
        Toast.makeText(getApplicationContext(), "sadasd", Toast.LENGTH_SHORT).show();
    }

    private void loadPatch(String path) {
        TinkerManager.loadPatch(getPatchName());
    }

    private String getPatchName() {
        return mPatchDir.concat("zjy").concat(FILE_NAME);
    }
}

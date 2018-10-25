package com.example.nia.skilltest;

import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.camera2.*;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.eightbitlab.supportrenderscriptblur.SupportRenderScriptBlur;
import com.example.nia.skilltest.custom_views.camera.CameraSourcePreview;

import butterknife.BindView;
import butterknife.ButterKnife;
import eightbitlab.com.blurview.BlurView;
import jp.wasabeef.blurry.Blurry;


/**
 * Created by a2 on 04.12.17.
 */

public class CameraContact extends AppCompatActivity {

    ActionBar actionBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.root)
    ViewGroup root;
    private Camera mCamera;
    private CameraSourcePreview mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(null);
        }

        try {
            mCamera = Camera.open();//you can use open(int) to use different cameras
        } catch (Exception e) {
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if (mCamera != null) {
            mPreview = new CameraSourcePreview(this, mCamera);//create a SurfaceView to show camera data
            FrameLayout camera_view = (FrameLayout) findViewById(R.id.camera_view);
            camera_view.addView(mPreview);//add the SurfaceView to the layout
        }
        //setupBlurView();
    }

    private void setupBlurView() {
        final float radius = 25f;
        final float minBlurRadius = 10f;
        final float step = 4f;

//        //set background, if your root layout doesn't have one
//        final Drawable windowBackground = getWindow().getDecorView().getBackground();
////        final BlurView.ControllerSettings topViewSettings = fv.setupWith(root);
////        topViewSettings.blurAlgorithm(new SupportRenderScriptBlur(this)).blurRadius(radius);
//
//        Blurry.with(CameraContact.this)
//                .radius(225)
//                .sampling(100)
//                .async()
//                .animate(500)
//                .onto((ViewGroup) findViewById(R.id.root));

//        final BlurView.ControllerSettings topViewSettings = fv.setupWith(root)
//                .windowBackground(windowBackground)
//                .blurAlgorithm(new SupportRenderScriptBlur(this))
//                .blurRadius(radius);

//        final BlurView.ControllerSettings bottomViewSettings = bottomBlurView.setupWith(root)
//                .windowBackground(windowBackground)
//                .blurAlgorithm(new SupportRenderScriptBlur(this))
//                .blurRadius(radius);

        int initialProgress = (int) (radius * step);
    }

}



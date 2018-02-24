package com.example.android.musicalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 *
 * Created by Spi_ros on 23/02/2018.
 */

public class LeftActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left);

        gestureObject = new GestureDetectorCompat(this, new LeftActivity.LearnGesture());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling (MotionEvent event1, MotionEvent event2,
                                float velocityX, float velocityY) {
            if (event2.getX() < event1.getX()) {

                Intent intent = new Intent(LeftActivity.this, MusicalActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left_a, R.anim.right_to_left_b);

            }
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        //your code when back button pressed

        Intent intent = new Intent(LeftActivity.this, MusicalActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left_a, R.anim.right_to_left_b);
    }
}

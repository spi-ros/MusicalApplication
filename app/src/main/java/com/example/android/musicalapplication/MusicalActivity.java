package com.example.android.musicalapplication;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MusicalActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musical);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
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
            if (event2.getX() > event1.getX()) {

                Intent intent = new Intent(MusicalActivity.this, LeftActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_to_right_a, R.anim.left_to_right_b);

            } else if (event2.getX() < event1.getX()) {

                Intent intent = new Intent(MusicalActivity.this, RightActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left_a, R.anim.right_to_left_b);


            }
            return true;
        }
    }
}

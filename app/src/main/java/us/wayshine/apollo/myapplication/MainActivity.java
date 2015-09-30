package us.wayshine.apollo.myapplication;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showView(R.id.t0, 300, 1);
        showView(R.id.t1, 400, 1);
        showView(R.id.t2, 500, 1);
        showView(R.id.t3, 900, 1);
        showView(R.id.t4, 1000, 1);
        showView(R.id.t5, 600, 1);
        showView(R.id.t6, 1100, 1);
        showView(R.id.t7, 1300, 1);
        showView(R.id.t8, 1200, 1);
        showView(R.id.t9, 1400, 1);
        showView(R.id.t10, 800, 1);
        showView(R.id.t11, 700, 1);
        showView(R.id.click, 1600, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonClick(View v) {
        showHello();
    }

    private void showHello() {
        Intent intent = new Intent(this, HelloActivity.class);

        Pair<View, String> p0 = Pair.create(findViewById(R.id.t0), "t0");
        Pair<View, String> p1 = Pair.create(findViewById(R.id.t1), "t1");
        Pair<View, String> p2 = Pair.create(findViewById(R.id.t2), "t2");
        Pair<View, String> p3 = Pair.create(findViewById(R.id.t3), "t3");
        Pair<View, String> p4 = Pair.create(findViewById(R.id.t4), "t4");
        Pair<View, String> p5 = Pair.create(findViewById(R.id.t5), "t5");
        Pair<View, String> p6 = Pair.create(findViewById(R.id.t6), "t6");
        Pair<View, String> p7 = Pair.create(findViewById(R.id.t7), "t7");
        Pair<View, String> p8 = Pair.create(findViewById(R.id.t8), "t8");
        Pair<View, String> p9 = Pair.create(findViewById(R.id.t9), "t9");
        Pair<View, String> p10 = Pair.create(findViewById(R.id.t10), "t10");
        Pair<View, String> p11 = Pair.create(findViewById(R.id.t11), "t11");

        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        startActivity(intent, options.toBundle());
    }

    private void showView(int viewId, int delay, int b) {
        View myView = findViewById(viewId);
        final int behavior = b;

        if(android.os.Build.VERSION.SDK_INT >= 21) {

            float x = myView.getX();
            float y = myView.getY();

            Path path1 = new Path();
            Path path2 = new Path();

            if(behavior == 0) {
                path1.moveTo(x, y + 100);
                path1.rLineTo(0, -100);
                path2.moveTo(0, 0);
                path2.lineTo(1, 1);
            }
            else if(behavior == 1) {
                path1.moveTo(x, y);
                path1.rLineTo(0, 0);
                path2.moveTo(1, 1);
                path2.lineTo(1, 1);
            }

            ObjectAnimator mAnimator1, mAnimator2, mAnimator3;
            if(behavior == 0) {
                mAnimator1 = ObjectAnimator.ofFloat(myView, View.X, View.Y, path1);
                mAnimator2 = ObjectAnimator.ofFloat(myView, View.SCALE_X, View.SCALE_Y, path2);
                mAnimator1.setInterpolator(new BounceInterpolator());
                mAnimator2.setInterpolator(new BounceInterpolator());
                mAnimator1.setDuration(300);
                mAnimator2.setDuration(300);
                mAnimator1.setStartDelay(delay);
                mAnimator2.setStartDelay(delay);
                //mAnimator1.start();
                mAnimator2.start();
            }

                mAnimator3 = ObjectAnimator.ofFloat(myView, "alpha", myView.getAlpha(), 1);
                mAnimator3.setDuration(300);
                mAnimator3.setStartDelay(delay);
                mAnimator3.start();
        }
    }
}

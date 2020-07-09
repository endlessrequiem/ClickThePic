package austinwhite.tech.clickthepic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

//TODO: MAKE SURE BUTTONS SPAWN WITHIN THE LAYOUT
//TODO: GRAPHICS


public class GameActivity extends MainActivity {

    ImageButton gameObject;
    ImageButton gameObject2;
    ImageButton gameObject3;
    Button refreshDebug;
    TextView score;
    TextView timer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        final int[] a = {1};

        score = findViewById(R.id.score);
        timer = findViewById(R.id.timer);

        final CountDownTimer countDown = new CountDownTimer(6000, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                timer.setText(getString(R.string.timer) + " " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Toast.makeText(getApplicationContext(), "You Lose", Toast.LENGTH_SHORT).show();
                gameObject.setEnabled(false);
                gameObject2.setEnabled(false);
                gameObject3.setEnabled(false);
                refreshDebug.setVisibility(View.VISIBLE);

            }

        }.start();

        refreshDebug = findViewById(R.id.refreshDebug);
        refreshDebug.setVisibility(View.GONE);
        refreshDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
                countDown.cancel();
            }
        });

        gameObject = findViewById(R.id.gameObject);
        gameObject2 = findViewById(R.id.gameObject2);
        gameObject3 = findViewById(R.id.gameObject3);

        spawnButtons();

        gameObject.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int i = a[0]++;
                score.setText(getString(R.string.score) + " " + i);
                gameObject.setVisibility(View.GONE);

                scoreCheck(i, countDown);

            }
        });
        gameObject2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int i = a[0]++;
                score.setText(getString(R.string.score) + " " + i);
                gameObject2.setVisibility(View.GONE);

                scoreCheck(i, countDown);

            }
        });
        gameObject3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int i = a[0]++;
                score.setText(getString(R.string.score) + " " + i);
                gameObject3.setVisibility(View.GONE);

                scoreCheck(i, countDown);

            }
        });


    }

    private void scoreCheck(int i, CountDownTimer countDown) {
        if (i % 3 == 0) {
            spawnButtons();
            gameObject.setEnabled(true);
            gameObject.setVisibility(View.VISIBLE);

            gameObject2.setEnabled(true);
            gameObject2.setVisibility(View.VISIBLE);

            gameObject3.setEnabled(true);
            gameObject3.setVisibility(View.VISIBLE);

            countDown.start();
        } else {
            Log.i("Debug Check", score.getText().toString());
        }

    }

    private void spawnButtons() {
        final DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displaymetrics);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Random R = new Random();
                final float dx = R.nextFloat() * displaymetrics.widthPixels;
                final float dy = R.nextFloat() * displaymetrics.heightPixels;
                gameObject.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(0)
                        .start();

                final float dx2 = R.nextFloat() * displaymetrics.widthPixels;
                final float dy2 = R.nextFloat() * displaymetrics.heightPixels;
                gameObject2.animate()
                        .x(dx2)
                        .y(dy2)
                        .setDuration(0)
                        .start();

                final float dx3 = R.nextFloat() * displaymetrics.widthPixels;
                final float dy3 = R.nextFloat() * displaymetrics.heightPixels;
                gameObject3.animate()
                        .x(dx3)
                        .y(dy3)
                        .setDuration(0)
                        .start();
            }
        });
    }
}



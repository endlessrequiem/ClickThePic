package austinwhite.tech.clickthepic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView titleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AnimationActivity animateThis = new AnimationActivity();
        startButton = findViewById(R.id.startButton);
        titleView = findViewById(R.id.titleView);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(startGame);
                finish();
            }
        });

    }
}
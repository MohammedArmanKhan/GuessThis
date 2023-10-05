package tech.arman.guessthis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeTextWithButtonOne();
    }

    public void changeTextWithButtonOne(){
        final TextView changingText = (TextView) findViewById(R.id.txt1);
        Button changeTextButton = (Button) findViewById(R.id.btn1);

        final TextView changingText2 = (TextView) findViewById(R.id.txt2);
        Button changeTextButton2 = (Button) findViewById(R.id.btn2);

        int randomNum1 = (int)(Math.random() * 100) + 1;
        int randomNum2 = (int)(Math.random() * 100) + 1;

        final RelativeLayout relativeLayout;
        relativeLayout = findViewById(R.id.layoutRelative);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                changingText.setText(String.valueOf(randomNum1));
            }
        });
        changeTextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                changingText2.setText(String.valueOf(randomNum2));
            }
        });
        changingText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View myMethodOne){
                if (randomNum1>randomNum2){
                    relativeLayout.setBackgroundResource(R.color.green);
                    Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
                    // set the color to relative layout
                } else {
                    Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                    relativeLayout.setBackgroundResource(R.color.red);
                }
            }
        });
        changingText2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View myMethodTwo){
                if (randomNum1<randomNum2){
                    relativeLayout.setBackgroundResource(R.color.green);
                    Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                    relativeLayout.setBackgroundResource(R.color.red);
                }
            }
        });
    }
}
package com.dizzay.firebaselage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView condition;
    Button buttonSunny;
    Button buttonFoggy;
    Firebase mFire;
    View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View someView = findViewById(R.id.fuck);

        // Find the root view
        root = someView.getRootView();

        // Set the color
    }

    @Override
    protected void onStart() {
        super.onStart();
        condition = (TextView) findViewById(R.id.textView);
        buttonSunny = (Button) findViewById(R.id.buttonSunny);
        buttonFoggy = (Button) findViewById(R.id.buttonFoggy);
        mFire = new Firebase("https://dizzayup.firebaseio.com/a");
        mFire.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                condition.setText(text);
                try{
                    root.setBackgroundColor(Color.parseColor("#"+text));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        buttonFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFire.setValue("Sunnni");
            }
        });
    }
}

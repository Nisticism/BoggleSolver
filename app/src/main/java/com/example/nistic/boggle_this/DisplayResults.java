package com.example.nistic.boggle_this;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DisplayResults extends MainActivity {
    TextView BoggleResultsView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_boggle_results);
        String boggle_results_final = getIntent().getStringExtra("boggle_results");
        BoggleResultsView = (TextView)findViewById(R.id.boggle_results);
        BoggleResultsView.setText(boggle_results_final);
        BoggleResultsView.setBackgroundColor(Color.parseColor("#88e188"));
        BoggleResultsView.setMovementMethod(new ScrollingMovementMethod());

        final ImageButton oMenu = findViewById(R.id.oMenuID);
        oMenu.setOnClickListener(oMenuListener);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
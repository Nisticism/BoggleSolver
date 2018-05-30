package com.example.nistic.boggle_this;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected TextView mTextMessage;
    ImageButton oMenuID;

    //View v = findViewById(R.id.moreoptions);
    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_boggle:
                    startActivity(new Intent(getBaseContext(), Boggle.class));
                    return true;
                case R.id.navigation_wordsearch:
                    startActivity(new Intent(getBaseContext(), Wordsearch.class));
                    return true;
                case R.id.navigation_ocr:
                    startActivity(new Intent(getBaseContext(), OCR.class));
                    return true;
            }
            return false;
        }
    };

    protected PopupMenu.OnMenuItemClickListener popupListener = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
            if (item.getTitle() == "Help") {
                startActivity(new Intent(getBaseContext(), Help.class));
            }
            return true;
        }
    };

    public View.OnClickListener oMenuListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, oMenuID);
            popupMenu.getMenuInflater().inflate(R.menu.moreoptions, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(popupListener);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oMenuID = findViewById(R.id.oMenuID);

        oMenuID.setOnClickListener(oMenuListener);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}

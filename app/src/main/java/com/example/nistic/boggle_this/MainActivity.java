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
    ImageButton oMenu;
    PopupMenu popupMenu;

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
            switch (item.getItemId()) {
                case R.id.help_screen:
                    startActivity(new Intent(getBaseContext(), Help.class));
                    return true;
                case R.id.about_app:
                    startActivity(new Intent(getBaseContext(), AboutApp.class));
                    return true;
                case R.id.exit_app:
                    Toast.makeText(MainActivity.this, "Until next time!", Toast.LENGTH_SHORT).show();
                    finish();
                    moveTaskToBack(true);
                    return true;

                case R.id.load_boggle:
                    startActivity(new Intent(getBaseContext(), LoadBoggleImage.class));
                    return true;
            }
            return false;
        }
    };

    public View.OnClickListener oMenuListener = new View.OnClickListener() {
        @Override
        public void onClick(View oMenu) {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, oMenu);
            popupMenu.getMenuInflater().inflate(R.menu.moreoptions, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(popupListener);
            popupMenu.show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton oMenu = findViewById(R.id.oMenuID);
        oMenu.setOnClickListener(oMenuListener);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().findItem(R.id.navigation_boggle).setChecked(false);
    }
}

package com.example.nistic.boggle_this;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Boggle5x5 extends MainActivity {
    ImageView camArea;
    Intent intent;
    public  static final int RequestPermissionCode  = 1 ;

    EditText editTexta1;
    EditText editTexta2;
    EditText editTexta3;
    EditText editTexta4;
    EditText editTexta5;

    EditText editTextb1;
    EditText editTextb2;
    EditText editTextb3;
    EditText editTextb4;
    EditText editTextb5;

    EditText editTextc1;
    EditText editTextc2;
    EditText editTextc3;
    EditText editTextc4;
    EditText editTextc5;

    EditText editTextd1;
    EditText editTextd2;
    EditText editTextd3;
    EditText editTextd4;
    EditText editTextd5;

    EditText editTexte1;
    EditText editTexte2;
    EditText editTexte3;
    EditText editTexte4;
    EditText editTexte5;



    String aa1;
    String aa2;
    String aa3;
    String aa4;
    String aa5;

    String bb1;
    String bb2;
    String bb3;
    String bb4;
    String bb5;

    String cc1;
    String cc2;
    String cc3;
    String cc4;
    String cc5;

    String dd1;
    String dd2;
    String dd3;
    String dd4;
    String dd5;

    String ee1;
    String ee2;
    String ee3;
    String ee4;
    String ee5;

    String results;

    ImageView matrixdisplay;
    TextView matrixdisplay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boggle5x5);
        mTextMessage = findViewById(R.id.mTextMessageID);
        mTextMessage.setText(R.string.boggle_message);

        editTexta1 = findViewById(R.id.editTexta1);
        editTexta2 = findViewById(R.id.editTexta2);
        editTexta3 = findViewById(R.id.editTexta3);
        editTexta4 = findViewById(R.id.editTexta4);
        editTexta5 = findViewById(R.id.editTexta5);

        editTextb1 = findViewById(R.id.editTextb1);
        editTextb2 = findViewById(R.id.editTextb2);
        editTextb3 = findViewById(R.id.editTextb3);
        editTextb4 = findViewById(R.id.editTextb4);
        editTextb5 = findViewById(R.id.editTextb5);

        editTextc1 = findViewById(R.id.editTextc1);
        editTextc2 = findViewById(R.id.editTextc2);
        editTextc3 = findViewById(R.id.editTextc3);
        editTextc4 = findViewById(R.id.editTextc4);
        editTextc5 = findViewById(R.id.editTextc5);

        editTextd1 = findViewById(R.id.editTextd1);
        editTextd2 = findViewById(R.id.editTextd2);
        editTextd3 = findViewById(R.id.editTextd3);
        editTextd4 = findViewById(R.id.editTextd4);
        editTextd5 = findViewById(R.id.editTextd5);

        editTexte1 = findViewById(R.id.editTexte1);
        editTexte2 = findViewById(R.id.editTexte2);
        editTexte3 = findViewById(R.id.editTexte3);
        editTexte4 = findViewById(R.id.editTexte4);
        editTexte5 = findViewById(R.id.editTexte5);

        // MAKE ALL CAPS

        editTexta1.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexta2.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexta3.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexta4.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexta5.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        editTextb1.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextb2.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextb3.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextb4.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextb5.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        editTextc1.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextc2.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextc3.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextc4.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextc5.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        editTextd1.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextd2.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextd3.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextd4.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTextd5.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        editTexte1.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexte2.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexte3.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexte4.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editTexte5.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        matrixdisplay = findViewById(R.id.matrixdisplay);
        matrixdisplay.setImageResource(R.drawable.bogglegrid5x5);
        matrixdisplay2 = findViewById(R.id.matrixdisplay2);

        camArea = findViewById(R.id.camArea);
        Button camButton = findViewById(R.id.camButton);
        Button Solve = findViewById(R.id.buttonSolver);
        Button ToggleBoard = findViewById(R.id.button2);
        editTexta1.requestFocus();
        StringGetter();
        String line1 = "  " + aa1 + "  " + aa2 + "  " + aa3 + "  " + aa4 + "  " + aa5;
        String line2 = "  " + bb1 + "  " + bb2 + "  " + bb3 + "  " + bb4 + "  " + bb5;
        String line3 = "  " + cc1 + "  " + cc2 + "  " + cc3 + "  " + cc4 + "  " + cc5;
        String line4 = "  " + dd1 + "  " + dd2 + "  " + dd3 + "  " + dd4 + "  " + dd5;
        String line5 = "  " + ee1 + "  " + ee2 + "  " + ee3 + "  " + ee4 + "  " + ee5;
        matrixdisplay2.setText("\n" + line1+"\n" + line2+"\n" + line3+"\n" + line4+"\n" + line5);

        Button randomgrid = findViewById(R.id.random_grid);
        randomgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomize();
                StringGetter();
                String line1 = "  " + aa1 + "  " + aa2 + "  " + aa3 + "  " + aa4 + "  " + aa5;
                String line2 = "  " + bb1 + "  " + bb2 + "  " + bb3 + "  " + bb4 + "  " + bb5;
                String line3 = "  " + cc1 + "  " + cc2 + "  " + cc3 + "  " + cc4 + "  " + cc5;
                String line4 = "  " + dd1 + "  " + dd2 + "  " + dd3 + "  " + dd4 + "  " + dd5;
                String line5 = "  " + ee1 + "  " + ee2 + "  " + ee3 + "  " + ee4 + "  " + ee5;
                matrixdisplay2.setText("\n" + line1+"\n" + line2+"\n" + line3+"\n" + line4+"\n" + line5);
            }
        });



        Solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringGetter();
                String line1 = "  " + aa1 + "  " + aa2 + "  " + aa3 + "  " + aa4 + "  " + aa5;
                String line2 = "  " + bb1 + "  " + bb2 + "  " + bb3 + "  " + bb4 + "  " + bb5;
                String line3 = "  " + cc1 + "  " + cc2 + "  " + cc3 + "  " + cc4 + "  " + cc5;
                String line4 = "  " + dd1 + "  " + dd2 + "  " + dd3 + "  " + dd4 + "  " + dd5;
                String line5 = "  " + ee1 + "  " + ee2 + "  " + ee3 + "  " + ee4 + "  " + ee5;
                matrixdisplay2.setText("\n" + line1+"\n" + line2+"\n" + line3+"\n" + line4+"\n" + line5);


                // CODE DIRECTLY FROM PC VERSION



                //String[] bogrows = {a1+a2+a3+a4, b1+b2+b3+b4, c1+c2+c3+c4, d1+d2+d3+d4};
                if (aa1.length() != 1 ||  isAlpha(aa1) == false || aa2.length() != 1 ||  isAlpha(aa2) == false || aa3.length() != 1 ||  isAlpha(aa3) == false || aa4.length() != 1 ||   isAlpha(aa4) == false || aa5.length() != 1 ||   isAlpha(aa5) == false || bb1.length() != 1 ||   isAlpha(bb1) == false || bb2.length() != 1 ||   isAlpha(bb2) == false || bb3.length() != 1 ||  isAlpha(bb3) == false || bb4.length() != 1 ||  isAlpha(bb4) == false || bb5.length() != 1 ||  isAlpha(bb5) == false || cc1.length() != 1 ||  isAlpha(cc1) == false || cc2.length() != 1 ||  isAlpha(cc2) == false || cc3.length() != 1 ||  isAlpha(cc3) == false || cc4.length() != 1 ||  isAlpha(cc4) == false || cc5.length() != 1 ||  isAlpha(cc5) == false || dd1.length() != 1 ||  isAlpha(dd1) == false || dd2.length() != 1 ||  isAlpha(dd2) == false || dd3.length() != 1 ||  isAlpha(dd3) == false || dd4.length() != 1 ||  isAlpha(dd4) == false || dd5.length() != 1 ||  isAlpha(dd5) == false || ee1.length() != 1 ||  isAlpha(ee1) == false || ee2.length() != 1 ||  isAlpha(ee2) == false || ee3.length() != 1 ||  isAlpha(ee3) == false || ee4.length() != 1 ||  isAlpha(ee4) == false || ee5.length() != 1 ||  isAlpha(ee5) == false) {
                    Toast.makeText(Boggle5x5.this, "Please enter one letter in each box", Toast.LENGTH_SHORT).show();
                    return;
                }
                String commaboard = aa1+aa2+aa3+aa4+aa5+","+bb1+bb2+bb3+bb4+bb5+","+cc1+cc2+cc3+cc4+cc5+","+dd1+dd2+dd3+dd4+dd5+","+ee1+ee2+ee3+ee4+ee5;
                //String[] allwords;
                //String commaboard2 = "ABCD,RHAO,OSND,OTHA";

                Solver s = new Solver();
                s.generateBoardFromString(commaboard);
                String dictString = "";

                try {
                    dictString = s.dictionaryCreation("dictionary.txt",getApplicationContext());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                File dictfile = new File(getApplicationContext().getFilesDir(), "dictionary2.txt");

                try (PrintWriter out = new PrintWriter(dictfile)) {
                    out.println(dictString);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

//        s.dictionaryCreation();

                // Create a stream to hold the output
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                // IMPORTANT: Save the old System.out!
                PrintStream old = System.out;
                // Tell Java to use your special stream
                System.setOut(ps);

                s.loadDictionary(dictfile.getPath());
                s.run();

                // Put things back
                System.out.flush();
                System.setOut(old);
                // Show what happened
                results = baos.toString();

                //Solver.exit();


                //EXIT CODE FROM PC VERSION

                Intent intent = new Intent(Boggle5x5.this, DisplayResults.class);
                intent.putExtra("boggle_results", results);
                startActivity(intent);
            }
        });

        final ImageButton oMenu = findViewById(R.id.oMenuID);
        oMenu.setOnClickListener(oMenuListener);

        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View camButton) {
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 7);
            }
        });

        ToggleBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ToggleBoard) {
                Intent intent = new Intent(Boggle5x5.this, Boggle.class);
                startActivity(intent);
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().findItem(R.id.navigation_boggle).setChecked(true);
    }

    private static final int REQUEST_TAKE_PHOTO = 1;
    private Bitmap bitmap;

    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }


    public void StringGetter() {
        aa1 = editTexta1.getText().toString();
        aa2 = editTexta2.getText().toString();
        aa3 = editTexta3.getText().toString();
        aa4 = editTexta4.getText().toString();
        aa5 = editTexta5.getText().toString();

        bb1 = editTextb1.getText().toString();
        bb2 = editTextb2.getText().toString();
        bb3 = editTextb3.getText().toString();
        bb4 = editTextb4.getText().toString();
        bb5 = editTextb5.getText().toString();

        cc1 = editTextc1.getText().toString();
        cc2 = editTextc2.getText().toString();
        cc3 = editTextc3.getText().toString();
        cc4 = editTextc4.getText().toString();
        cc5 = editTextc5.getText().toString();

        dd1 = editTextd1.getText().toString();
        dd2 = editTextd2.getText().toString();
        dd3 = editTextd3.getText().toString();
        dd4 = editTextd4.getText().toString();
        dd5 = editTextd5.getText().toString();

        ee1 = editTexte1.getText().toString();
        ee2 = editTexte2.getText().toString();
        ee3 = editTexte3.getText().toString();
        ee4 = editTexte4.getText().toString();
        ee5 = editTexte5.getText().toString();
    }

    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int N = alphabet.length();

    Random r = new Random();
    public void randomize() {
        editTexta1.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexta2.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexta3.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexta4.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexta5.setText(String.valueOf((char)(r.nextInt(26) + 'A')));

        editTextb1.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextb2.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextb3.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextb4.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextb5.setText(String.valueOf((char)(r.nextInt(26) + 'A')));

        editTextc1.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextc2.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextc3.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextc4.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextc5.setText(String.valueOf((char)(r.nextInt(26) + 'A')));

        editTextd1.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextd2.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextd3.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextd4.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTextd5.setText(String.valueOf((char)(r.nextInt(26) + 'A')));

        editTexte1.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexte2.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexte3.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexte4.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editTexte5.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            camArea.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(Boggle5x5.this,
                Manifest.permission.CAMERA))
        {

            //Toast.makeText(Boggle.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_SHORT).show();

        } else {

            ActivityCompat.requestPermissions(Boggle5x5.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    //Toast.makeText(Boggle.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(Boggle5x5.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}
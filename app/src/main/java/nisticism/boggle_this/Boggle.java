package nisticism.boggle_this;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
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
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;

import nisticism.boggle_this.R;

import static android.app.PendingIntent.getActivity;

public class Boggle extends MainActivity {
    private ImageView camArea;
    Intent intent;
    public  static final int RequestPermissionCode  = 1 ;

    EditText editText;
    EditText editText1;
    EditText editText2;
    EditText editText3;

    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;

    EditText editText8;
    EditText editText9;
    EditText editText10;
    EditText editText11;

    EditText editText12;
    EditText editText13;
    EditText editText14;
    EditText editText15;

    String aa1;
    String aa2;
    String aa3;
    String aa4;

    String bb1;
    String bb2;
    String bb3;
    String bb4;

    String cc1;
    String cc2;
    String cc3;
    String cc4;

    String dd1;
    String dd2;
    String dd3;
    String dd4;

    String results;

    ImageView matrixdisplay;
    TextView matrixdisplay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boggle);
        setTitle(R.string.title_boggle2);
        mTextMessage = findViewById(R.id.mTextMessageID);
        mTextMessage.setText(R.string.boggle_message);

        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);

        editText8 = findViewById(R.id.editText8);
        editText9 = findViewById(R.id.editText9);
        editText10 = findViewById(R.id.editText10);
        editText11 = findViewById(R.id.editText11);

        editText12 = findViewById(R.id.editText12);
        editText13 = findViewById(R.id.editText13);
        editText14 = findViewById(R.id.editText14);
        editText15 = findViewById(R.id.editText15);

        // MAKE ALL CAPS

        editText.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText1.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText2.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText3.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        editText4.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText5.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText6.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText7.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        editText8.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText9.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText10.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText11.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        editText12.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText13.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText14.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        editText15.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        matrixdisplay = findViewById(R.id.matrixdisplay);

        this.camArea = (ImageView)this.findViewById(R.id.camArea);
        Button camButton = findViewById(R.id.camButton);

        Button Solve = findViewById(R.id.buttonSolver);

        matrixdisplay.setImageResource(R.drawable.bogglegrid4x4);
        matrixdisplay2 = findViewById(R.id.matrixdisplay2);

        Button ToggleBoard = findViewById(R.id.button2);

        editText.requestFocus();
        StringGetter();
        String line1 = " " + aa1 + "   " + aa2 + "   " + aa3 + "  " + aa4 + " ";
        String line2 = " " + bb1 + "   " + bb2 + "   " + bb3 + "  " + bb4 + " ";
        String line3 = " " + cc1 + "   " + cc2 + "   " + cc3 + "  " + cc4 + " ";
        String line4 = " " + dd1 + "   " + dd2 + "   " + dd3 + "  " + dd4 + " ";
        matrixdisplay2.setText(line1+"\n" + line2+"\n" + line3+"\n" + line4);
        Solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringGetter();
                //SolverChecker();
                //Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT).show();
                String line1 = " " + aa1 + "   " + aa2 + "   " + aa3 + "  " + aa4 + " ";
                String line2 = " " + bb1 + "   " + bb2 + "   " + bb3 + "  " + bb4 + " ";
                String line3 = " " + cc1 + "   " + cc2 + "   " + cc3 + "  " + cc4 + " ";
                String line4 = " " + dd1 + "   " + dd2 + "   " + dd3 + "  " + dd4 + " ";
                matrixdisplay2.setText(line1+"\n" + line2+"\n" + line3+"\n" + line4);


                // CODE DIRECTLY FROM PC VERSION



                //String[] bogrows = {a1+a2+a3+a4, b1+b2+b3+b4, c1+c2+c3+c4, d1+d2+d3+d4};
                if (aa1.length() != 1 ||  !isAlpha(aa1) || aa2.length() != 1 ||  !isAlpha(aa2) || aa3.length() != 1 ||  !isAlpha(aa3) || aa4.length() != 1 || !isAlpha(aa4) || bb1.length() != 1 || !isAlpha(bb1) || bb2.length() != 1 || !isAlpha(bb2) || bb3.length() != 1 || !isAlpha(bb3) || bb4.length() != 1 || !isAlpha(bb4) || cc1.length() != 1 || !isAlpha(cc1) || cc2.length() != 1 || !isAlpha(cc2) || cc3.length() != 1 || !isAlpha(cc3) || cc4.length() != 1 || !isAlpha(cc4) || dd1.length() != 1 || !isAlpha(dd1) || dd2.length() != 1 || !isAlpha(dd2) || dd3.length() != 1 || !isAlpha(dd3) || dd4.length() != 1 || !isAlpha(dd4)) {
                    Toast.makeText(Boggle.this, "Please enter one letter in each box", Toast.LENGTH_SHORT).show();
                    return;
                }
                String commaboard = aa1+aa2+aa3+aa4+","+bb1+bb2+bb3+bb4+","+cc1+cc2+cc3+cc4+","+dd1+dd2+dd3+dd4;
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

                Intent intent = new Intent(Boggle.this, DisplayResults.class);
                intent.putExtra("boggle_results", results);
                startActivity(intent);
            }
        });

        Button randomgrid = findViewById(R.id.random_grid);
        randomgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomize();
                StringGetter();
                String line1 = " " + aa1 + "   " + aa2 + "   " + aa3 + "  " + aa4 + " ";
                String line2 = " " + bb1 + "   " + bb2 + "   " + bb3 + "  " + bb4 + " ";
                String line3 = " " + cc1 + "   " + cc2 + "   " + cc3 + "  " + cc4 + " ";
                String line4 = " " + dd1 + "   " + dd2 + "   " + dd3 + "  " + dd4 + " ";
                matrixdisplay2.setText(line1+"\n" + line2+"\n" + line3+"\n" + line4);
            }
        });

        final ImageButton oMenu = findViewById(R.id.oMenuID);
        oMenu.setOnClickListener(oMenuListener);
        EnableRuntimePermission();


        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 7);
            }
        });

        ToggleBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ToggleBoard) {
                Intent intent = new Intent(Boggle.this, Boggle5x5.class);
                startActivity(intent);
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().findItem(R.id.navigation_boggle).setChecked(true);
    }

    public void StringGetter() {
        aa1 = editText.getText().toString();
        aa2 = editText1.getText().toString();
        aa3 = editText2.getText().toString();
        aa4 = editText3.getText().toString();

        bb1 = editText4.getText().toString();
        bb2 = editText5.getText().toString();
        bb3 = editText6.getText().toString();
        bb4 = editText7.getText().toString();

        cc1 = editText8.getText().toString();
        cc2 = editText9.getText().toString();
        cc3 = editText10.getText().toString();
        cc4 = editText11.getText().toString();

        dd1 = editText12.getText().toString();
        dd2 = editText13.getText().toString();
        dd3 = editText14.getText().toString();
        dd4 = editText15.getText().toString();
    }

    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int N = alphabet.length();

    Random r = new Random();
    public void randomize() {
        editText.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText1.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText2.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText3.setText(String.valueOf((char)(r.nextInt(26) + 'A')));

        editText4.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText5.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText6.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText7.setText(String.valueOf((char)(r.nextInt(26) + 'A')));

        editText8.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText9.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText10.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText11.setText(String.valueOf((char)(r.nextInt(26) + 'A')));

        editText12.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText13.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText14.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
        editText15.setText(String.valueOf((char)(r.nextInt(26) + 'A')));
    }


    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            camArea.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(Boggle.this,
                Manifest.permission.CAMERA))
        {

            //Toast.makeText(Boggle.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_SHORT).show();

        } else {

            ActivityCompat.requestPermissions(Boggle.this,new String[]{
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

                    Toast.makeText(Boggle.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}
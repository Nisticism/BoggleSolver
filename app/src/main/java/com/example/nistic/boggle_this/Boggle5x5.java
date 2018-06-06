package com.example.nistic.boggle_this;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.support.v4.content.FileProvider;
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

public class Boggle5x5 extends MainActivity {
    ImageView camArea;
    ImageButton OMenu;
    Button solve;
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
    String sendresults;

    TextView matrixdisplay;

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

        matrixdisplay = findViewById(R.id.matrixdisplay);

        camArea = findViewById(R.id.camArea);
        Button camButton = findViewById(R.id.camButton);
        Button Solve = findViewById(R.id.buttonSolver);
        Button ToggleBoard = findViewById(R.id.button2);
        Solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringGetter();
                //SolverChecker();
                Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT).show();
                String line1 = "|  " + aa1 + "  |  " + aa2 + "  |  " + aa3 + "  |  " + aa4 + "  |  " + aa5 + "  |";
                String line2 = "|  " + bb1 + "  |  " + bb2 + "  |  " + bb3 + "  |  " + bb4 + "  |  " + bb5 + "  |";
                String line3 = "|  " + cc1 + "  |  " + cc2 + "  |  " + cc3 + "  |  " + cc4 + "  |  " + cc5 + "  |";
                String line4 = "|  " + dd1 + "  |  " + dd2 + "  |  " + dd3 + "  |  " + dd4 + "  |  " + dd5 + "  |";
                String line5 = "|  " + ee1 + "  |  " + ee2 + "  |  " + ee3 + "  |  " + ee4 + "  |  " + ee5 + "  |";
                matrixdisplay.setText("-------------------------------" + "\n" + line1+"\n" + line2+"\n" + line3+"\n" + line4+"\n" + line5 + "\n" + "-------------------------------");


                // CODE DIRECTLY FROM PC VERSION



                //String[] bogrows = {a1+a2+a3+a4, b1+b2+b3+b4, c1+c2+c3+c4, d1+d2+d3+d4};
                if (aa1.length() != 1 || aa2.length() != 1 || aa3.length() != 1 || aa4.length() != 1 || aa5.length() != 1 || bb1.length() != 1 || bb2.length() != 1 || bb3.length() != 1 || bb4.length() != 1 || bb5.length() != 1 || cc1.length() != 1 || cc2.length() != 1 || cc3.length() != 1 || cc4.length() != 1 || cc5.length() != 1 || dd1.length() != 1 || dd2.length() != 1 || dd3.length() != 1 || dd4.length() != 1 || dd5.length() != 1 || ee1.length() != 1 || ee2.length() != 1 || ee3.length() != 1 || ee4.length() != 1 || ee5.length() != 1 ) {
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
                dispatchTakePictureIntent();
                //onActivityResult(1, -1, null);
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

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileproviderx",
                        photoFile);
                Box box = new Box(this);
                addContentView(box, new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.FILL_PARENT, Constraints.LayoutParams.FILL_PARENT));
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

//    public void SolverChecker() {
//
//        if (aa1.length() != 1 || aa2.length() != 1 || aa3.length() != 1 || aa4.length() != 1 || bb1.length() != 1 || bb2.length() != 1 || bb3.length() != 1 || bb4.length() != 1 || cc1.length() != 1 || cc2.length() != 1 || cc3.length() != 1 || cc4.length() != 1 || dd1.length() != 1 || dd2.length() != 1 || dd3.length() != 1 || dd4.length() != 1) {
//            Toast.makeText(getApplicationContext(), "Please enter 1 letter per field", Toast.LENGTH_SHORT).show();
//        }
//        else if (aa1.length() == 1 && aa2.length() == 1 && aa3.length() == 1 && aa4.length() == 1 && bb1.length() == 1 && bb2.length() == 1 && bb3.length() == 1 && bb4.length() == 1 && cc1.length() == 1 && cc2.length() == 1 && cc3.length() == 1 && cc4.length() == 1 && dd1.length() == 1 && dd2.length() == 1 && dd3.length() == 1 && dd4.length() == 1) {
//            new SolverOpener(aa1,aa2,aa3,aa4,bb1,bb2,bb3,bb4,cc1,cc2,cc3,cc4,dd1,dd2,dd3,dd4);
//            frame.dispose();
//        }
//    }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK)
            try {
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }

                Bundle extras = data.getExtras();
                bitmap = (Bitmap) extras.get("data");
                camArea.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
//            } finally ch (IOException e) {
//            e{
//                if (stream != null)
//                    try {
//                        stream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//            }
//        }
            }
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public class Box extends View {
        private Paint paint = new Paint();
        Box(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) { // Override the onDraw() Method
            super.onDraw(canvas);

            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(10);

            //center
            int x0 = canvas.getWidth()/2;
            int y0 = canvas.getHeight()/2;
            int dx = canvas.getHeight()/3;
            int dy = canvas.getHeight()/3;
            //draw guide box
            canvas.drawRect(x0-dx, y0-dy, x0+dx, y0+dy, paint);
        }
    }
}
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Boggle extends MainActivity {
    ImageView camArea;
    ImageButton OMenu;
    Button solve;
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

    TextView matrixdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boggle);
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

        matrixdisplay = findViewById(R.id.matrixdisplay);

        camArea = findViewById(R.id.camArea);
        Button camButton = findViewById(R.id.camButton);

        Button Solve = findViewById(R.id.buttonSolver);
        Solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringGetter();
                //SolverChecker();
                Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT).show();
                String line1 = "| " + aa1 + " |" + aa2 + " |" + aa3 + " |" + aa4 + " |";
                String line2 = bb1 + bb2 + bb3 + bb4;
                String line3 = cc1 + cc2 + cc3 + cc4;
                String line4 = dd1 + dd2 + dd3 + dd4;
                matrixdisplay.setText("----------------" + "\n" + line1+"\n" + line2+"\n" + line3+"\n" + line4+"\n");
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
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
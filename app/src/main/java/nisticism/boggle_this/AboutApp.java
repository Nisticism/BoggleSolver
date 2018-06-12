package nisticism.boggle_this;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.widget.ImageButton;
import android.widget.TextView;

public class AboutApp extends MainActivity {
    private TextView textbody;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);

        final ImageButton oMenu = findViewById(R.id.oMenuID);
        oMenu.setOnClickListener(oMenuListener);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage = findViewById(R.id.mTextMessageID);
        mTextMessage.setText(R.string.about_app);

        textbody = findViewById(R.id.about_app_text);
        textbody.setText(" •  Idea for app conceived on family vacation while playing Boggle in Dec. of 2017"+"\n"+"\n"+" •  Made with OCR in mind"+"\n"+"\n"+" •  First working android version made in June 2018");

    }

}

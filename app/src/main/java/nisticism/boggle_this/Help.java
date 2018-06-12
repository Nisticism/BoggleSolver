package nisticism.boggle_this;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Help extends MainActivity {
    private TextView textbody;
    private TextView textbody2;
    private ImageView boggleExplanation;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_screen);

        final ImageButton oMenu = findViewById(R.id.oMenuID);
        oMenu.setOnClickListener(oMenuListener);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage = findViewById(R.id.mTextMessageID);
        mTextMessage.setText(R.string.help);

        boggleExplanation = findViewById(R.id.boggleExplanation);

        textbody = findViewById(R.id.help_screen_text);
        textbody.setText("Boggle is a word game played with a grid of 16 (4x4) dice with letters on each side.  " +
                "Other variations of Boggle use a 5x5 grid.  The object of the game is to find as many words as possible " +
                "by connecting adjacent letters in any direction, without using the same letter twice.  Players generally " +
                "have 3 minutes to find as many words as possible before the round is over.");
        textbody2 = findViewById(R.id.help_screen_text2);
        textbody2.setMovementMethod(new ScrollingMovementMethod());
        textbody2.setText(" In the above diagram you can see how the word 'PEACE' is made" + "\n" + "\n" +
                " •  To solve a boggle game, click 'Boggle' down below on the navigation \n" + "\n" +
                " •  To solve a wordsearch puzzle, click 'Wordsearch' \n" + "\n" +
                " •  Lastly, to use OCR technology freely, click 'OCR'");
    }

}
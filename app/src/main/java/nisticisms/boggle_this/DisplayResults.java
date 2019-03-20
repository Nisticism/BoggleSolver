package nisticisms.boggle_this;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageButton;
import android.widget.TextView;


public class DisplayResults extends MainActivity {


    TextView BoggleResultsView;
    @Override
    @SuppressWarnings("deprecation")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_boggle_results);
        String boggle_results_final = getIntent().getStringExtra("boggle_results");
//        String boggle_results_final2 = boggle_results_final.replace("&", "\\r\\n");
        TextView BoggleResultsView = (TextView)findViewById(R.id.boggle_results);
//
//// substring to avoid linking the first description bit
//        String resultSubstring1 = boggle_results_final2.substring(0, 100);
//        String resultSubstring2 = boggle_results_final2.substring(100);
        String[] splitWords = boggle_results_final.split(" ");
        //BoggleResultsView.setText(Html.fromHtml(boggle_results_final));
        String finalGoogleString = "";
        for (int i = 0; i < splitWords.length; i ++) {
            finalGoogleString += "<b><a href=" + "\"" + "https://www.google.com/search?&q=" + splitWords[i] + "&oq=" + splitWords[i] + "\"" + ">" + splitWords[i] + "</a> </b>" + " ";
        }
        //String fullhtmlstring = "<b><a href=" + "\"" + "https://www.google.com/search?&q=" + "hello" + "&oq=" + "hello" + "\"" + ">" + "hello" + "</a> </b>";
        BoggleResultsView.setText(Html.fromHtml(finalGoogleString));
        BoggleResultsView.setMovementMethod(new ScrollingMovementMethod());
        BoggleResultsView.setMovementMethod(LinkMovementMethod.getInstance());

        final ImageButton oMenu = findViewById(R.id.oMenuID);
        oMenu.setOnClickListener(oMenuListener);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
}
package com.example.wordcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.wordcounter.utils.TextCounter;



public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText edUserInput;
    Spinner spinnerForUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.tvResult = findViewById(R.id.tvCountResult);
        this.edUserInput=  findViewById(R.id.edUserInput);

        this.spinnerForUser = (Spinner) findViewById(R.id.spModeSelection);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerForUser.setAdapter(adapter);



    }


    public void onBtnCountClick(View view) {
        if(TextUtils.isEmpty(this.edUserInput.getText().toString())){ //If nothing
            Toast.makeText(MainActivity.this, "PLEASE FEED ME TEXT I NEEEEEEEEEEEED ITTTT PLEASEEEEEE I BEG YOU PLEASE ENTER TEXT PLEASE PLEASE THANK YOU!", Toast.LENGTH_SHORT).show();
        }
        else if(this.spinnerForUser.getSelectedItem().toString().equalsIgnoreCase("chars")){ //If characters
            String userPhrase = this.edUserInput.getText().toString();
            int charsCount = TextCounter.getCharsCount(userPhrase);
            this.tvResult.setText(String.valueOf(charsCount));

        }
        else if(this.spinnerForUser.getSelectedItem().toString().equalsIgnoreCase("words")){//If words
            String userPhrase = this.edUserInput.getText().toString();
            int charsCount = TextCounter.getWordCount(userPhrase);
            this.tvResult.setText(String.valueOf(charsCount));

        }
        else if(this.spinnerForUser.getSelectedItem().toString().equalsIgnoreCase("sentence symbols")){//If numbers
            String userPhrase = this.edUserInput.getText().toString();
            int charsCount = TextCounter.countSentenceNotations(userPhrase);
            this.tvResult.setText(String.valueOf(charsCount));

        }
        else if(this.spinnerForUser.getSelectedItem().toString().equalsIgnoreCase("numbers")){//If symbols
            String userPhrase = this.edUserInput.getText().toString();
            int charsCount = TextCounter.countNumbers(userPhrase);
            this.tvResult.setText(String.valueOf(charsCount));

        }


    }
}
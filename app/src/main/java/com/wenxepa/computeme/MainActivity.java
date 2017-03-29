package com.wenxepa.computeme;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Button b1;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);

        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //String text;
                //text = ed1.getText().toString();
                long myNum = Integer.valueOf(ed1.getText().toString());
                myNum = myNum * myNum;
                //System.out.println(Long.toHexString(myNum).toUpperCase());

                myClip = ClipData.newPlainText("text", Long.toHexString(myNum).toUpperCase());
                myClipboard.setPrimaryClip(myClip);

                Toast.makeText(getApplicationContext(), "Text Copied",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}

package com.ist.cobanative;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);

        ll.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        ll.setOrientation(LinearLayout.VERTICAL);

        setContentView(ll);

        editText = new EditText(this);
        editText.setHint("Ketik sebuah kata");
        ll.addView(editText,
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        button = new Button(this);
        button.setText("Convert");
        ll.addView(button,
                new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        button.setOnClickListener(onClickConverting);

        textView = new TextView(this);
        textView.setText("Hasil convert ke Base64");
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ll.addView(textView,
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }

    private View.OnClickListener onClickConverting = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View view) {
            if (editText.getText().toString().equals("")) {
                textView.setText("Hasil convert ke Base64");
            } else {
                byte[] text = editText.getText().toString().getBytes();
                textView.setText(Base64.encodeToString(text, Base64.DEFAULT));
            }
        }
    };
}
package com.github.kornilovmikhail.homework;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int PICK_INFO_REQUEST = 1;
    static final int PICK_RESULT_SENDING_REQUEST = 0;
    private TextView textName;
    private TextView textEmail;
    private TextView textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button editButton = (Button) findViewById(R.id.button_main_edit);
        editButton.setOnClickListener(this);
        Button sendButton = (Button) findViewById(R.id.button_main_send_name);
        sendButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        textName = (TextView) findViewById(R.id.textview_main_name);
        textEmail = (TextView) findViewById(R.id.textview_main_email);
        textPhone = (TextView) findViewById(R.id.textView_main_phone);
        switch (view.getId()) {
            case R.id.button_main_edit:
                Intent intentEdit = new Intent(view.getContext(), EditActivity.class);
                if (textName.getText() != null && textEmail.getText() != null && textPhone.getText() != null) {
                    intentEdit.putExtra(EditActivity.NAME, textName.getText());
                    intentEdit.putExtra(EditActivity.EMAIL, textEmail.getText());
                    intentEdit.putExtra(EditActivity.PHONE, textPhone.getText());
                }
                startActivityForResult(intentEdit, PICK_INFO_REQUEST);
                break;
            case R.id.button_main_send_name:
                if (!textName.getText().equals("") && !textEmail.getText().equals("")) {
                    Intent intentSend = new Intent(Intent.ACTION_SEND);
                    intentSend.setType("text/plain");
                    intentSend.putExtra(Intent.EXTRA_TEXT, textName.getText().toString());
                    startActivityForResult(intentSend, PICK_RESULT_SENDING_REQUEST);
                } else {
                    String warning = "Name is empty";
                    Toast toast = Toast.makeText(getApplicationContext(), warning, Toast.LENGTH_SHORT);
                    toast.show();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PICK_INFO_REQUEST) {
            if (resultCode == RESULT_OK) {
                String nameFromEdit = data.getStringExtra(EditActivity.NAME);
                String emailFromEdit = data.getStringExtra(EditActivity.EMAIL);
                String phoneFromEdit = data.getStringExtra(EditActivity.PHONE);
                textName.setText(nameFromEdit);
                textEmail.setText(emailFromEdit);
                textPhone.setText(phoneFromEdit);
            }
            if (resultCode == RESULT_CANCELED) {
                textName.setText("");
                textEmail.setText("");
                textPhone.setText("");
            }
        }
        if (requestCode == PICK_RESULT_SENDING_REQUEST) {
            if (resultCode == RESULT_OK) {
                String message = "Name sent";
                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}

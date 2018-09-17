package com.github.kornilovmikhail.homework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    final static String NAME = "name";
    final static String EMAIL = "email";
    final static String PHONE = "phone";
    private EditText editName;
    private EditText editEmail;
    private EditText editPhone;
    private TextView textName;
    private TextView textEmail;
    private TextView textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editName = findViewById(R.id.edittext_edit_name);
        editEmail = findViewById(R.id.edittext_edit_email);
        editPhone = findViewById(R.id.edittext_edit_phone);
        textName = findViewById(R.id.textview_main_name);
        textEmail = findViewById(R.id.textview_main_email);
        textPhone = findViewById(R.id.textView_main_phone);
        if (getIntent().getExtras() != null) {
            editName.setText(getIntent().getStringExtra(NAME));
            editEmail.setText(getIntent().getStringExtra(EMAIL));
            editPhone.setText(getIntent().getStringExtra(PHONE));
        }
        Button buttonReset = findViewById(R.id.button_edit_cancel);
        Button buttonSave = findViewById(R.id.button_edit_save);
        buttonReset.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_edit_cancel:
                Intent intentEdit = new Intent();
                setResult(Activity.RESULT_CANCELED, intentEdit);
                finish();
                break;
            case R.id.button_edit_save:
                Intent intentSave = new Intent();
                intentSave.putExtra(NAME, editName.getText().toString());
                intentSave.putExtra(EMAIL, editEmail.getText().toString());
                intentSave.putExtra(PHONE, editPhone.getText().toString());
                setResult(Activity.RESULT_OK, intentSave);
                finish();
                break;
            default:
                break;
        }
    }

    public void onBackPressed() {
        String alert = "Are you sure you want to return?";
        String alertDescription = "you will lose your data if you continue!";
        String positiveButton = "Yes";
        String negativeButton = "No";
        AlertDialog.Builder ad = new AlertDialog.Builder(EditActivity.this,
                android.R.style.Theme_Material_Dialog_Alert);
        ad.setTitle(alert);
        ad.setMessage(alertDescription);
        ad.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intentEdit = new Intent();
                setResult(Activity.RESULT_CANCELED, intentEdit);
                finish();
            }
        });
        ad.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        ad.show();
    }
}

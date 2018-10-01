package com.github.kornilovmikhail.homework;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class EditDialog extends DialogFragment {

    private EditText etLogin;
    private EditText etEmail;
    private CallBack callBack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack = (CallBack) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit, null);
        etLogin = view.findViewById(R.id.et_login);
        etEmail = view.findViewById(R.id.et_email);
        String title = "Set login and email";
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
        ad.setTitle(title);
        ad.setView(view);
        ad.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callBack.callback(etLogin.getText().toString(), etEmail.getText().toString());
            }
        });
        ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        return ad.show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callBack = null;
    }
}

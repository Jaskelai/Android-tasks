package com.github.kornilovmikhail.homework;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements CallBack {

    private TextView tvLogin;
    private TextView tvEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        final Button editButton = v.findViewById(R.id.btn_edit);
        tvLogin = v.findViewById(R.id.tv_login);
        tvEmail = v.findViewById(R.id.tv_email);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditDialog editDialog = new EditDialog();
                editDialog.show(getChildFragmentManager(), "dialog");
            }
        });
        return v;
    }

    @Override
    public void callback(String login, String email) {
        tvEmail.setText(login);
        tvLogin.setText(email);
    }
}

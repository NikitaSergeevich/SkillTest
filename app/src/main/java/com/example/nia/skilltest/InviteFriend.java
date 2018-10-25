package com.example.nia.skilltest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class InviteFriend extends AppCompatActivity {

    ActionBar actionBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.phoneNumber)
    EditText phoneNumber;
    @BindView(R.id.firstName)
    EditText firstName;
    @BindView(R.id.lastName)
    EditText lastName;
    @BindView(R.id.submitButton)
    Button submitButton;
    boolean isButtonEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(null);
        }
    }

    @OnTextChanged(value = R.id.phoneNumber,
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPhoneInput(Editable editable) {
        if (phoneNumber.getText().toString().length() != 0 &&
                (firstName.getText().toString().length() != 0 || lastName.getText().toString().length() != 0 )) {
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }

    @OnTextChanged(value = R.id.firstName,
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterFirstNameInput(Editable editable) {
        if (phoneNumber.getText().toString().length() != 0 &&
                (firstName.getText().toString().length() != 0 || lastName.getText().toString().length() != 0 )) {
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }

    @OnTextChanged(value = R.id.lastName,
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterLastNameInput(Editable editable) {
        if (phoneNumber.getText().toString().length() != 0 &&
                (firstName.getText().toString().length() != 0 || lastName.getText().toString().length() != 0 )) {
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }

    @OnClick(R.id.submitButton)
    public void onSubmit(View view) {

    }
}

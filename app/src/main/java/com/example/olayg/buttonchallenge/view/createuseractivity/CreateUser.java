package com.example.olayg.buttonchallenge.view.createuseractivity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.olayg.buttonchallenge.Constants;
import com.example.olayg.buttonchallenge.R;
import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.view.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateUser extends BaseActivity {

    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.input_user_full_name)
    TextInputLayout inputUserFullName;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.input_user_email)
    TextInputLayout inputUserEmail;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        ButterKnife.bind(this);
        activateToolbar(true);
        user = new User();
        etEmail.addTextChangedListener(new UserTextWatcher(etEmail));
        etName.addTextChangedListener(new UserTextWatcher(etName));
    }

    @OnClick({R.id.btnSaveUser, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSaveUser:
                submitForm();
                break;
            case R.id.fab:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }

    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        user.setName(etName.getText().toString().trim());
        user.setEmail(etEmail.getText().toString().trim());
        user.setCandidate(Constants.CANDIDATE);
        EventBus.getDefault().post(new UserEvent(user));
    }

    private boolean validateEmail() {
        String email = etEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputUserEmail.setError(getString(R.string.email_error_message));
            requestFocus(etEmail);
            return false;
        } else {
            inputUserEmail.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validateName() {
        if (etName.getText().toString().trim().isEmpty()) {
            inputUserFullName.setError(getString(R.string.name_error_message));
        } else {
            inputUserFullName.setErrorEnabled(false);
        }
        return true;
    }

    class UserTextWatcher implements TextWatcher {
        private View view;

        public UserTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()) {
                case R.id.etEmail:
                    validateEmail();
                    break;
                case R.id.etName:
                    validateName();
                    break;
            }
        }
    }

}

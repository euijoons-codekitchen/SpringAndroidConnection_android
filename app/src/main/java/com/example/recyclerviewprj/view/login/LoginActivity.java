package com.example.recyclerviewprj.view.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyclerviewprj.R;
import com.example.recyclerviewprj.dto.User;
import com.example.recyclerviewprj.service.LoginService;
import com.example.recyclerviewprj.service.RetrofitService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    String TAG  = LoginActivity.class.getName();

    @BindView(R.id.edit_login_email)
    EditText mEmailEditText;
    @BindView(R.id.edit_login_passwd)
    EditText mPasswdEditText;
    @BindView(R.id.btn_login_signup)
    Button mBtnSignUp;
    @BindView(R.id.btn_login_login)
    Button mBtnSignIn;

    @OnClick(R.id.btn_login_signup)
    public void onSignUpBtnClicked(){
        if(RetrofitService.getRetrofitObj() == null)
            Log.d(TAG, "onSignUpBtnClicked: retrofit Obj is null");
        LoginService service = RetrofitService.getRetrofitObj().create(LoginService.class);
        Call<User> c = service.signup(mEmailEditText.getText().toString(),mPasswdEditText.getText().toString());
        c.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse: ");
                Log.d(TAG, "onResponse: "+response.body().getEmail()+response.body().getPasswd());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }
    @OnClick(R.id.btn_login_login)
    public void onLoginBtnClicked(){
        LoginService service = RetrofitService.getRetrofitObj().create(LoginService.class);
        Call<User> c = service.login(new User(mEmailEditText.getText().toString(),mPasswdEditText.getText().toString()));
        try{
            c.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.d(TAG, "onResponse: ");
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.d(TAG, "onFailure: ");
                }
            });
        }
        catch (Exception e){
            
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }
}

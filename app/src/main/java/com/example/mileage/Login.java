package com.example.mileage;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class Login extends AppCompatActivity {
    private static final String TAG = "Login";
    private TextView nickName, tvInfo1, tvInfo2;
    private ImageView profileImage;
    private View loginButton, logoutButton;
    private ImageButton btnBack;
    DBHelper dbHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        tvInfo1 = (TextView) findViewById(R.id.tv_info1);
        tvInfo2 = (TextView) findViewById(R.id.tv_info2);
        nickName = (TextView) findViewById(R.id.tv_nickname);
        profileImage = (ImageView) findViewById(R.id.iv_profile);
        loginButton = (View) findViewById(R.id.iv_login);
        logoutButton = (View) findViewById(R.id.btn_logout);
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        // 데이터베이스 관리 클래스
        dbHelper = new DBHelper(this, "Mileage", null, 1);

        // 액티비티를 종료하고 홈 프래그먼트로 이동
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 콜백함수 선언
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                // 이때 토큰이 전달이 되면 로그인이 성공한 것이고 토큰이 전달되지 않았다면 로그인 실패
                if (oAuthToken != null) {
                    Log.d(TAG, "로그인 성공");
                }
                if (throwable != null) {
                    Log.d(TAG, "로그인 실패");
                    Log.e(TAG, throwable.getLocalizedMessage());
                }
                updateKakaoLoginUi();
                return null;
            }
        };
        // 로그인 버튼
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(Login.this)) {
                    UserApiClient.getInstance().loginWithKakaoTalk(Login.this, callback);
                } else {
                    UserApiClient.getInstance().loginWithKakaoAccount(Login.this, callback);
                }
            }
        });
        // 로그 아웃 버튼
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        updateKakaoLoginUi();
                        return null;
                    }
                });
            }
        });
        updateKakaoLoginUi();
    }

    private void updateKakaoLoginUi() {
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                // 로그인이 되어있으면
                if (user != null) {

                    // 유저의 고유아이디
                    Log.d(TAG, "invoke: id" + user.getId());
                    // 유저의 어카운트정보에 닉네임
                    Log.i(TAG, "invoke: nickname" + user.getKakaoAccount().getProfile().getNickname());
                    // 유저의 어카운트 정보의 이메일
                    Log.i(TAG, "invoke: email" + user.getKakaoAccount().getEmail());
                    // 유저의 어카운트 파일의 성별
                    Log.i(TAG, "invoke: gender" + user.getKakaoAccount().getGender());
                    // 유저의 어카운트 정보에 나이
                    Log.i(TAG, "invoke: age" + user.getKakaoAccount().getAgeRange());

                    tvInfo1.setVisibility(View.GONE);
                    tvInfo2.setVisibility(View.GONE);
                    nickName.setText(user.getKakaoAccount().getProfile().getNickname());
                    // 프로필 사진을 동그라미 형태로 가져옴
                    Glide.with(profileImage).load(user.getKakaoAccount().
                            getProfile().getProfileImageUrl()).circleCrop().into(profileImage);
                    loginButton.setVisibility(View.GONE);
                    logoutButton.setVisibility(View.VISIBLE);

                    sqlDB = dbHelper.getWritableDatabase();
                    // 이미 데이터베이스가 있을 때 로그인 화면으로 이동하며 AVD가 튕겨 어쩔 수 없이 초기화 해줌
                    dbHelper.onUpgrade(sqlDB, 1, 2);
                    long newId = user.getId();

                    // 유저의 고유 카카오 아이디를 바탕으로 DB 삽입
                    sqlDB.execSQL("INSERT INTO Mileage VALUES (" + newId + ",0)");
                    sqlDB.close();
                } else {
                    // 로그인이 되어 있지 않다면 위와 반대로
                    tvInfo1.setVisibility(View.VISIBLE);
                    tvInfo2.setVisibility(View.VISIBLE);
                    nickName.setText(null);
                    profileImage.setImageBitmap(null);
                    loginButton.setVisibility(View.VISIBLE);
                    logoutButton.setVisibility(View.GONE);
                }
                return null;
            }
        });
    }
}

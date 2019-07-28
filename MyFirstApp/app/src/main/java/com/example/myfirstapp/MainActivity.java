package com.example.myfirstapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/*
기본 activity입니다(앱의 진입점).
앱을 빌드하고 실행하는 경우 시스템이 이 파일의 인스턴스를 시작하고 해당 레이아웃을 로드합니다.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendMessage(View view) {
        /*
        Intent 생성자는 다음 2가지 매개변수를 사용합니다.

        1. 첫 번째 매개변수 Context(this는 Activity 클래스가 Context의 서브클래스이므로 사용됨)
        2. 시스템이 Intent를 전달할 앱 구성요소의 Class(이 경우, 시작되어야 하는 활동)
        */
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        /*
        putExtra() 메소드는 EditText의 값을 인텐트에 추가합니다.
        Intent는 데이터 유형을 엑스트라라고 하는 키-값 쌍으로 전달할 수 있습니다.
        다음 활동에서 키를 사용하여 텍스트 값을 검색하기 때문에 키는 공용 상수 EXTRA_MESSAGE입니다.
        앱 패키지 이름을 접두사로 사용해 인텐트 엑스트라 키를 정의하는 것이 좋습니다.
        그러면 앱이 다른 앱과 상호작용하는 경우 키가 고유하게 유지됩니다.
        */
        intent.putExtra(EXTRA_MESSAGE, message);
        /*
        startActivity() 메소드는 Intent를 통해 지정된 DisplayMessageActivity 인스턴스를 시작합니다.
        */
        startActivity(intent);
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//リスナクラス <= イベントの監視
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalculate = findViewById(R.id.btCalculate);
        HelloListener listener = new HelloListener();   //リスナのインスタンス生成
        btCalculate.setOnClickListener(listener);           //ボタンにリスナを組み込む


        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    //イベントハイドラ　<= イベント発生時
    private class HelloListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            EditText in_old = findViewById(R.id.numOld);    //入力したデータを挿入
            EditText in_hight = findViewById(R.id.numHight);
            EditText in_weight = findViewById(R.id.numWeight);
            TextView res_1 = findViewById(R.id.tvResult1);
            TextView in_judge = findViewById(R.id.tvJudge);
            TextView res_2 = findViewById(R.id.tvResult2);
            TextView in_app = findViewById(R.id.tvAppropriate);
            TextView kg = findViewById(R.id.tvKg);

            Float old = Float.parseFloat(in_old.getText().toString());        //データをFloat型へ
            Float hight_cm = Float.parseFloat(in_hight.getText().toString());
            Float weight = Float.parseFloat(in_weight.getText().toString());

            float hight = hight_cm / 100;
            float BMI = weight / (hight * hight);
            float appweight = 22 * (hight * hight);
            String strapp = String.format("%.1f", appweight);

            int id = view.getId();
            switch (id) {
                case R.id.btCalculate:  //計算
                    if (old < 16) {
                        OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                        dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragmen");
                    }
                    res_1.setText("あなたの肥満度は");
                    res_2.setText("あなたの適正体重は");
                    kg.setText("Kg");
                    if (BMI < 18.5)
                        in_judge.setText("低体重");
                    else if (BMI < 25)
                        in_judge.setText("普通体重");
                    else if (BMI < 30)
                        in_judge.setText("肥満（１度）");
                    else if (BMI < 35)
                        in_judge.setText("肥満（２度）");
                    else if (BMI < 40)
                        in_judge.setText("肥満（３度）");
                    else
                        in_judge.setText("肥満（４度）");
                    in_app.setText(strapp);
                    break;

                case R.id.btClear:  //クリア
                    in_old.setText("");
                    in_hight.setText("");
                    in_weight.setText("");
                    in_judge.setText("");
                    in_app.setText("");
                    res_1.setText("");
                    res_2.setText("");
                    kg.setText("");
                    break;

            }
        }
    }
}
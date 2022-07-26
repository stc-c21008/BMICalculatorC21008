package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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
                    res_1.setText("あなたの肥満度は");
                    res_2.setText("あなたの適正体重は");
                    kg.setText("Kg");
                    if (old < 16) {
                        OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                        dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragmen");
                        if (old < 6) {
                            if (old < 1) {
                                appweight = 17 * (hight * hight);
                                if (BMI < 14) {
                                    in_judge.setText("痩せすぎ");
                                    in_judge.setTextColor(Color.YELLOW);
                                } else if (BMI < 16) {
                                    in_judge.setText("痩せ気味");
                                    in_judge.setTextColor(Color.GREEN);
                                } else if (BMI < 18) {
                                    in_judge.setText("普通体重");
                                    in_judge.setTextColor(Color.BLUE);
                                } else if (BMI < 20) {
                                    in_judge.setText("太り気味");
                                    in_judge.setTextColor(Color.RED);
                                } else {
                                    in_judge.setText("太りすぎ");
                                    in_judge.setTextColor(Color.BLACK);
                                }
                            } else if (old < 2) {
                                appweight = 16 * (hight * hight);
                                if (BMI < 14.5) {
                                    in_judge.setText("痩せすぎ");
                                    in_judge.setTextColor(Color.YELLOW);
                                } else if (BMI < 15.5) {
                                    in_judge.setText("痩せ気味");
                                    in_judge.setTextColor(Color.GREEN);
                                } else if (BMI < 17.5) {
                                    in_judge.setText("普通体重");
                                    in_judge.setTextColor(Color.BLUE);
                                } else if (BMI < 19.5) {
                                    in_judge.setText("太り気味");
                                    in_judge.setTextColor(Color.RED);
                                } else {
                                    in_judge.setText("太りすぎ");
                                    in_judge.setTextColor(Color.BLACK);
                                }
                            } else if (old < 3) {
                                appweight = 16 * (hight * hight);
                                if (BMI < 13) {
                                    in_judge.setText("痩せすぎ");
                                    in_judge.setTextColor(Color.YELLOW);
                                } else if (BMI < 15) {
                                    in_judge.setText("痩せ気味");
                                    in_judge.setTextColor(Color.GREEN);
                                } else if (BMI < 17) {
                                    in_judge.setText("普通体重");
                                    in_judge.setTextColor(Color.BLUE);
                                } else if (BMI < 18) {
                                    in_judge.setText("太り気味");
                                    in_judge.setTextColor(Color.RED);
                                } else {
                                    in_judge.setText("太りすぎ");
                                    in_judge.setTextColor(Color.BLACK);
                                }
                            } else if (old < 4) {
                                appweight = 15 * (hight * hight);
                                if (BMI < 13.5) {
                                    in_judge.setText("痩せすぎ");
                                    in_judge.setTextColor(Color.YELLOW);
                                } else if (BMI < 14.5) {
                                    in_judge.setText("痩せ気味");
                                    in_judge.setTextColor(Color.GREEN);
                                } else if (BMI < 16.5) {
                                    in_judge.setText("普通体重");
                                    in_judge.setTextColor(Color.BLUE);
                                } else if (BMI < 18.5) {
                                    in_judge.setText("太り気味");
                                    in_judge.setTextColor(Color.RED);
                                } else {
                                    in_judge.setText("太りすぎ");
                                    in_judge.setTextColor(Color.BLACK);
                                }
                            } else if (old < 5) {
                                appweight = 15 * (hight * hight);
                                if (BMI < 13) {
                                    in_judge.setText("痩せすぎ");
                                    in_judge.setTextColor(Color.YELLOW);
                                } else if (BMI < 14.5) {
                                    in_judge.setText("痩せ気味");
                                    in_judge.setTextColor(Color.GREEN);
                                } else if (BMI < 16.5) {
                                    in_judge.setText("普通体重");
                                    in_judge.setTextColor(Color.BLUE);
                                } else if (BMI < 18) {
                                    in_judge.setText("太り気味");
                                    in_judge.setTextColor(Color.RED);
                                } else {
                                    in_judge.setText("太りすぎ");
                                    in_judge.setTextColor(Color.BLACK);
                                }
                            } else if (old < 6) {
                                appweight = 16 * (hight * hight);
                                if (BMI < 13) {
                                    in_judge.setText("痩せすぎ");
                                    in_judge.setTextColor(Color.YELLOW);
                                } else if (BMI < 14.5) {
                                    in_judge.setText("痩せ気味");
                                    in_judge.setTextColor(Color.GREEN);
                                } else if (BMI < 16.5) {
                                    in_judge.setText("普通体重");
                                    in_judge.setTextColor(Color.BLUE);
                                } else if (BMI < 18.5) {
                                    in_judge.setText("太り気味");
                                    in_judge.setTextColor(Color.RED);
                                } else {
                                    in_judge.setText("太りすぎ");
                                    in_judge.setTextColor(Color.BLACK);
                                }
                            }
                        } else {
                            BMI = weight / (hight * hight * hight) * 10;
                            appweight = 130 * (hight * hight * hight) * 10;
                            if (BMI < 100) {
                                in_judge.setText("痩せすぎ");
                                in_judge.setTextColor(Color.YELLOW);
                            } else if (BMI < 115) {
                                in_judge.setText("痩せ気味");
                                in_judge.setTextColor(Color.GREEN);
                            } else if (BMI < 145) {
                                in_judge.setText("普通体重");
                                in_judge.setTextColor(Color.BLUE);
                            } else if (BMI < 160) {
                                in_judge.setText("太り気味");
                                in_judge.setTextColor(Color.RED);
                            } else {
                                in_judge.setText("太りすぎ");
                                in_judge.setTextColor(Color.BLACK);
                            }
                        }
                    } else {
                        if (BMI < 18.5) {
                            in_judge.setText("低体重");
                            in_judge.setTextColor(Color.CYAN);
                        } else if (BMI < 25) {
                            in_judge.setText("普通体重");
                            in_judge.setTextColor(Color.YELLOW);
                        } else if (BMI < 30) {
                            in_judge.setText("肥満（１度）");
                            in_judge.setTextColor(Color.GREEN);
                        } else if (BMI < 35) {
                            in_judge.setText("肥満（２度）");
                            in_judge.setTextColor(Color.BLUE);
                        } else if (BMI < 40) {
                            in_judge.setText("肥満（３度）");
                            in_judge.setTextColor(Color.RED);
                        } else {
                            in_judge.setText("肥満（４度）");
                            in_judge.setTextColor(Color.BLACK);
                        }
                    }
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
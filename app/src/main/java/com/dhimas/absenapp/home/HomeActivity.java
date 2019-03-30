package com.dhimas.absenapp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dhimas.absenapp.R;

public class HomeActivity extends AppCompatActivity {
    private EditText sumFirst;
    private EditText sumSecond;
    private TextView tvSumResult;
    private Button sumBtn;

    private EditText multiplyFirst;
    private EditText multiplySecond;
    private TextView tvMultiplyResult;
    private Button multiplyBtn;

    private EditText primeCount;
    private Button primeBtn;
    private TextView tvPrimeResult;

    private EditText fiboCount;
    private Button fiboBtn;
    private TextView tvFiboResult;

    private HomeActivityPresenter mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mPresenter = new HomeActivityPresenterImpl();
        initComponent();
        initEvent();
    }

    private void initComponent() {
        sumFirst = findViewById(R.id.sumFirst);
        sumSecond = findViewById(R.id.sumSecond);
        tvSumResult = findViewById(R.id.sumResult);
        sumBtn = findViewById(R.id.sumBtn);

        multiplyFirst = findViewById(R.id.multiplyFirst);
        multiplySecond = findViewById(R.id.multiplySecond);
        tvMultiplyResult = findViewById(R.id.multiplyResult);
        multiplyBtn = findViewById(R.id.multiplyBtn);

        primeCount = findViewById(R.id.primeCount);
        primeBtn = findViewById(R.id.primeBtn);
        tvPrimeResult = findViewById(R.id.primeResult);

        fiboCount = findViewById(R.id.fibCount);
        fiboBtn = findViewById(R.id.fibBtn);
        tvFiboResult = findViewById(R.id.fibResult);
    }

    private void initEvent() {
        sumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(sumFirst.getText().toString()) && !TextUtils.isEmpty(sumSecond.getText().toString())) {
                    String result = mPresenter.getSum(sumFirst.getText().toString(), sumSecond.getText().toString());
                    tvSumResult.setText(result);
                } else {
                    tvSumResult.setText(0);
                }
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(multiplyFirst.getText().toString()) && !TextUtils.isEmpty(multiplySecond.getText().toString())) {
                    String result = mPresenter.getMulti(multiplyFirst.getText().toString(), multiplySecond.getText().toString());
                    tvMultiplyResult.setText(result);
                } else {
                    tvMultiplyResult.setText(0);
                }
            }
        });

        primeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(primeCount.getText().toString())) {
                    String result = mPresenter.getPrime(primeCount.getText().toString());
                    tvPrimeResult.setText(result);
                } else {
                    tvPrimeResult.setText(0);
                }
            }
        });

        fiboBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(fiboCount.getText().toString())) {
                    String result = mPresenter.getFibo(fiboCount.getText().toString());
                    tvFiboResult.setText(result);
                } else {
                    tvFiboResult.setText(0);
                }
            }
        });
    }

}

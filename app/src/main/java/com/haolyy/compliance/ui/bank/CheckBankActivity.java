package com.haolyy.compliance.ui.bank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.inteface.EditTextChangeIdCardListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CheckBankActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tv_real_name)
    ClearEditText tvRealName;
    @BindView(R.id.tv_id_card)
    ClearEditText tvIdCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_check_bank);
        ButterKnife.bind(this);
        tvTitle.setText("开通上海银行存管账户");
        tvIdCard.addTextChangedListener(new EditTextChangeIdCardListener(tvIdCard));
    }
}

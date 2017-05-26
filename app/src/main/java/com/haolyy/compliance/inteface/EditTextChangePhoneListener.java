package com.haolyy.compliance.inteface;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
/**
 * 在控制小X的显示与隐藏基础上 对Phone数据类型 控制其显示方式为344
 * Created by gsyf on 16/6/13.
 */
public class EditTextChangePhoneListener implements TextWatcher {
    private EditText editText;
    private String addString = " ";

    public EditTextChangePhoneListener(EditText etBankPhone) {
        this.editText = etBankPhone;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence str, int start, int before, int count) {
        String contents = str.toString();
        int length = contents.length();

        if (null != editText) {
            if (length == 4) {
                if (contents.substring(3).equals(addString)) { // -
                    contents = contents.substring(0, 3);
                } else { // +
                    contents = contents.substring(0, 3) + addString + contents.substring(3);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            } else if (length == 9) {
                if (contents.substring(8).equals(addString)) { // -
                    contents = contents.substring(0, 8);
                } else {// +
                    contents = contents.substring(0, 8) + addString + contents.substring(8);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            }
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

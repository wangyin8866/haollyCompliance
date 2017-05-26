package com.haolyy.compliance.inteface;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;
/**
 * 在控制小X的显示与隐藏基础上 对ID card数据类型 控制其显示方式为33444
 * Created by gsyf on 16/6/14.
 */
public class EditTextChangeIdCardListener implements TextWatcher {
    private EditText editText;

    private String addString = " ";

    public EditTextChangeIdCardListener(EditText editText) {
        this.editText=editText;
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
            } else if (length == 8) {
                if (contents.substring(7).equals(addString)) { // -
                    contents = contents.substring(0, 7);
                } else {// +
                    contents = contents.substring(0, 7) + addString + contents.substring(7);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            } else if (length == 13) {
                if (contents.substring(12).equals(addString)) { // -
                    contents = contents.substring(0, 12);
                } else {// +
                    contents = contents.substring(0, 12) + addString + contents.substring(12);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            } else if (length == 18) {
                if (contents.substring(17).equals(addString)) { // -
                    contents = contents.substring(0, 17);
                } else {// +
                    contents = contents.substring(0, 17) + addString + contents.substring(17);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            }else if(length>=21){//最后一位切换键盘
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                editText.setSelection(contents.length());
            }else {//删除时恢复数字键盘
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setSelection(contents.length());
            }
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

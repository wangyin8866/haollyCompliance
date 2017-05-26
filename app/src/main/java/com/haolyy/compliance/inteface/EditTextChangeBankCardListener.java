package com.haolyy.compliance.inteface;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
/**
 * 在控制小X的显示与隐藏基础上 对Bank Card数据类型 控制其显示方式为4444(3)
 * Created by gsyf on 16/6/14.
 */
public class EditTextChangeBankCardListener  implements TextWatcher {
   private EditText editText;

    private String addString = " ";

    public EditTextChangeBankCardListener(EditText editText) {
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
            if (length == 5) {
                if (contents.substring(4).equals(addString)) { // -
                    contents = contents.substring(0, 4);
                } else { // +
                    contents = contents.substring(0, 4) + addString + contents.substring(4);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            } else if (length == 10) {
                if (contents.substring(9).equals(addString)) { // -
                    contents = contents.substring(0, 9);
                } else {// +
                    contents = contents.substring(0, 9) + addString + contents.substring(9);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            } else if (length == 15) {
                if (contents.substring(14).equals(addString)) { // -
                    contents = contents.substring(0, 14);
                } else {// +
                    contents = contents.substring(0, 14) + addString + contents.substring(14);
                }
                editText.setText(contents);
                editText.setSelection(contents.length());
            } else if (length == 20) {
                if (contents.substring(19).equals(addString)) { // -
                    contents = contents.substring(0, 19);
                } else {// +
                    contents = contents.substring(0, 19) + addString + contents.substring(19);
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

package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by William on 2017/1/8
 */

public class DialogSignInTips extends Dialog {
    @BindView(R.id.shopping_dialog_close)
    ImageView shoppingDialogClose;
    public DialogSignInTips(Context context) {
        super(context, R.style.dialogToast);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_sign_in);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.shopping_dialog_close)
    public void onViewClicked() {
        dismiss();
    }
}

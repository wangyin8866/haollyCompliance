package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wy on 2017/1/8
 *
 */

public class DialogSignInTips extends Dialog {
    @BindView(R.id.shopping_dialog_close)
    ImageView shoppingDialogClose;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.ll_text_string)
    LinearLayout llTextString;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public DialogSignInTips(Context context) {
        super(context, R.style.dialogToast);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_sign_in);
        ButterKnife.bind(this);

    }
    public DialogSignInTips setTitleVisibility(boolean visibility) {
        if (visibility) {
            tvTitle.setVisibility(View.GONE);
        }
        return this;
    }
    public DialogSignInTips setTextVisibility(boolean visibility) {
        if (visibility) {
            llTextString.setVisibility(View.GONE);
        }
        return this;
    }

    public DialogSignInTips setImg(int drawable) {
        ivIcon.setImageResource(drawable);
        return this;
    }

    @OnClick(R.id.shopping_dialog_close)
    public void onViewClicked() {
        dismiss();
    }
}

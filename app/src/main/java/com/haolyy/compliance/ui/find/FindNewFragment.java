package com.haolyy.compliance.ui.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.dialog.DialogNoTitleDoubleButton;
import com.haolyy.compliance.custom.dialog.DialogSignInTips;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.haolyy.compliance.config.Config.service_phone;

/**
 * Created by wangyin on 2017/7/26.
 */

public class FindNewFragment extends Fragment {
    @BindView(R.id.tv_weixin)
    TextView tvWeixin;
    @BindView(R.id.tv_call_service)
    TextView tvCallService;
    Unbinder unbinder;
    private View view;
    private DialogNoTitleDoubleButton dialogNoTitleDoubleButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.find_new_main, container, false);
        init();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void init() {
        dialogNoTitleDoubleButton = new DialogNoTitleDoubleButton(getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_weixin, R.id.tv_call_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_weixin:
                new DialogSignInTips(getActivity()).setImg(R.mipmap.img_qr_code).setTextVisibility(true).show();
                break;
            case R.id.tv_call_service:
                dialogNoTitleDoubleButton.setContent(service_phone, 21, true).setOnDoubleClickListener(new DialogNoTitleDoubleButton.OnDoubleClickListener() {
                    @Override
                    public void excuteLeft() {

                    }
                    @Override
                    public void excuteRight() {
                        WYUtils.CallPhone(getActivity(), 0x11);
                        dialogNoTitleDoubleButton.dismiss();
                    }
                }).show();
                break;
        }
    }
}

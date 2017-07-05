package com.haolyy.compliance.ui.my;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.ScaleTransformer;
import com.haolyy.compliance.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MemberActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.vp_card)
    ViewPager vpCard;
    private List mlist = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        ButterKnife.bind(this);
        vpCard.setOffscreenPageLimit(3);
        vpCard.setPageMargin(UIUtils.dip2px(-40));
        vpCard.setPageTransformer(false, new ScaleTransformer());
        mlist.add(1);
        mlist.add(2);
        mlist.add(3);
        vpCard.setAdapter(new MemberPagerAdapter(mlist, getBaseContext()));


    }


    public class MemberPagerAdapter extends PagerAdapter {

        public List list;
        public LayoutInflater inflate;
        private View itemcard;

        public MemberPagerAdapter(List list, Context mContext) {
            this.list = list;
            this.inflate = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            itemcard = this.inflate.inflate(R.layout.item_member_card, container,false);
            container.addView(itemcard);
            return itemcard;
        }
    }
}

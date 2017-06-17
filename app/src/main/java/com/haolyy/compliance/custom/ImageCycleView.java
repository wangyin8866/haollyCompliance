package com.haolyy.compliance.custom;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.haolyy.compliance.R;

import java.util.ArrayList;


public class ImageCycleView extends LinearLayout {

	public static final int URLTYPE = 0;

	public static final int DRAWABLETYPE = 1;

	private Context mContext;

	private ViewPagerCompt mAdvPager = null;

	private ImageCycleAdapter mAdvAdapter;

	private ViewGroup mGroup;

	private ImageView mImageView = null;

	private ImageView[] mImageViews = null;

	private int mImageIndex = 0;

	private float mScale;

	private ArrayList<Integer> imageDrawableList = new ArrayList<>();

	private ArrayList<String> imageUrlList = new ArrayList<>();

	public ImageCycleView(Context context) {
		super(context);
	}

	public ImageCycleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mScale = context.getResources().getDisplayMetrics().density;
		LayoutInflater.from(context).inflate(R.layout.ad_cycle_view, this);
		mAdvPager = (ViewPagerCompt) findViewById(R.id.adv_pager);
		mAdvPager.setOnPageChangeListener(new GuidePageChangeListener());
		mAdvPager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_UP:
						startImageTimerTask();
						break;
					default:
						stopImageTimerTask();
						break;
				}
				return false;
			}
		});
		mGroup = (ViewGroup) findViewById(R.id.viewGroup);
	}

	public void setImageResources(ArrayList<Integer> imageUrlList, ImageCycleViewListener imageCycleViewListener) {
		this.imageDrawableList = imageUrlList;
		mGroup.removeAllViews();

		final int imageCount = imageUrlList.size();
		if(imageCount > 1) {
			mImageViews = new ImageView[imageCount];
			for (int i = 0; i < imageCount; i++) {
				mImageView = new ImageView(mContext);
				int imageParams = (int) (mScale * 8 + 0.5f);
				int imagePadding = (int) (mScale * 2 + 0.5f);
				LayoutParams params = new LayoutParams(imageParams, imageParams);
				params.bottomMargin = imagePadding;
				params.topMargin = imagePadding;
				params.leftMargin = imagePadding;
				params.rightMargin = imagePadding;
				mImageView.setLayoutParams(params);
//			mImageView.setPadding(imagePadding, imagePadding, imagePadding, imagePadding);
				mImageViews[i] = mImageView;
				if (i == 0) {
					mImageViews[i].setBackgroundResource(R.mipmap.banner_point_checked);
				} else {
					mImageViews[i].setBackgroundResource(R.mipmap.banner_point);
				}
				mGroup.addView(mImageViews[i]);
			}
		}

		mAdvAdapter = new ImageCycleAdapter(mContext, DRAWABLETYPE, imageCycleViewListener);
		mAdvPager.setAdapter(mAdvAdapter);
		startImageTimerTask();
	}

   public void setImageUrl(ArrayList<String> imageUrl, ImageCycleViewListener imageCycleViewListener) {
	   this.imageUrlList = imageUrl;
	   mGroup.removeAllViews();

	   final int imageCount = imageUrl.size();
	   if(imageCount > 1) {
		   mImageViews = new ImageView[imageCount];
		   for (int i = 0; i < imageCount; i++) {
			   mImageView = new ImageView(mContext);
			   int imageParams = (int) (mScale * 8 + 0.5f);
			   int imagePadding = (int) (mScale * 2 + 0.5f);
			   LayoutParams params = new LayoutParams(imageParams, imageParams);
			   params.bottomMargin = imagePadding;
			   params.topMargin = imagePadding;
			   params.leftMargin = imagePadding;
			   params.rightMargin = imagePadding;
			   mImageView.setLayoutParams(params);
//			mImageView.setPadding(imagePadding, imagePadding, imagePadding, imagePadding);
			   mImageViews[i] = mImageView;
			   if (i == 0) {
				   mImageViews[i].setBackgroundResource(R.mipmap.banner_point);
			   } else {
				   mImageViews[i].setBackgroundResource(R.mipmap.banner_point);
			   }
			   mGroup.addView(mImageViews[i]);
		   }
	   }

	   mAdvAdapter = new ImageCycleAdapter(mContext, URLTYPE, imageCycleViewListener);
	   mAdvPager.setAdapter(mAdvAdapter);
	   startImageTimerTask();
   }


	public void startImageCycle() {
		startImageTimerTask();
	}

	public void pushImageCycle() {
		stopImageTimerTask();
	}

	private void startImageTimerTask() {
		stopImageTimerTask();
		mHandler.postDelayed(mImageTimerTask, 3000);
	}

	private void stopImageTimerTask() {
		mHandler.removeCallbacks(mImageTimerTask);
	}

	private Handler mHandler = new Handler();

	private Runnable mImageTimerTask = new Runnable() {

		@Override
		public void run() {
			if (mImageViews != null) {
				mAdvPager.setCurrentItem(mImageIndex + 1, true);
			}
//
		}
	};

	private final class GuidePageChangeListener implements ViewPagerCompt.OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int state) {
			if (state == ViewPagerCompt.SCROLL_STATE_IDLE)
				startImageTimerTask();
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int index) {
			if(mImageViews == null || mImageViews.length <= 0) return;
			mImageIndex = index;
			int realSize = mImageViews != null ? mImageViews.length : 0;
			final int realPos = index % realSize;
			mImageViews[realPos].setBackgroundResource(R.mipmap.banner_point);
			for (int i = 0; i < mImageViews.length; i++) {
				if (realPos != i) {
					mImageViews[i].setBackgroundResource(R.mipmap.banner_point);
				}
			}

		}

	}

	private class ImageCycleAdapter extends PagerAdapter {

		private ArrayList<ImageView> mImageViewCacheList;

		private int type = -1;

		private ImageCycleViewListener mImageCycleViewListener;

		private Context mContext;

		public ImageCycleAdapter(Context context, int type, ImageCycleViewListener imageCycleViewListener) {
			mContext = context;
			this.type = type;
			mImageCycleViewListener = imageCycleViewListener;
			mImageViewCacheList = new ArrayList<ImageView>();
		}



		@Override
		public int getCount() {
			if(type == URLTYPE) {
				return imageUrlList.size() >1?  Integer.MAX_VALUE : imageUrlList.size();
			}else if(type == DRAWABLETYPE) {
				return imageDrawableList.size() >1?  Integer.MAX_VALUE : imageDrawableList.size();
			}else {
				return 0;
			}

		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == obj;
		}

		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			if(type == URLTYPE) {
				int realSize = imageUrlList != null ? imageUrlList.size() : 0;
				if(realSize <= 0) {
					return null;
				}

				final int realPos = position % realSize;
				String imageUrl = imageUrlList.get(realPos);
				ImageView imageView = null;
				if (mImageViewCacheList.isEmpty()) {
					imageView = new ImageView(mContext);
					imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					imageView.setScaleType(ImageView.ScaleType.FIT_XY);

				} else {
					imageView = mImageViewCacheList.remove(0);
				}
				imageView.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						mImageCycleViewListener.onImageClick(realPos, v);
					}
				});
				imageView.setTag(imageUrl);
				container.addView(imageView);
				mImageCycleViewListener.displayImage(imageUrl, imageView);
				return imageView;
			}else if(type == DRAWABLETYPE) {
				int realSize = imageDrawableList != null ? imageDrawableList.size() : 0;
				if(realSize <= 0) {
					return null;
				}

				final int realPos = position % realSize;
				int imageUrl = imageDrawableList.get(realPos);
				ImageView imageView = null;
				if (mImageViewCacheList.isEmpty()) {
					imageView = new ImageView(mContext);
					imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					imageView.setScaleType(ImageView.ScaleType.FIT_XY);

				} else {
					imageView = mImageViewCacheList.remove(0);
				}
				imageView.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						mImageCycleViewListener.onImageClick(realPos, v);
					}
				});
				imageView.setTag(imageUrl);
				container.addView(imageView);
				mImageCycleViewListener.displayImage(imageUrl, imageView);
				return imageView;
			}else {
				return null;
			}


		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			ImageView view = (ImageView) object;
			container.removeView(view);
			mImageViewCacheList.add(view);
		}

	}

	public static interface ImageCycleViewListener {

		public void displayImage(int imageURL, ImageView imageView);

		public void displayImage(String imageURL, ImageView imageView);

		public void onImageClick(int position, View imageView);
	}

}

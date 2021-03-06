package com.geno.chaoli.forum.meta;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.geno.chaoli.forum.R;

import java.io.File;

public class AvatarView extends RelativeLayout
{
	final String TAG = "AvatarView";

	Context mContext;
	String mImagePath, mUsername;
	int mUserId;
	Boolean firstLoad = true;
	RelativeLayout v;
	TextView t;
	ImageView i;
	/*public AvatarView(final Context context, final String imagePath, int userId, String username, float scale){
		this(context, null);
		update(context, imagePath, userId, username);
		setScaleX(scale);
		setScaleY(scale);
	}*/
	public AvatarView(final Context context, final String imagePath, int userId, String username)
	{
		this(context, null);
		update(imagePath, userId, username);
	}

	// adjust the size
	public void scale(int length){
		int lengthdp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, length, getResources().getDisplayMetrics());
		ViewGroup.LayoutParams layoutParams = getLayoutParams();
		layoutParams.height = lengthdp;
		layoutParams.width = lengthdp;
		t.setTextSize((float)20 * lengthdp / 80); //这个80显示效果好一些,然而我不知道为什么
	}
	public void update(String imagePath, int userId, String username) {
		setVisibility(VISIBLE);
		mImagePath = imagePath;
		mUserId = userId;
		mUsername = username;
		/*if(firstLoad) {
			init(context);
		}*/

		if (Constants.NONE.equals(imagePath) || imagePath == null)
		{
			t.setText(String.format("%s", username.toUpperCase().charAt(0)));
			i.setVisibility(INVISIBLE);
			t.setVisibility(VISIBLE);
		}
		else
		{
			Glide.with(mContext).load(Constants.avatarURL + "avatar_" + userId + "." + imagePath).into(i);
			t.setVisibility(INVISIBLE);
			i.setVisibility(VISIBLE);
		}
	}

	/**
	 * 用于在设置页面的改变头像功能中显示新头像
	 * @param file 选择的新头像文件
     */
	public void update(File file) {
		setVisibility(VISIBLE);
		Glide.with(mContext).load(file).into(i);
		t.setVisibility(INVISIBLE);
		i.setVisibility(VISIBLE);
	}

	public void init(Context context){
		setVisibility(INVISIBLE);
		v = (RelativeLayout) inflate(context, R.layout.avatar_view, this);
		t = (TextView) v.findViewById(R.id.avatarTxt);
		i = (ImageView) v.findViewById(R.id.avatarImg);
		t.setTextSize(20);
		mContext = context;
		firstLoad = false;
	}

	public void setLoginImage(Context context){
		setVisibility(VISIBLE);
		if(firstLoad)
			init(context);
		Glide.with(context).load(R.drawable.ic_account_plus_white_48dp).into(i);
		t.setVisibility(INVISIBLE);
	}

	public AvatarView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public AvatarView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public String getImagePath() {
		return mImagePath;
	}

	public String getUsername() {
		return mUsername;
	}

	public int getUserId() {
		return mUserId;
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public AvatarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
	{
		super(context, attrs, defStyleAttr, defStyleRes);
		init(context);
	}
}

package com.baway.liyinggang;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * 类注释：自定义组合控件
 * 创建人： Liyinggang
 * 时间： 2017/7/10 9:21
 */

public class MyView extends LinearLayout implements View.OnClickListener {
	private int con = 1;

	private Button mBtnAdd;
	private Button mBtnDown;
	private EditText mEditText;

	public MyView(Context context) {
		this(context, null);
	}

	public MyView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		//获取布局和控件
		View view = View.inflate(context, R.layout.myview, this);
		mBtnAdd = (Button) view.findViewById(R.id.btn_add);
		mBtnDown = (Button) view.findViewById(R.id.btn_down);
		mEditText = (EditText) view.findViewById(R.id.edit_con);
		//添加监听事件
		mBtnAdd.setOnClickListener(this);
		mBtnDown.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		//获取editText中的内容
		String s = mEditText.getText().toString().trim();
		if (s!=""&&s!=null){
			con = Integer.valueOf(s);
		}else if(s==""){
			con = 0;
		}

		switch (v.getId()) {
			//添加按钮的点击事件
			case R.id.btn_add:
					con++;
					mEditText.setText(con + "");
				break;
			//减少按钮的点击事件
			case R.id.btn_down:
				if (con > 0) {
					con--;
					mEditText.setText(con + "");
				}
				break;
		}
	}

}

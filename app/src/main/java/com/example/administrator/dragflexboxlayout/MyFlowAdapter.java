package com.example.administrator.dragflexboxlayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.dragflexboxlayout.flow.FlowLayout;
import com.google.android.flexbox.FlexboxLayout;

/**
 * Created by Lbin on 2017/11/1.
 */

public class MyFlowAdapter extends FlowLayout.FlowAdapter<TagModel> {


    public MyFlowAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResource(int type) {
        return R.layout.item_of_layout;
    }

    @Override
    public View getView(int position, View convertView, ViewHolder holder) {
        TagModel model = getItem(position);
        TextView textView = holder.getView(R.id.text);
        textView.setText(model.getText());
        GradientDrawable bg = buildGradientDrawable(mContext, model.getBgColor(), model.getCornerDip(), model.getStrokeWidthDip(), model.getStrokeColor());
        textView.setBackground(bg);
        textView.setTextColor(Color.WHITE);
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, mContext.getResources().getDisplayMetrics());
        lp.setMargins(margin, margin, margin, margin);
        textView.setLayoutParams(lp);
        return textView;
    }

    public GradientDrawable buildGradientDrawable(Context context, int color, int cornerDip, int strokeWidthDip, int strokeColor) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, cornerDip, context.getResources().getDisplayMetrics()));
        drawable.setStroke((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, strokeWidthDip, context.getResources().getDisplayMetrics()), strokeColor);
        return drawable;
    }
}

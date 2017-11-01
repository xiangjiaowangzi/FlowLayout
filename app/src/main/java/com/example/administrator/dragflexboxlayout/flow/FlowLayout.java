package com.example.administrator.dragflexboxlayout.flow;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lbin on 2017/11/1.
 */

public class FlowLayout extends FlexboxLayout {

    FlowAdapter mAdapter;
    AdapterDataSetObserver mDataSetObserver;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAdapter(FlowAdapter adapter) {
        if (mAdapter != null && mDataSetObserver != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }
        if (adapter != null) {
            mAdapter = adapter;
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            changeData();
        }
    }

    void changeData() {
        removeAllViews();
        int count = mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            View childView = mAdapter.getView(i, null, this);
            ViewGroup.LayoutParams lp = childView.getLayoutParams();
            addView(childView);
        }
        requestLayout();
    }

    class AdapterDataSetObserver extends DataSetObserver {
        @Override
        public void onInvalidated() {
            changeData();
        }

        @Override
        public void onChanged() {
            changeData();
        }
    }


    public static abstract class FlowAdapter<T> extends BaseAdapter {

        protected Context mContext;
        protected List<T> mList;

        public FlowAdapter(Context context) {
            this.mContext = context;
            mList = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public T getItem(int position) {
            return position >= 0 && position < mList.size() ? mList.get(position) : null;
        }

        public List<T> getList() {
            return mList;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addAll(List<T> elem) {
            mList.addAll(elem);
            notifyDataSetChanged();
        }

        public void remove(T elem) {
            mList.remove(elem);
            notifyDataSetChanged();
        }

        public void remove(int index) {
            int size = mList.size();
            if (index >= size) {
                return;
            }
            mList.remove(index);
            notifyDataSetChanged();
        }

        public void replaceAll(List<T> elem) {
            if (elem != null) {
                mList.clear();
                mList.addAll(elem);
                notifyDataSetChanged();
            }
        }

        public void set(int index, T elem) {
            mList.set(index, elem);
            notifyDataSetChanged();
        }

        public void add(T elem, boolean notify) {
            mList.add(elem);
            if (notify) {
                notifyDataSetChanged();
            }
        }

        public void set(int index, T elem, boolean notify) {
            mList.set(index, elem);
            if (notify) {
                notifyDataSetChanged();
            }
        }

        public void add(T elem) {
            mList.add(elem);
            notifyDataSetChanged();
        }

        public void add(int index, T elem) {
            mList.add(index, elem);
            notifyDataSetChanged();
        }

        public void swap(int from, int to, boolean notify) {
            int size = this.mList.size();
            if (from < size && to < size && from != to) {
                T temp = getItem(from);
                this.mList.set(from, getItem(to));
                this.mList.set(to, temp);
                if (notify) {
                    notifyDataSetChanged();
                }
            }
        }

        public void reIndex(int index, int toIndex, boolean notify) {
            int size = this.mList.size();
            if (index < size && toIndex < size && index != toIndex) {
                T temp = getItem(index);
                if (index > toIndex) {
                    mList.add(toIndex, temp);
                    mList.remove(index + 1);
                } else {
                    mList.remove(index);
                    mList.add(toIndex, temp);
                }
                if (notify) {
                    notifyDataSetChanged();
                }
            }
        }

        public void clear() {
            mList.clear();
            notifyDataSetChanged();
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (null == convertView) {
                convertView = getConvertView(mContext, parent, position);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            return getView(position, convertView, holder);
        }

        public View getConvertView(Context mContext, ViewGroup parent, int position) {
            return View.inflate(mContext, getItemResource(getItemViewType(position)), null);
        }

        protected abstract int getItemResource(int type);

        public abstract View getView(int position, View convertView, ViewHolder holder);

        public static class ViewHolder {
            private SparseArray<View> views = new SparseArray<View>();
            private View convertView;

            public ViewHolder(View convertView) {
                this.convertView = convertView;
            }

            @SuppressWarnings("unchecked")
            public <T extends View> T getView(int resId) {
                View v = views.get(resId);
                if (null == v && convertView != null) {
                    v = convertView.findViewById(resId);
                    views.put(resId, v);
                }
                return (T) v;
            }
        }

    }

}

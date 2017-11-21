package com.mavsforlife.victor.mylab.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mavsforlife.victor.mylab.R;
import com.mavsforlife.victor.mylab.model.Goods;
import com.mavsforlife.victor.mylab.widget.EllipsizingTextView;
import com.mavsforlife.victor.mylab.widget.ninegridlayout.ImageNineGridView;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 2017/11/13.
 * Email: wwmdirk@gmail.com
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private Context mContext;
    private List<Goods> mList;
    private LayoutInflater mLayoutInflater;

    public MainAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            return new ViewHolder(mLayoutInflater.inflate(R.layout.item_good, parent, false));
        } else {
            return new FooterHolder(mLayoutInflater.inflate(R.layout.item_image_grid_footer, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            final Goods goods = mList.get(position);
            ViewHolder h = (ViewHolder) holder;
            h.mTvMsg.setText(goods.getMessage(), goods.isCollapsed());
            h.mTvMsg.setListener(new EllipsizingTextView.OnExpandStateChangeListener() {
                @Override
                public void onExpandStateChanged(boolean isExpanded) {
                    goods.setCollapsed(isExpanded);
                }
            });
            h.mImageNineGridView.render(goods.getImages());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mList.size()) {
            return TYPE_ITEM;
        } else {
            return TYPE_FOOTER;
        }
    }

    public void setData(List<Goods> list) {
        if (list == null) return;
        mList = list;
        notifyDataSetChanged();
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvTitle;
        private EllipsizingTextView mTvMsg;
        private ImageView mIvAvatar;
        private ImageNineGridView mImageNineGridView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvMsg = itemView.findViewById(R.id.tv_content);
            mIvAvatar = itemView.findViewById(R.id.iv_avatar);
            mImageNineGridView = itemView.findViewById(R.id.img_view);
        }
    }

    static class FooterHolder extends RecyclerView.ViewHolder {

        TextView mTvNoMore;

        public FooterHolder(View itemView) {
            super(itemView);
            mTvNoMore = itemView.findViewById(R.id.tv_no_more);
        }
    }
}

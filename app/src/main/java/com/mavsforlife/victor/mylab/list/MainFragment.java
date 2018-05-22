package com.mavsforlife.victor.mylab.list;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mavsforlife.victor.mylab.R;
import com.mavsforlife.victor.mylab.model.Goods;
import com.mavsforlife.victor.mylab.widget.ItemDividerDecoration;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements MainFragmentContract.View,
        MainAdapter.ShareListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView mTvNotice;
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private MainFragmentContract.Presenter mPresenter;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = new MainFragmentPresenter(getActivity(), this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mTvNotice = v.findViewById(R.id.tv_notice);
        mRecyclerView = v.findViewById(R.id.rv_good);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new ItemDividerDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mAdapter = new MainAdapter(getActivity(), this);
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.onLoadGoods();
        return v;
    }

    @Override
    public void loadGoods(List<Goods> list) {
        mAdapter.setData(list);
    }

    @Override
    public void shareTo(final List<File> list) {
        if (list == null || list.size() == 0) {
            Toast.makeText(getActivity(), "没有图片", Toast.LENGTH_SHORT).show();
            return;
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ClipboardManager cmb = (ClipboardManager)getActivity().getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", "测试一键分享文字内容啦啦啦啦啦啦");
                cmb.setPrimaryClip(clipData);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND_MULTIPLE);
                intent.setType("image/*");
                ArrayList<Uri> uris = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    Uri uri;
                    File file = list.get(i);
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        try {
                            uri =Uri.parse(android.provider.MediaStore.Images.Media.insertImage(getActivity().getContentResolver(),
                                    file.getAbsolutePath(), i + ".jpg", null));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            uri = null;
                        }
                    } else {
                        uri = Uri.fromFile(file);
                    }
                    uris.add(uri);
                }

                intent.putExtra(Intent.EXTRA_STREAM, uris);
                intent.putExtra(Intent.EXTRA_TEXT, "测试一键分享文字内容啦啦啦啦啦啦");
                intent.putExtra("Kdescription", "测试一键分享图文到朋友圈");
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    intent = Intent.createChooser(intent, "share");
                }
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onShare(int position) {
        mPresenter.onShare(position);
    }

    Button btn1, btn2, btn3, btn4, btn5;
    private void onbuttonEnable() {
        io.reactivex.Observable.timer(2, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        btn1.setEnabled(false);
                        btn2.setEnabled(false);
                        btn3.setEnabled(false);
                        btn4.setEnabled(false);
                        btn5.setEnabled(false);
                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        btn1.setEnabled(true);
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                    }
                });

    }
}

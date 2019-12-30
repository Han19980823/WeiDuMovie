package com.bw.movie.view.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.bw.movie.R;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.SelectBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.ChaSuccessAdapter;
import com.bw.movie.dapter.SouAdapter;
import com.bw.movie.presenter.Presenter2;

public class SelectActivity extends BaseActivity implements Icontract.Iselect {


    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.recy_sou)
    RecyclerView recySou;

    public Unbinder bind;
    private Presenter2 presenter;
    private SouAdapter homeAdapter;
    SelectBean selectBeans;
    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter = new Presenter2();
        presenter.getMovie1();
        return presenter;
    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recySou.setLayoutManager(manager);
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_select;
    }


    @Override
    public void movieSuccess1(MovieBean movieBean) {
        Toast.makeText(this, movieBean.getMessage(), Toast.LENGTH_SHORT).show();
        List<MovieBean.ResultBean> movieBeanResult = movieBean.getResult();
        homeAdapter = new SouAdapter( this,movieBeanResult);
        recySou.setAdapter(homeAdapter);
    }


    @OnClick(R.id.btn_sou1)
    public void setEdName(View view){
        String name = edName.getText().toString();
        presenter.getSelect(name);
        if (selectBeans!=null){
            List<SelectBean.ResultBean> result = selectBeans.getResult();
            ChaSuccessAdapter adapter = new ChaSuccessAdapter(this,result);
            recySou.setAdapter(adapter);
        }
    }
    @Override
    public void Select(SelectBean selectBean) {
        selectBeans = selectBean;

    }
}

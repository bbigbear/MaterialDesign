package com.example.design;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<Actor> actors=new ArrayList<Actor>();
    private String[] names = { "朱茵", "张柏芝", "张敏", "巩俐", "黄圣依", "赵薇", "莫文蔚", "如花" };

    private String[] pics = { "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        actors.add(new Actor("朱茵","p1"));
        getActionBar().setTitle("星女郎");
        //得到RecyclerView
        recyclerView= (RecyclerView) findViewById(R.id.list);
        //设置LinerlayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置固定大小
        recyclerView.setHasFixedSize(true);
        //初始化自定义适配器
        myAdapter=new MyAdapter(this,actors);
        //设置适配器
        recyclerView.setAdapter(myAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            // 当点击actionbar上的添加按钮时，向adapter中添加一个新数据并通知刷新
            case R.id.action_add:
                if (myAdapter.getItemCount() != names.length) {
                    actors.add(new Actor(names[myAdapter.getItemCount()], pics[myAdapter.getItemCount()]));
                    recyclerView.scrollToPosition(myAdapter.getItemCount() - 1);
                    myAdapter.notifyDataSetChanged();
                }
                return true;
            // 当点击actionbar上的删除按钮时，向adapter中移除最后一个数据并通知刷新
            case R.id.action_remove:
                if (myAdapter.getItemCount() != 0) {
                    actors.remove(myAdapter.getItemCount()-1);
                    recyclerView.scrollToPosition(myAdapter.getItemCount() - 1);
                    myAdapter.notifyDataSetChanged();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

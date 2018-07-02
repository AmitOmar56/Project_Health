package com.lifeplaytrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.lifeplaytrip.R;
import com.lifeplaytrip.adapter.NewsAdapter;
import com.lifeplaytrip.adapter.utils;
import com.lifeplaytrip.model.News;

import java.util.ArrayList;
import java.util.List;

import static com.lifeplaytrip.adapter.utils.dpToPx;


public class MusicListActivity extends AppCompatActivity implements NewsAdapter.News_OnItemClicked {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*****************code For Card View*****************/

        recyclerView = (RecyclerView) findViewById(R.id.notification_recycler_view);
        newsList = new ArrayList<>();
        adapter = new NewsAdapter(this, newsList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new utils.GridSpacingItemDecoration(2, dpToPx(this, 10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
        prepareAlbums();

        /*****************code For Card View*****************/
    }

    @Override
    public void news_onItemClick(int position) {
        News news = newsList.get(position);
        Toast.makeText(this, news.getNews_name(), Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,MeditationActivity.class));

    }

    /*******************Code for RecyclerView****************/
    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] images = new int[]{
                R.drawable.medi4,
                R.drawable.medi4,
                R.drawable.medi4,
                R.drawable.medi4,
                R.drawable.medi4,
                R.drawable.medi4,
        };

        News a = new News("Classical Music", images[0]);
        newsList.add(a);

        a = new News("Gregorian Chanting and Primordial Sounds", images[1]);
        newsList.add(a);

        a = new News("Nature Sounds", images[2]);
        newsList.add(a);

        a = new News("Instrumental Music", images[3]);
        newsList.add(a);

        a = new News("Christian Music", images[4]);
        newsList.add(a);

        a = new News("Classical Music", images[5]);
        newsList.add(a);

        a = new News("Instrumental Music", images[2]);
        newsList.add(a);


        adapter.notifyDataSetChanged();
    }

    /*******************Code for RecyclerView****************/
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}

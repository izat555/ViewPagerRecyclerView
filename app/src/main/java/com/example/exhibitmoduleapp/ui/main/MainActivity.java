package com.example.exhibitmoduleapp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exhibitmoduleapp.R;
import com.example.exhibitmoduleapp.ui.adapter.ExhibitsAdapter;
import com.example.fileexhibitsloader.FileExhibitsLoader;
import com.example.fileexhibitsloader.IRetrofitCallback;
import com.example.model.Exhibit;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IRetrofitCallback {
    private RecyclerView mRvExhibits;
    private FileExhibitsLoader mFileExhibitsLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvExhibits = findViewById(R.id.rv_exhibits);

        mFileExhibitsLoader = new FileExhibitsLoader(this);
        mFileExhibitsLoader.getExhibitList();
    }

    @Override
    public void onRetrofitClearWork(List<Exhibit> exhibitList) {
        mRvExhibits.setLayoutManager(new LinearLayoutManager(this));
        mRvExhibits.setHasFixedSize(true);
        mRvExhibits.setAdapter(new ExhibitsAdapter(this, exhibitList));
    }

    @Override
    public void onRetrofitError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

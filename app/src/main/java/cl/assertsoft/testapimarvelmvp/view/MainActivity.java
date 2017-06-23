package cl.assertsoft.testapimarvelmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.adapter.ListaCharactersAdapter;
import cl.assertsoft.testapimarvelmvp.presenter.MainActivityPresenter;
import cl.assertsoft.testapimarvelmvp.view.interfaces.MainActivityView;
import cl.assertsoft.testapimarvelmvp.model.Result;
import cl.assertsoft.testapimarvelmvp.presenter.MainActivityPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private MainActivityPresenter presenter;
    ListaCharactersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new MainActivityPresenterImpl(this, this);
        presenter.getDataCharacters();

        adapter = new ListaCharactersAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void actionProgress(boolean show) {
        if (show) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResults(List<Result> characters) {
        if (adapter != null) {
            adapter.addCharacters(characters);
            adapter.setItemClickListener(new ListaCharactersAdapter.ItemClickListener() {
                @Override
                public void onItemClick(Result result, int position) {
                    presenter.convertDataToString(result);
                }
            });
        }
    }

    @Override
    public void goToDetail(String character) {
//        Log.d("TEST",character.getName());
        Intent intent = new Intent(this,DetalleCharacterActivity.class);
        intent.putExtra("info",character);
        startActivity(intent);
    }


}

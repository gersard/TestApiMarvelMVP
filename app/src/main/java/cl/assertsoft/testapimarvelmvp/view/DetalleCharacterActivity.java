package cl.assertsoft.testapimarvelmvp.view;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.model.Result;
import cl.assertsoft.testapimarvelmvp.presenter.DetailCharacterPresenter;
import cl.assertsoft.testapimarvelmvp.presenter.DetailCharacterPresenterImpl;
import cl.assertsoft.testapimarvelmvp.view.interfaces.DetailCharacterView;

public class DetalleCharacterActivity extends AppCompatActivity implements DetailCharacterView {

    @BindView(R.id.image_character_detail)
    ImageView imageCharacter;
    @BindView(R.id.txt_character_name_detail)
    TextView txtCharacterName;
    @BindView(R.id.scroll_view_detail)
    NestedScrollView scrollView;
    @BindView(R.id.txt_character_info_name_detail)
    TextView txtCharacterInfo;

    private DetailCharacterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_character);
        ButterKnife.bind(this);

        Animation toLeft = AnimationUtils.loadAnimation(this, R.anim.left_slide);
        imageCharacter.startAnimation(toLeft);

        Animation toUp = AnimationUtils.loadAnimation(this, R.anim.top_slide);
        scrollView.startAnimation(toUp);

        presenter = new DetailCharacterPresenterImpl(this, this);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            presenter.convertDataToObject(bundle.getString("info"));
        }
    }

    @Override
    public void showInfo(Result character) {
        Glide.with(this)
                .load(character.getThumbnail().getPath()+"."+character.getThumbnail().getExtension())
                .into(imageCharacter);
        txtCharacterName.setText(character.getName());
        txtCharacterInfo.setText(character.getDescription());
    }
}

package cl.assertsoft.testapimarvelmvp.view;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.assertsoft.testapimarvelmvp.R;

public class DetalleCharacterActivity extends AppCompatActivity {

    @BindView(R.id.image_character_detail)
    ImageView imageCharacter;
    @BindView(R.id.txt_character_name_detail)
    TextView txtCharacterName;
    @BindView(R.id.scroll_view_detail)
    NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_character);
        ButterKnife.bind(this);

        Animation toLeft = AnimationUtils.loadAnimation(this, R.anim.left_slide);
        imageCharacter.startAnimation(toLeft);

        Animation toUp = AnimationUtils.loadAnimation(this, R.anim.top_slide);
        scrollView.startAnimation(toUp);
    }
}

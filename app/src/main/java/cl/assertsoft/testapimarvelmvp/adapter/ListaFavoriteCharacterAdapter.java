package cl.assertsoft.testapimarvelmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.model.CharacterRealm;
import io.realm.RealmResults;

/**
 * Created by Gerardo on 08-07-2017.
 */

public class ListaFavoriteCharacterAdapter extends RecyclerView.Adapter<ListaFavoriteCharacterAdapter.FavoriteCharacterViewHolder> {

    private Context context;
    private RealmResults<CharacterRealm> characters;

    public ListaFavoriteCharacterAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FavoriteCharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.view_holder_favorite_character, parent, false);
        return new FavoriteCharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavoriteCharacterViewHolder holder, int position) {
        CharacterRealm currentCharacter = characters.get(position);
        holder.setTxtCharacterName(currentCharacter.getCharacterName());
        holder.setCheckFavorite(currentCharacter.isCharacterFavorite());
        holder.setImgCharacter(currentCharacter.getUrlImage());
        Log.d("IMAGE",currentCharacter.getUrlImage());
    }

    @Override
    public int getItemCount() {
        return (characters != null) ? characters.size() : 0;
    }

    public void addCharacters(RealmResults<CharacterRealm> characters){
        if (characters != null){
            this.characters = characters;
            notifyDataSetChanged();
        }
    }

    public class FavoriteCharacterViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_view_favorite_character_photo)
        ImageView imgCharacter;
        @BindView(R.id.txt_favorite_character_name)
        TextView txtCharacterName;
        @BindView(R.id.check_favorite_character_favorite)
        CheckBox checkFavorite;

        public FavoriteCharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setImgCharacter(String urlImage) {
            Glide.with(context).load(urlImage).into(imgCharacter);
        }

        public void setTxtCharacterName(String characterName) {
            this.txtCharacterName .setText(characterName);
        }

        public void setCheckFavorite(boolean isFavorite) {
            this.checkFavorite.setChecked(isFavorite);
        }
    }


}

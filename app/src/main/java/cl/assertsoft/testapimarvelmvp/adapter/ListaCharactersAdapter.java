package cl.assertsoft.testapimarvelmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.model.CharacterRealm;
import cl.assertsoft.testapimarvelmvp.model.Result;
import io.realm.Realm;

/**
 * Created by Gerardo on 17-06-2017.
 */

public class ListaCharactersAdapter extends RecyclerView.Adapter<ListaCharactersAdapter.CharacterViewHolder> {

    Context context;
    List<Result> results;
    private ItemClickListener itemClickListener;

    public ListaCharactersAdapter(Context context) {
        this.context = context;
        results = new ArrayList<>();
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.view_holder_character, parent, false);
        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CharacterViewHolder holder, int position) {
        final Result currentCharacter = results.get(position);
        holder.setCharacterPhoto(String.format("%1$s.%2$s", currentCharacter.getThumbnail().getPath(),
                currentCharacter.getThumbnail().getExtension()));
        holder.setTxtCharacterName(currentCharacter.getName());
        holder.setChecked(isCharacterFavorite(currentCharacter.getName()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(currentCharacter, holder.getAdapterPosition());
                }
            }
        });

        holder.checkFavorite.setOnCheckedChangeListener(null);

        holder.checkFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (itemClickListener != null && buttonView.isShown()) {
                    itemClickListener.onCheckedChangeListener(currentCharacter, isChecked);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (results != null) ? results.size() : 0;
    }

    public void addCharacters(List<Result> results) {
        if (results != null){
//            this.results.addAll(results);
            this.results = results;
//            notifyItemRangeInserted(0,results.size());
//            notifyItemRangeChanged(0,results.size());
            notifyDataSetChanged();
        }
    }

    public boolean isCharacterFavorite(String name){
        Realm realm = Realm.getDefaultInstance();
        CharacterRealm characterRealm = realm.where(CharacterRealm.class).equalTo(CharacterRealm.CHARACTER_NAME,name).findFirst();
        if (characterRealm == null){
            return false;
        }else{
            return characterRealm.isCharacterFavorite();
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Result result, int position);
        void onCheckedChangeListener(Result character, boolean isFavorite);
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view_character_photo)
        ImageView ivCharacterPhoto;
        @BindView(R.id.txt_character_name)
        TextView txtCharacterName;
        @BindView(R.id.check_character_favorite)
        CheckBox checkFavorite;
        View itemView;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }

        public void setCharacterPhoto(String photoUrl) {
            Glide.with(context).load(photoUrl).into(ivCharacterPhoto);
        }

        public void setTxtCharacterName(String characterName) {
            this.txtCharacterName.setText(characterName);
        }

        public void setChecked(boolean isChecked){
            checkFavorite.setChecked(isChecked);
        }
    }

}

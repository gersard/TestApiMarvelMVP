package cl.assertsoft.testapimarvelmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public class ListaCharactersAdapter extends RecyclerView.Adapter<ListaCharactersAdapter.CharacterViewHolder> {

    Context context;
    List<Result> results;

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
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        Result currentCharacter = results.get(position);
        holder.setCharacterPhoto(String.format("%1$s.%2$s", currentCharacter.getThumbnail().getPath(),
                currentCharacter.getThumbnail().getExtension()));
        holder.setTxtCharacterName(currentCharacter.getName());
    }

    @Override
    public int getItemCount() {
        return (results != null) ? results.size() : 0;
    }

    public void addCharacters(List<Result> results) {
        if (results != null){
            this.results.addAll(results);
            notifyItemRangeInserted(getItemCount()-1,results.size());
        }
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view_character_photo)
        ImageView ivCharacterPhoto;
        @BindView(R.id.txt_character_name)
        TextView txtCharacterName;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setCharacterPhoto(String photoUrl) {
            Glide.with(context).load(photoUrl).into(ivCharacterPhoto);
        }

        public void setTxtCharacterName(String characterName) {
            this.txtCharacterName.setText(characterName);
        }
    }

}

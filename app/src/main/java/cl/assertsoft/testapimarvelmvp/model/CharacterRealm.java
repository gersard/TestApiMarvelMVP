package cl.assertsoft.testapimarvelmvp.model;

import cl.assertsoft.testapimarvelmvp.MyApplication;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gerardo on 24-06-2017.
 */

public class CharacterRealm extends RealmObject {

    public static final String CHARACTER_ID = "characterId";
    public static final String CHARACTER_NAME = "characterName";

    @PrimaryKey
    private int characterId;
    private String characterName;
    private String characterDescription;
    private boolean characterFavorite;

    public CharacterRealm() {
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId() {
        this.characterId = MyApplication.characterID.incrementAndGet();
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterDescription() {
        return characterDescription;
    }

    public void setCharacterDescription(String characterDescription) {
        this.characterDescription = characterDescription;
    }

    public boolean isCharacterFavorite() {
        return characterFavorite;
    }

    public void setCharacterFavorite(boolean characterFavorite) {
        this.characterFavorite = characterFavorite;
    }
}

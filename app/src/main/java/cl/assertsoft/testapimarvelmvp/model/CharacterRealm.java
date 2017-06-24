package cl.assertsoft.testapimarvelmvp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gerardo on 24-06-2017.
 */

public class CharacterRealm extends RealmObject {

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

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
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

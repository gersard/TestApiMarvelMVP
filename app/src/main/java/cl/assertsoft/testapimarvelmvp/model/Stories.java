
package cl.assertsoft.testapimarvelmvp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Stories {

    @SerializedName("available")
    private Long mAvailable;
    @SerializedName("collectionURI")
    private String mCollectionURI;
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("returned")
    private Long mReturned;

    public Long getAvailable() {
        return mAvailable;
    }

    public String getCollectionURI() {
        return mCollectionURI;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public Long getReturned() {
        return mReturned;
    }

    public static class Builder {

        private Long mAvailable;
        private String mCollectionURI;
        private List<Item> mItems;
        private Long mReturned;

        public Stories.Builder withAvailable(Long available) {
            mAvailable = available;
            return this;
        }

        public Stories.Builder withCollectionURI(String collectionURI) {
            mCollectionURI = collectionURI;
            return this;
        }

        public Stories.Builder withItems(List<Item> items) {
            mItems = items;
            return this;
        }

        public Stories.Builder withReturned(Long returned) {
            mReturned = returned;
            return this;
        }

        public Stories build() {
            Stories Stories = new Stories();
            Stories.mAvailable = mAvailable;
            Stories.mCollectionURI = mCollectionURI;
            Stories.mItems = mItems;
            Stories.mReturned = mReturned;
            return Stories;
        }

    }

}

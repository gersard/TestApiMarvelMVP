
package cl.assertsoft.testapimarvelmvp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Events {

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

        public Events.Builder withAvailable(Long available) {
            mAvailable = available;
            return this;
        }

        public Events.Builder withCollectionURI(String collectionURI) {
            mCollectionURI = collectionURI;
            return this;
        }

        public Events.Builder withItems(List<Item> items) {
            mItems = items;
            return this;
        }

        public Events.Builder withReturned(Long returned) {
            mReturned = returned;
            return this;
        }

        public Events build() {
            Events Events = new Events();
            Events.mAvailable = mAvailable;
            Events.mCollectionURI = mCollectionURI;
            Events.mItems = mItems;
            Events.mReturned = mReturned;
            return Events;
        }

    }

}

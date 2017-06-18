
package cl.assertsoft.testapimarvelmvp.model;


import com.google.gson.annotations.SerializedName;


public class Item {

    @SerializedName("name")
    private String mName;
    @SerializedName("resourceURI")
    private String mResourceURI;
    @SerializedName("type")
    private String mType;

    public String getName() {
        return mName;
    }

    public String getResourceURI() {
        return mResourceURI;
    }

    public String getType() {
        return mType;
    }

    public static class Builder {

        private String mName;
        private String mResourceURI;
        private String mType;

        public Item.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Item.Builder withResourceURI(String resourceURI) {
            mResourceURI = resourceURI;
            return this;
        }

        public Item.Builder withType(String type) {
            mType = type;
            return this;
        }

        public Item build() {
            Item Item = new Item();
            Item.mName = mName;
            Item.mResourceURI = mResourceURI;
            Item.mType = mType;
            return Item;
        }

    }

}

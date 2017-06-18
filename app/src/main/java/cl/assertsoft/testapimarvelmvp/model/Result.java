
package cl.assertsoft.testapimarvelmvp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Result {

    @SerializedName("comics")
    private Comics mComics;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("events")
    private Events mEvents;
    @SerializedName("id")
    private Long mId;
    @SerializedName("modified")
    private String mModified;
    @SerializedName("name")
    private String mName;
    @SerializedName("resourceURI")
    private String mResourceURI;
    @SerializedName("series")
    private Series mSeries;
    @SerializedName("stories")
    private Stories mStories;
    @SerializedName("thumbnail")
    private Thumbnail mThumbnail;
    @SerializedName("urls")
    private List<Url> mUrls;

    public Comics getComics() {
        return mComics;
    }

    public String getDescription() {
        return mDescription;
    }

    public Events getEvents() {
        return mEvents;
    }

    public Long getId() {
        return mId;
    }

    public String getModified() {
        return mModified;
    }

    public String getName() {
        return mName;
    }

    public String getResourceURI() {
        return mResourceURI;
    }

    public Series getSeries() {
        return mSeries;
    }

    public Stories getStories() {
        return mStories;
    }

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }

    public List<Url> getUrls() {
        return mUrls;
    }

    public static class Builder {

        private Comics mComics;
        private String mDescription;
        private Events mEvents;
        private Long mId;
        private String mModified;
        private String mName;
        private String mResourceURI;
        private Series mSeries;
        private Stories mStories;
        private Thumbnail mThumbnail;
        private List<Url> mUrls;

        public Result.Builder withComics(Comics comics) {
            mComics = comics;
            return this;
        }

        public Result.Builder withDescription(String description) {
            mDescription = description;
            return this;
        }

        public Result.Builder withEvents(Events events) {
            mEvents = events;
            return this;
        }

        public Result.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public Result.Builder withModified(String modified) {
            mModified = modified;
            return this;
        }

        public Result.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Result.Builder withResourceURI(String resourceURI) {
            mResourceURI = resourceURI;
            return this;
        }

        public Result.Builder withSeries(Series series) {
            mSeries = series;
            return this;
        }

        public Result.Builder withStories(Stories stories) {
            mStories = stories;
            return this;
        }

        public Result.Builder withThumbnail(Thumbnail thumbnail) {
            mThumbnail = thumbnail;
            return this;
        }

        public Result.Builder withUrls(List<Url> urls) {
            mUrls = urls;
            return this;
        }

        public Result build() {
            Result Result = new Result();
            Result.mComics = mComics;
            Result.mDescription = mDescription;
            Result.mEvents = mEvents;
            Result.mId = mId;
            Result.mModified = mModified;
            Result.mName = mName;
            Result.mResourceURI = mResourceURI;
            Result.mSeries = mSeries;
            Result.mStories = mStories;
            Result.mThumbnail = mThumbnail;
            Result.mUrls = mUrls;
            return Result;
        }

    }

}

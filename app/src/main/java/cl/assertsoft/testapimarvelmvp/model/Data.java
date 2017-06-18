
package cl.assertsoft.testapimarvelmvp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("limit")
    private Long mLimit;
    @SerializedName("offset")
    private Long mOffset;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("total")
    private Long mTotal;

    public Long getCount() {
        return mCount;
    }

    public Long getLimit() {
        return mLimit;
    }

    public Long getOffset() {
        return mOffset;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public Long getTotal() {
        return mTotal;
    }

    public static class Builder {

        private Long mCount;
        private Long mLimit;
        private Long mOffset;
        private List<Result> mResults;
        private Long mTotal;

        public Data.Builder withCount(Long count) {
            mCount = count;
            return this;
        }

        public Data.Builder withLimit(Long limit) {
            mLimit = limit;
            return this;
        }

        public Data.Builder withOffset(Long offset) {
            mOffset = offset;
            return this;
        }

        public Data.Builder withResults(List<Result> results) {
            mResults = results;
            return this;
        }

        public Data.Builder withTotal(Long total) {
            mTotal = total;
            return this;
        }

        public Data build() {
            Data Data = new Data();
            Data.mCount = mCount;
            Data.mLimit = mLimit;
            Data.mOffset = mOffset;
            Data.mResults = mResults;
            Data.mTotal = mTotal;
            return Data;
        }

    }

}

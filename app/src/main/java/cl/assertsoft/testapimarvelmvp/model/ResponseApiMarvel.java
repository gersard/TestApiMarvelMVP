
package cl.assertsoft.testapimarvelmvp.model;

import com.google.gson.annotations.SerializedName;


public class ResponseApiMarvel {

    @SerializedName("attributionHTML")
    private String mAttributionHTML;
    @SerializedName("attributionText")
    private String mAttributionText;
    @SerializedName("code")
    private Long mCode;
    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("data")
    private Data mData;
    @SerializedName("etag")
    private String mEtag;
    @SerializedName("status")
    private String mStatus;

    public String getAttributionHTML() {
        return mAttributionHTML;
    }

    public String getAttributionText() {
        return mAttributionText;
    }

    public Long getCode() {
        return mCode;
    }

    public String getCopyright() {
        return mCopyright;
    }

    public Data getData() {
        return mData;
    }

    public String getEtag() {
        return mEtag;
    }

    public String getStatus() {
        return mStatus;
    }

    public static class Builder {

        private String mAttributionHTML;
        private String mAttributionText;
        private Long mCode;
        private String mCopyright;
        private Data mData;
        private String mEtag;
        private String mStatus;

        public ResponseApiMarvel.Builder withAttributionHTML(String attributionHTML) {
            mAttributionHTML = attributionHTML;
            return this;
        }

        public ResponseApiMarvel.Builder withAttributionText(String attributionText) {
            mAttributionText = attributionText;
            return this;
        }

        public ResponseApiMarvel.Builder withCode(Long code) {
            mCode = code;
            return this;
        }

        public ResponseApiMarvel.Builder withCopyright(String copyright) {
            mCopyright = copyright;
            return this;
        }

        public ResponseApiMarvel.Builder withData(Data data) {
            mData = data;
            return this;
        }

        public ResponseApiMarvel.Builder withEtag(String etag) {
            mEtag = etag;
            return this;
        }

        public ResponseApiMarvel.Builder withStatus(String status) {
            mStatus = status;
            return this;
        }

        public ResponseApiMarvel build() {
            ResponseApiMarvel ResponseApiMarvel = new ResponseApiMarvel();
            ResponseApiMarvel.mAttributionHTML = mAttributionHTML;
            ResponseApiMarvel.mAttributionText = mAttributionText;
            ResponseApiMarvel.mCode = mCode;
            ResponseApiMarvel.mCopyright = mCopyright;
            ResponseApiMarvel.mData = mData;
            ResponseApiMarvel.mEtag = mEtag;
            ResponseApiMarvel.mStatus = mStatus;
            return ResponseApiMarvel;
        }

    }

}

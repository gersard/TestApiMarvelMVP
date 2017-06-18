package cl.assertsoft.testapimarvelmvp.api;

/**
 * Created by Gerardo on 17-06-2017.
 */

public class ApiConstants {
    public static final String URL_BASE = "https://gateway.marvel.com:443/";
    public static final String PATH_VERSION = "v1/";
    public static final String PATH_TYPE = "public/";
    public static final String PATH_METHOD = "characters";

    public static final String URL_GET_CHARACTERS = PATH_VERSION+PATH_TYPE+PATH_METHOD;

    public static final String PARAM_TIMESTAMP = "ts";
    public static final String PARAM_API_KEY = "apikey";
    public static final String PARAM_HASH = "hash";

}

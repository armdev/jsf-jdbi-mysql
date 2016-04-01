package com.web.rest.server;

/**
 *
 * @author ArmenArzumanyan
 */
public class ResponseStatus {

    public static int INVALID_JSON = 101;
    public static int RECORD_SAVED = 200; 
     public static int SAVE_FAILED = 401;
    public static String JSON_IS_NULL = "JSON_IS_NULL";
    public static String JSON_IS_INVALID = "JSON_IS_INVALID";
    public static String FILE_NAME_IS_NOT_DEFINED = "FILE_NAME_IS_NOT_DEFINED";
    public static String SERVER_IS_NOT_DEFINED = "SERVER_IS_NOT_DEFINED";
    public static String JSON_PARSE_EXCEPTION = "JSON_PARSE_EXCEPTION";

}

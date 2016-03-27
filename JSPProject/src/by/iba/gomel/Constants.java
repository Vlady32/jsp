package by.iba.gomel;

/**
 * This class contains all constants that to use in this application.
 */
public class Constants {
    public static final int    INDEX_COLUMN_TYPE_SQL                             = 1;
    public static final int    INDEX_COLUMN_FULLNAME_SQL                         = 1;
    public static final int    INDEX_COLUMN_ADDRESS_SQL                          = 2;
    public static final int    INDEX_COLUMN_PASSWORD_SQL                         = 2;
    public static final int    INDEX_COLUMN_PHONE_NUMBER_SQL                     = 3;
    public static final int    INDEX_COLUMN_TYPE_USER_SQL                        = 3;
    public static final int    INDEX_COLUMN_MAIL_SQL                             = 4;
    public static final int    INDEX_COLUMN_DATE_SQL                             = 5;
    public static final int    INDEX_COLUMN_ITEM_SQL                             = 6;
    public static final int    DEFAULT_INDEX_ITEM                                = -1;
    public static final double DEFAULT_QUALITY_RECORDS_AND_USERS_ON_PAGE         = 30.0;

    public static final String PARAMETER_COMMAND                                 = "command";
    public static final String PARAMETER_PATH                                    = "path";
    public static final String PARAMETER_WRONG_ACTION                            = "wrongAction";
    public static final String PARAMETER_PHRASE_SEARCH                           = "phraseSearch";
    public static final String PARAMETER_CATEGORY                                = "category";
    public static final String PARAMETER_NULL_PAGE                               = "nullPage";
    public static final String PARAMETER_NAME_LOGIN                              = "login";
    public static final String PARAMETER_NAME_PASSWORD                           = "password";
    public static final String PARAMETER_NAME_CONFIRMED_PASSWORD                 = "confirmedPassword";
    public static final String PARAMETER_FULL_NAME                               = "fullName";
    public static final String PARAMETER_ADDRESS                                 = "address";
    public static final String PARAMETER_PHONE_NUMBER                            = "phoneNumber";
    public static final String PARAMETER_MAIL                                    = "mail";
    public static final String PARAMETER_BIRTH_DATE                              = "birthDate";
    public static final String PARAMETER_START_POSITION                          = "start";
    public static final String PARAMETER_ITEM                                    = "item";
    public static final String PARAMETER_USER_NAME                               = "userName";
    public static final String PARAMETER_FORWARD_MAIN_PAGE                       = "forwardmainpage";
    public static final String PARAMETER_ALL                                     = "all";

    public static final String MESSAGE_ERROR_LOGIN_PASS                          = "errorLoginPassMessage";
    public static final String MESSAGE_ERROR_VIEW                                = "errorView";
    public static final String MESSAGE_SUCCESS_VIEW                              = "successView";
    public static final String MESSAGE_ERROR_PROFILE                             = "errorProfile";
    public static final String MESSAGE_RESULT_ADDITION                           = "resultAddition";
    public static final String MESSAGE_WRONG_PROFILE                             = "message.errorProfile";
    public static final String MESSAGE_WRONG_VIEW                                = "message.wrongview";
    public static final String MESSAGE_EMPTY_VIEW                                = "message.emptyview";
    public static final String MESSAGE_WRONG_ACTION                              = "message.wrongaction";
    public static final String MESSAGE_NULL_PAGE                                 = "message.nullpage";
    public static final String MESSAGE_LOGIN_ERROR                               = "message.loginerror";
    public static final String MESSAGE_REGISTRATION_PASSWORDS_ERROR              = "message.registrationpasswordserror";
    public static final String MESSAGE_REGISTRATION_LOGIN_ERROR                  = "message.registrationloginerror";
    public static final String MESSAGE_ADDITION_ERROR                            = "message.errorAddition";
    public static final String MESSAGE_ADDITION_SUCCESS                          = "message.successAddition";
    public static final String MESSAGE_EDITING_SUCCESS                           = "message.successEditing";
    public static final String MESSAGE_EDITING_ERROR                             = "message.errorEditing";
    public static final String MESSAGE_DELETING_SUCCESS                          = "message.successDeleting";
    public static final String MESSAGE_DELETING_ERROR                            = "message.errorDeleting";
    public static final String FILE_MESSAGES_PROPERTY                            = "resources.messages";
    public static final String FILE_CONFIG_PROPERTY                              = "resources.config";

    public static final String ATTRIBUTE_NAME_LOGIN                              = "login";
    public static final String ATTRIBUTE_NAME_TYPE                               = "type";
    public static final String ATTRIBUTE_NAME_USER                               = "user";
    public static final String ATTRIBUTE_NAME_LIST_RECORDS                       = "listRecords";
    public static final String ATTRIBUTE_NAME_LIST_USERS                         = "listUsers";
    public static final String ATTRIBUTE_QUALITY_PAGES                           = "qualityPages";
    public static final String ATTRIBUTE_CURRENT_POSITION                        = "currentPosition";
    public static final String ATTRIBUTE_FOUND_RECORD                            = "foundRecord";

    public static final String TYPE_USER                                         = "user";
    public static final String TYPE_GUEST                                        = "guest";
    public static final String TYPE_EMPTY                                        = "";

    public static final String EXCEPTION_SQL                                     = "SQLException";
    public static final String EXCEPTION_DUPLICATE_LOGIN                         = "DuplicateLoginException";
    public static final String PARSE_EXCEPTION                                   = "ParseException";
    public static final String NAMING_EXCEPTION                                  = "NamingException";

    public static final String PROPERTY_PATH_INDEX_PAGE                          = "path.page.index";
    public static final String PROPERTY_PATH_MAIN_PAGE                           = "path.page.main";
    public static final String PROPERTY_PATH_LOGIN_PAGE                          = "path.page.login";
    public static final String PROPERTY_PATH_REGISTRATION_PAGE                   = "path.page.registration";
    public static final String PROPERTY_PATH_REGISTRATION_SUCCESSFUL_PAGE        = "path.page.registrationsuccessful";
    public static final String PROPERTY_PATH_VIEW_PAGE                           = "path.page.view";
    public static final String PROPERTY_PATH_EDIT_PAGE                           = "path.page.edit";
    public static final String PROPERTY_PATH_PROFILE_PAGE                        = "path.page.profile";
    public static final String PROPERTY_PATH_ADD_PAGE                            = "path.page.add";
    public static final String PROPERTY_PATH_EDIT_PROFILE_PAGE                   = "path.page.editprofile";
    public static final String PROPERTY_PATH_SEARCH_PAGE                         = "path.page.search";
    public static final String PROPERTY_PATH_CONTROL_PAGE                        = "path.page.control";

    public static final String DATE_PATTERN                                      = "yyyy-MM-dd";
    public static final String LOGIC_NAME_DB                                     = "java:comp/env/jdbc/JSP";
    public static final String REQUEST_POST                                      = "POST";
    public static final String REQUEST_GET                                       = "GET";
    public static final String ENCODING_UTF_8                                    = "UTF-8";
    public static final String PATH_VALUE_REGISTRATION                           = "registration";
    public static final String PATH_VALUE_LOGIN                                  = "login";
    public static final String PATH_VALUE_VIEW                                   = "view";
    public static final String PATH_VALUE_SEARCH                                 = "search";
    public static final String PATH_VALUE_ADD                                    = "add";
    public static final String PATH_VALUE_EDIT                                   = "edit";
    public static final String PATH_VALUE_ACTION_CONTROLLER                      = "/actionController";

    public static final String REQUEST_DB_ADD_RECORD                             = "INSERT INTO VLADY.\"PhoneBook\" (\"fullName\", \"address\", \"phoneNumber\", \"mail\", \"birthDate\") VALUES (?,?,?,?,?)";
    public static final String REQUEST_DB_DELETE_RECORD                          = "DELETE FROM VLADY.\"PhoneBook\" WHERE VLADY.\"PhoneBook\".\"item\"=?";
    public static final String REQUEST_DB_DELETE_USER                            = "DELETE FROM VLADY.\"Users\" WHERE VLADY.\"Users\".\"UserName\"=?";
    public static final String REQUEST_DB_EDIT_RECORD                            = "UPDATE VLADY.\"PhoneBook\" SET \"fullName\"=?, \"address\"=?, \"phoneNumber\"=?, \"mail\"=?, \"birthDate\"=? WHERE VLADY.\"PhoneBook\".\"item\"=?";
    public static final String REQUEST_DB_REGISTRATION_USER                      = "INSERT INTO VLADY.\"Users\" (\"UserName\", \"Password\", \"Type\") VALUES (?,?,?)";
    public static final String REQUEST_DB_QUALITY_USERS                          = "SELECT COUNT(*) FROM VLADY.\"Users\"";
    public static final String REQUEST_DB_GET_ALL_USERS_FIRST_PART               = "SELECT \"UserName\",\"Type\" FROM VLADY.\"Users\" LIMIT ";
    public static final String REQUEST_DB_GET_ALL_USERS_SECOND_PART              = ",30 ";
    public static final String REQUEST_DB_CHECK_USER_FIRST_PART                  = "SELECT \"Type\" FROM VLADY.\"Users\" WHERE  \"UserName\"='";
    public static final String REQUEST_DB_CHECK_USER_SECOND_PART                 = "' AND \"Password\"='";
    public static final String REQUEST_DB_CHECK_USER_THIRD_PART                  = "'";
    public static final String REQUEST_DB_GET_RECORDS_ALL_COLUMNS_FIRST_PART     = "SELECT \"item\",\"fullName\",\"address\",\"phoneNumber\",\"creationDate\",\"mail\",\"birthDate\"  FROM VLADY.\"PhoneBook\" WHERE LOWER(\"fullName\") LIKE '%";
    public static final String REQUEST_DB_GET_RECORDS_ALL_COLUMNS_SECOND_PART    = "%' OR LOWER(\"address\") LIKE '%";
    public static final String REQUEST_DB_GET_RECORDS_ALL_COLUMNS_THIRD_PART     = "%' OR LOWER(\"phoneNumber\") LIKE '%";
    public static final String REQUEST_DB_GET_RECORDS_ALL_COLUMNS_FOURTH_PART    = "%'";
    public static final String REQUEST_DB_GET_RECORDS_CERTAIN_COLUMN_FIRST_PART  = "SELECT \"item\",\"fullName\",\"address\",\"phoneNumber\",\"creationDate\",\"mail\",\"birthDate\" FROM VLADY.\"PhoneBook\" WHERE LOWER(\"";
    public static final String REQUEST_DB_GET_RECORDS_CERTAIN_COLUMN_SECOND_PART = "\") LIKE '%";
    public static final String REQUEST_DB_GET_RECORDS_CERTAIN_COLUMN_THIRD_PART  = "%'";
    public static final String REQUEST_DB_QUALITY_RECORDS                        = "SELECT COUNT(*) FROM VLADY.\"PhoneBook\"";
    public static final String REQUEST_DB_GET_ALL_RECORDS_FIRST_PART             = "SELECT \"item\",\"fullName\",\"address\",\"phoneNumber\",\"creationDate\",\"mail\",\"birthDate\"  FROM VLADY.\"PhoneBook\" LIMIT ";
    public static final String REQUEST_DB_GET_ALL_RECORDS_SECOND_PART            = ",30 ";

}

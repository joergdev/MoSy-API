package com.github.joergdev.mosy.api.response;

public enum ResponseMessages
{
  // ERROR
  ACCESS_DENIED(1, "Access denied", ResponseMessageLevel.ERROR),
    INVALID_INPUT_PARAMS(2, "Invalid input params", ResponseMessageLevel.ERROR),
    DATA_ALREADY_EXISTS(3, "Data already exists", ResponseMessageLevel.ERROR),
    DATA_DOESNT_EXIST(4, "Data doesnt exist", ResponseMessageLevel.ERROR),
    INVALID_CREDENTIALS(5, "Invalid credentials", ResponseMessageLevel.ERROR),
    UNEXPECTED_ERROR(6, "Unexpected error, please contact your Systemadmin", ResponseMessageLevel.ERROR),
    OPERATION_FAILED_ERROR(7, "Operation failed", ResponseMessageLevel.ERROR),
    DELETE_NOT_POSSIBLE_CAUSE_OF_DEPENDENT_DATA(8, "Delete not possible cause of dependent data",
        ResponseMessageLevel.ERROR),
    OPERATION_NOT_POSSIBLE(8, "Operation not possible", ResponseMessageLevel.ERROR),

    // INFO
    NO_DATA_CHANGED(10000, "No data changed", ResponseMessageLevel.INFO),
    OPERATION_FAILED_INFO(10001, "Operation failed", ResponseMessageLevel.INFO);

  private ResponseMessages(Integer code, String message, ResponseMessageLevel level)
  {
    responseMsg = new ResponseMessage();
    responseMsg.setCode(code);
    responseMsg.setMessage(message);
    responseMsg.setLevel(level);
  }

  public final ResponseMessage responseMsg;

  public ResponseMessage withAddtitionalInfo(String addInfo)
  {
    return responseMsg.withAddtitionalInfo(addInfo);
  }
}
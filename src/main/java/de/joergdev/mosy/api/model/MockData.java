package de.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class MockData extends AbstractModel implements Cloneable
{
  public static final String PREFIX_MOCKDATA_IN_EXPORT_REQUEST_PATH_PARAMS = ">>>>>>PathParams>";
  public static final String PREFIX_MOCKDATA_IN_EXPORT_REQUEST_URL_ARGUMENTS = ">>>>>>UrlArguments>";
  public static final String PREFIX_MOCKDATA_IN_EXPORT_REQUEST = ">>>>>>REQUEST>";
  public static final String PREFIX_MOCKDATA_IN_EXPORT_RESPONSE_HTTP_CODE = ">>>>>>RESPONSE_HTTP_CODE>";
  public static final String PREFIX_MOCKDATA_IN_EXPORT_RESPONSE = ">>>>>>RESPONSE>";

  private Integer mockDataId;
  private String title;

  /**
   * Date of creation.
   * 
   * Cause of problems with json parsing as LocalDateTime "created" is instanceof Date.
   * For handling as LocalDateTime though there exists a separate getter/setter.
   */
  private Date created;

  private boolean active;
  private boolean common;
  private Integer countCalls;

  private InterfaceMethod interfaceMethod;

  /**
   * <pre> 
   * REST 
   * 
   * Path params, key/value
   * 
   * for example:
   * Base URL: .../api/{id}/resources/{name}
   * Real URL: .../api/123/resources/ABC
   * List: [ <id, 123> <name, ABC> ]
   * </pre>
   */
  private List<PathParam> pathParams = new ArrayList<>();

  /**
   * <pre>
   * REST
   * 
   * URL arguments, key/value
   * 
   * for example:
   * URL: .../api/123/resources/ABC?stage=TEST&foo=bar
   * List: [ <stage, TEST> <foo, bar> ]
   * </pre>
   */
  private List<UrlArgument> urlArguments = new ArrayList<>();

  private String request;
  private String response;

  /** Nur bei Rest relevant */
  private Integer httpReturnCode;

  private Integer requestHash;
  private Integer responseHash;

  private List<MockProfile> mockProfiles = new ArrayList<>();

  public Integer getMockDataId()
  {
    return mockDataId;
  }

  public void setMockDataId(Integer mockDataId)
  {
    this.mockDataId = mockDataId;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public Date getCreated()
  {
    return created;
  }

  public void setCreated(Date created)
  {
    this.created = created;
  }

  @JsonIgnore
  public String getCreatedAsString()
  {
    return Utils.localDateTimeToString(getCreatedAsLdt());
  }

  @JsonIgnore
  public LocalDateTime getCreatedAsLdt()
  {
    return Utils.dateToLocalDateTime(created);
  }

  public void setCreatedAsLdt(LocalDateTime created)
  {
    this.created = Utils.localDateTimeToDate(created);
  }

  public boolean getActive()
  {
    return active;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }

  public Integer getCountCalls()
  {
    return countCalls;
  }

  public void setCountCalls(Integer countCalls)
  {
    this.countCalls = countCalls;
  }

  public InterfaceMethod getInterfaceMethod()
  {
    return interfaceMethod;
  }

  public void setInterfaceMethod(InterfaceMethod interfaceMethod)
  {
    this.interfaceMethod = interfaceMethod;
  }

  public String getRequest()
  {
    return request;
  }

  public void setRequest(String request)
  {
    this.request = request;
  }

  public String getResponse()
  {
    return response;
  }

  public void setResponse(String response)
  {
    this.response = response;
  }

  @JsonIgnore
  public String getMockProfileNames()
  {
    StringBuilder bui = new StringBuilder();

    for (MockProfile mp : mockProfiles)
    {
      if (bui.length() > 0)
      {
        bui.append(", ");
      }

      bui.append(mp.getName());
    }

    return bui.toString();
  }

  public boolean getCommon()
  {
    return common;
  }

  public void setCommon(boolean common)
  {
    this.common = common;
  }

  /**
   * @return the requestHash
   */
  public Integer getRequestHash()
  {
    return requestHash;
  }

  /**
   * @param requestHash the requestHash to set
   */
  public void setRequestHash(Integer requestHash)
  {
    this.requestHash = requestHash;
  }

  /**
   * @return the responseHash
   */
  public Integer getResponseHash()
  {
    return responseHash;
  }

  /**
   * @param responseHash the responseHash to set
   */
  public void setResponseHash(Integer responseHash)
  {
    this.responseHash = responseHash;
  }

  public Integer getHttpReturnCode()
  {
    return httpReturnCode;
  }

  public void setHttpReturnCode(Integer httpReturnCode)
  {
    this.httpReturnCode = httpReturnCode;
  }

  /**
   * @return the mockProfiles
   */
  public List<MockProfile> getMockProfiles()
  {
    return mockProfiles;
  }

  public MockData clone()
  {
    try
    {
      MockData clone = (MockData) super.clone();

      clone.mockProfiles = new ArrayList<>();
      mockProfiles.forEach(mp -> clone.mockProfiles.add(mp.clone()));

      clone.pathParams = new ArrayList<>();
      pathParams.forEach(pp -> clone.pathParams.add(pp.clone()));

      clone.urlArguments = new ArrayList<>();
      urlArguments.forEach(ua -> clone.urlArguments.add(ua.clone()));

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  public void formatRequestResponse(Integer interfaceTypeId)
  {
    boolean isXmlInterface = InterfaceType.SOAP.id.equals(interfaceTypeId)
                             || InterfaceType.CUSTOM_XML.id.equals(interfaceTypeId);
    boolean isJsonInterface = InterfaceType.CUSTOM_JSON.equals(interfaceTypeId);

    if (isXmlInterface || (request != null && request.startsWith("<?xml")))
    {
      request = Utils.formatXml(request);
    }
    else if (isJsonInterface || (request != null && request.startsWith("{") && request.endsWith("}")))
    {
      request = Utils.formatJSON(request, true);
    }

    if (isXmlInterface || (response != null && response.startsWith("<?xml")))
    {
      response = Utils.formatXml(response);
    }
    else if (isJsonInterface || (response != null && response.startsWith("{") && response.endsWith("}")))
    {
      response = Utils.formatJSON(response, true);
    }
  }

  public void setRequestResponseHash()
  {
    requestHash = Objects.hash(request, pathParams, urlArguments);

    responseHash = Objects.hash(response, httpReturnCode);
  }

  public void setRequestResponseByFileContent(String fileContent)
  {
    // Get Request/Response from file
    int idxStartRequestDynPathVar = getFileIndexPrefixRequestResponse(fileContent,
        PREFIX_MOCKDATA_IN_EXPORT_REQUEST_PATH_PARAMS, null);

    int idxStartRequestUrlArguments = getFileIndexPrefixRequestResponse(fileContent,
        PREFIX_MOCKDATA_IN_EXPORT_REQUEST_URL_ARGUMENTS, null);

    int idxStartRequest = getFileIndexPrefixRequestResponse(fileContent, PREFIX_MOCKDATA_IN_EXPORT_REQUEST,
        "mockdata_file_invalid_no_prefix_request");

    int idxStartResponseHttpCode = getFileIndexPrefixRequestResponse(fileContent,
        PREFIX_MOCKDATA_IN_EXPORT_RESPONSE_HTTP_CODE, null);

    int idxStartResponse = getFileIndexPrefixRequestResponse(fileContent, PREFIX_MOCKDATA_IN_EXPORT_RESPONSE,
        "mockdata_file_invalid_no_prefix_response");

    if (idxStartRequestDynPathVar >= 0)
    {
      String pathParamsFile = getRequestResponseFromFileContent(fileContent,
          PREFIX_MOCKDATA_IN_EXPORT_REQUEST_PATH_PARAMS, idxStartRequestDynPathVar,
          idxStartRequestUrlArguments > 0
              ? idxStartRequestUrlArguments
              : idxStartRequest);

      for (String pathParamLine : pathParamsFile.split("\n"))
      {
        if (!pathParamLine.trim().isEmpty() && pathParamLine.contains(":"))
        {
          String[] pathParamNameValuePair = pathParamLine.split(":");
          pathParams.add(new PathParam(pathParamNameValuePair[0].trim(), pathParamNameValuePair[1].trim()));
        }
      }
    }

    if (idxStartRequestUrlArguments >= 0)
    {
      String urlArgsFile = getRequestResponseFromFileContent(fileContent,
          PREFIX_MOCKDATA_IN_EXPORT_REQUEST_URL_ARGUMENTS, idxStartRequestUrlArguments, idxStartRequest);

      for (String urlArgLine : urlArgsFile.split("\n"))
      {
        if (!urlArgLine.trim().isEmpty() && urlArgLine.contains(":"))
        {
          String[] urlArgNameValuePair = urlArgLine.split(":");
          urlArguments.add(new UrlArgument(urlArgNameValuePair[0].trim(), urlArgNameValuePair[1].trim()));
        }
      }
    }

    String request = getRequestResponseFromFileContent(fileContent, PREFIX_MOCKDATA_IN_EXPORT_REQUEST,
        idxStartRequest, (idxStartResponseHttpCode >= 0
            ? idxStartResponseHttpCode
            : idxStartResponse));

    if (idxStartResponseHttpCode >= 0)
    {
      String responseHttpCode = getRequestResponseFromFileContent(fileContent,
          PREFIX_MOCKDATA_IN_EXPORT_RESPONSE_HTTP_CODE, idxStartResponseHttpCode, idxStartResponse);
      setHttpReturnCode(Integer.valueOf(responseHttpCode));
    }

    String response = getRequestResponseFromFileContent(fileContent, PREFIX_MOCKDATA_IN_EXPORT_RESPONSE,
        idxStartResponse, fileContent.length());

    setRequest(request);
    setResponse(response);
  }

  private String getRequestResponseFromFileContent(String fileContent, String prefix, int idxPrefix,
                                                   int idxEnd)
  {
    String reqResp = fileContent.substring(idxPrefix + prefix.length(), idxEnd).trim();

    if (reqResp.startsWith("\n"))
    {
      reqResp = reqResp.substring(1);
    }

    if (reqResp.endsWith("\n"))
    {
      reqResp = reqResp.substring(0, reqResp.length() - 1);
    }

    return reqResp;
  }

  private int getFileIndexPrefixRequestResponse(String fileContent, String prefix, String errorMsgDetail)
  {
    int idxStartRequest = fileContent.indexOf(prefix);

    if (idxStartRequest < 0 && errorMsgDetail != null)
    {
      throw new IndexOutOfBoundsException("mockdata file invalid, idxStartRequest < 0");
    }

    return idxStartRequest;
  }

  public List<PathParam> getPathParams()
  {
    return pathParams;
  }

  public List<UrlArgument> getUrlArguments()
  {
    return urlArguments;
  }
}
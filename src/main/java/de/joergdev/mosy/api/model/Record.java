package de.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class Record extends AbstractModel
{
  private Integer recordId;
  private InterfaceMethod interfaceMethod;
  private Date created;

  /** REST see also Javadoc class {@link MockData} */
  private final Collection<PathParam> pathParams = new ArrayList<>();

  private String requestData;
  private String response;

  /** REST */
  private Integer httpReturnCode;

  private RecordSession recordSession;

  public Integer getRecordId()
  {
    return recordId;
  }

  public void setRecordId(Integer recordId)
  {
    this.recordId = recordId;
  }

  public InterfaceMethod getInterfaceMethod()
  {
    return interfaceMethod;
  }

  public void setInterfaceMethod(InterfaceMethod interfaceMethod)
  {
    this.interfaceMethod = interfaceMethod;
  }

  @JsonIgnore
  public String getInterfaceName()
  {
    if (interfaceMethod != null)
    {
      Interface apiInterface = interfaceMethod.getMockInterface();
      if (apiInterface != null)
      {
        return apiInterface.getName();
      }
    }

    return null;
  }

  @JsonIgnore
  public String getMethodName()
  {
    if (interfaceMethod != null)
    {
      return interfaceMethod.getName();
    }

    return null;
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

  public String getRequestData()
  {
    return requestData;
  }

  public void setRequestData(String requestData)
  {
    this.requestData = requestData;
  }

  public String getResponse()
  {
    return response;
  }

  public void setResponse(String response)
  {
    this.response = response;
  }

  public RecordSession getRecordSession()
  {
    return recordSession;
  }

  public void setRecordSession(RecordSession recordSession)
  {
    this.recordSession = recordSession;
  }

  @JsonIgnore
  public Integer getRecordSessionID()
  {
    return recordSession == null
        ? null
        : recordSession.getRecordSessionID();
  }

  public Integer getHttpReturnCode()
  {
    return httpReturnCode;
  }

  public void setHttpReturnCode(Integer httpReturnCode)
  {
    this.httpReturnCode = httpReturnCode;
  }

  public Collection<PathParam> getPathParams()
  {
    return pathParams;
  }

  public void formatRequestResponse(Integer interfaceTypeId)
  {
    boolean isXmlInterface = InterfaceType.SOAP.id.equals(interfaceTypeId)
                             || InterfaceType.CUSTOM_XML.id.equals(interfaceTypeId);
    boolean isJsonInterface = InterfaceType.CUSTOM_JSON.equals(interfaceTypeId);

    if (isXmlInterface || (requestData != null && requestData.startsWith("<?xml")))
    {
      requestData = Utils.formatXml(requestData);
    }
    else if (isJsonInterface
             || (requestData != null && requestData.startsWith("{") && requestData.endsWith("}")))
    {
      requestData = Utils.formatJSON(requestData, true);
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
}
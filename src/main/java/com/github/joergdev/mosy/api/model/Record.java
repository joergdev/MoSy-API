package com.github.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.joergdev.mosy.api.model.core.AbstractModel;
import com.github.joergdev.mosy.shared.Utils;

public class Record extends AbstractModel
{
  private Integer recordId;
  private InterfaceMethod interfaceMethod;
  private Date created;

  private String requestData;
  private String response;

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

  public void formatRequestResponse(Integer interfaceTypeId)
  {
    // XML
    if (InterfaceType.SOAP.id.equals(interfaceTypeId) || InterfaceType.CUSTOM_XML.id.equals(interfaceTypeId))
    {
      requestData = Utils.formatXml(requestData);
      response = Utils.formatXml(response);
    }
  }
}
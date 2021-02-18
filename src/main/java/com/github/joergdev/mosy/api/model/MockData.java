package com.github.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.joergdev.mosy.api.model.core.AbstractModel;
import com.github.joergdev.mosy.shared.Utils;

public class MockData extends AbstractModel implements Cloneable
{
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

  private String request;
  private String response;

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

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  public void formatRequestResponse(Integer interfaceTypeId)
  {
    // XML
    if (InterfaceType.SOAP.id.equals(interfaceTypeId) || InterfaceType.CUSTOM_XML.id.equals(interfaceTypeId))
    {
      request = Utils.formatXml(request);
      response = Utils.formatXml(response);
    }
  }

  public void setRequestResponseHash()
  {
    requestHash = request == null
        ? -1
        : request.hashCode();

    responseHash = response == null
        ? -1
        : response.hashCode();
  }
}
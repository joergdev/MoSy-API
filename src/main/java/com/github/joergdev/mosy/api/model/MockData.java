package com.github.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.Date;
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

  private Boolean active;
  private Integer countCalls;

  private InterfaceMethod interfaceMethod;

  private String request;
  private String response;

  private MockSession mockSession;

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

  public Boolean getActive()
  {
    return active;
  }

  public void setActive(Boolean active)
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

  public MockSession getMockSession()
  {
    return mockSession;
  }

  public void setMockSession(MockSession mockSession)
  {
    this.mockSession = mockSession;
  }

  @JsonIgnore
  public Integer getMockSessionID()
  {
    return mockSession == null
        ? null
        : mockSession.getMockSessionID();
  }

  public MockData clone()
  {
    try
    {
      MockData clone = (MockData) super.clone();

      if (mockSession != null)
      {
        clone.mockSession = mockSession.clone();
      }

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }
}
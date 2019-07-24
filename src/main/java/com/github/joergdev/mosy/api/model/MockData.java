package com.github.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import com.github.joergdev.mosy.api.model.core.AbstractModel;

public class MockData extends AbstractModel
{
  private Integer mockDataId;
  private String title;
  private LocalDateTime created;
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

  public LocalDateTime getCreated()
  {
    return created;
  }

  public void setCreated(LocalDateTime created)
  {
    this.created = created;
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
}
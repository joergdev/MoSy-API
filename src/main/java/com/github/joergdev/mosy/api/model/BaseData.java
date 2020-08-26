package com.github.joergdev.mosy.api.model;

import java.util.ArrayList;
import java.util.List;
import com.github.joergdev.mosy.api.model.core.AbstractModel;

public class BaseData extends AbstractModel
{
  // Data GlobalConfig
  private Boolean mockActiveOnStartup;
  private Boolean mockActive;
  private Boolean routingOnNoMockData;
  private Integer ttlMockSession;

  private Boolean record;

  private final List<Interface> interfaces = new ArrayList<>();

  private Integer countMockSessions;
  private Integer countRecords;

  public Boolean getMockActiveOnStartup()
  {
    return mockActiveOnStartup;
  }

  public void setMockActiveOnStartup(Boolean mockActiveOnStartup)
  {
    this.mockActiveOnStartup = mockActiveOnStartup;
  }

  public Boolean getMockActive()
  {
    return mockActive;
  }

  public void setMockActive(Boolean mockActive)
  {
    this.mockActive = mockActive;
  }

  public Integer getTtlMockSession()
  {
    return ttlMockSession;
  }

  public void setTtlMockSession(Integer ttlMockSession)
  {
    this.ttlMockSession = ttlMockSession;
  }

  public List<Interface> getInterfaces()
  {
    return interfaces;
  }

  public Integer getCountMockSessions()
  {
    return countMockSessions;
  }

  public void setCountMockSessions(Integer countMockSessions)
  {
    this.countMockSessions = countMockSessions;
  }

  public Boolean getRecord()
  {
    return record;
  }

  public void setRecord(Boolean record)
  {
    this.record = record;
  }

  public Boolean getRoutingOnNoMockData()
  {
    return routingOnNoMockData;
  }

  public void setRoutingOnNoMockData(Boolean routingOnNoMockData)
  {
    this.routingOnNoMockData = routingOnNoMockData;
  }

  public Integer getCountRecords()
  {
    return countRecords;
  }

  public void setCountRecords(Integer countRecords)
  {
    this.countRecords = countRecords;
  }
}
package com.github.joergdev.mosy.api.model;

import java.util.ArrayList;
import java.util.List;
import com.github.joergdev.mosy.api.model.core.AbstractModel;

public class InterfaceMethod extends AbstractModel
{
  private Integer interfaceMethodId;
  private String name;
  private String servicePath;

  private Boolean routingOnNoMockData;
  private Boolean mockDisabledOnStartup;
  private Boolean mockDisabled;

  private Integer countCalls;

  private Interface mockInterface;

  private Boolean record;

  private final List<MockData> mockData = new ArrayList<>();

  private final List<RecordConfig> recordConfigs = new ArrayList<>();

  public Integer getInterfaceMethodId()
  {
    return interfaceMethodId;
  }

  public void setInterfaceMethodId(Integer interfaceMethodId)
  {
    this.interfaceMethodId = interfaceMethodId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Boolean getRoutingOnNoMockData()
  {
    return routingOnNoMockData;
  }

  public void setRoutingOnNoMockData(Boolean routingOnNoMockData)
  {
    this.routingOnNoMockData = routingOnNoMockData;
  }

  public Boolean getMockDisabledOnStartup()
  {
    return mockDisabledOnStartup;
  }

  public void setMockDisabledOnStartup(Boolean mockDisabledOnStartup)
  {
    this.mockDisabledOnStartup = mockDisabledOnStartup;
  }

  public Boolean getMockDisabled()
  {
    return mockDisabled;
  }

  public void setMockDisabled(Boolean mockDisabled)
  {
    this.mockDisabled = mockDisabled;
  }

  public Integer getCountCalls()
  {
    return countCalls;
  }

  public void setCountCalls(Integer countCalls)
  {
    this.countCalls = countCalls;
  }

  public Interface getMockInterface()
  {
    return mockInterface;
  }

  public void setMockInterface(Interface mockInterface)
  {
    this.mockInterface = mockInterface;
  }

  public List<MockData> getMockData()
  {
    return mockData;
  }

  public Boolean getRecord()
  {
    return record;
  }

  public void setRecord(Boolean record)
  {
    this.record = record;
  }

  public List<RecordConfig> getRecordConfigs()
  {
    return recordConfigs;
  }

  public String getServicePath()
  {
    return servicePath;
  }

  public void setServicePath(String servicePath)
  {
    this.servicePath = servicePath;
  }
}
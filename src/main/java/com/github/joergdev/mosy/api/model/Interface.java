package com.github.joergdev.mosy.api.model;

import java.util.List;
import com.github.joergdev.mosy.api.model.core.AbstractModel;

public class Interface extends AbstractModel
{
  private Integer interfaceId;
  private String name;
  private InterfaceType type;
  private String servicePath;

  private Boolean mockDisabledOnStartup;
  private Boolean mockDisabled;

  private String routingUrl;
  private Boolean routingOnNoMockData;

  private List<InterfaceMethod> methods;

  private Boolean record;

  public Integer getInterfaceId()
  {
    return interfaceId;
  }

  public void setInterfaceId(Integer interfaceId)
  {
    this.interfaceId = interfaceId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public InterfaceType getType()
  {
    return type;
  }

  public void setType(InterfaceType type)
  {
    this.type = type;
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

  public String getRoutingUrl()
  {
    return routingUrl;
  }

  public void setRoutingUrl(String routingUrl)
  {
    this.routingUrl = routingUrl;
  }

  public Boolean getRoutingOnNoMockData()
  {
    return routingOnNoMockData;
  }

  public void setRoutingOnNoMockData(Boolean routingOnNoMockData)
  {
    this.routingOnNoMockData = routingOnNoMockData;
  }

  public List<InterfaceMethod> getMethods()
  {
    return methods;
  }

  public void setMethods(List<InterfaceMethod> methods)
  {
    this.methods = methods;
  }

  public Boolean getRecord()
  {
    return record;
  }

  public void setRecord(Boolean record)
  {
    this.record = record;
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
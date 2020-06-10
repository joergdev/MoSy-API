package com.github.joergdev.mosy.api.model;

import java.util.ArrayList;
import java.util.List;
import com.github.joergdev.mosy.api.model.core.AbstractModel;
import com.github.joergdev.mosy.shared.Utils;

public class InterfaceMethod extends AbstractModel implements Cloneable
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

  private List<MockData> mockData = new ArrayList<>();

  private List<RecordConfig> recordConfigs = new ArrayList<>();

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
    if (countCalls == null)
    {
      countCalls = 0;
    }

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
    if (mockInterface != null)
    {
      this.mockInterface = new Interface();
      this.mockInterface.setInterfaceId(mockInterface.getInterfaceId());
      this.mockInterface.setName(mockInterface.getName());
    }
    else
    {
      this.mockInterface = null;
    }
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

  public InterfaceMethod clone()
  {
    try
    {
      InterfaceMethod clone = (InterfaceMethod) super.clone();

      clone.mockData = new ArrayList<>();
      for (MockData mockData : this.mockData)
      {
        mockData = mockData.clone();
        mockData.setInterfaceMethod(clone);

        clone.mockData.add(mockData);
      }

      clone.recordConfigs = new ArrayList<>();
      for (RecordConfig rc : recordConfigs)
      {
        rc = rc.clone();
        rc.setInterfaceMethod(clone);
        rc.setMockInterface(null);

        clone.recordConfigs.add(rc);
      }

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  public MockData getMockDataByTitle(String title)
  {
    if (title != null)
    {
      return mockData.stream().filter(m -> title.equals(m.getTitle())).findAny().orElse(null);
    }

    return null;
  }

  public RecordConfig getRecordConfigByTitle(String title)
  {
    if (title != null)
    {
      return recordConfigs.stream().filter(r -> title.equals(r.getTitle())).findAny().orElse(null);
    }

    return null;
  }

  @Override
  public String toString()
  {
    return name == null
        ? super.toString()
        : name;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;

    if (mockInterface != null)
    {
      hash = mockInterface.hashCode();
    }

    if (interfaceMethodId != null)
    {
      hash += interfaceMethodId;
    }
    else if (!Utils.isEmpty(name))
    {
      hash += name.hashCode();
    }
    else
    {
      hash += super.hashCode();
    }

    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof InterfaceMethod == false)
    {
      return false;
    }

    if (this == obj)
    {
      return true;
    }

    InterfaceMethod other = (InterfaceMethod) obj;

    if (mockInterface != null && other.mockInterface != null && !mockInterface.equals(other.mockInterface))
    {
      return false;
    }

    if (interfaceMethodId != null && other.interfaceMethodId != null)
    {
      return interfaceMethodId.equals(other.interfaceMethodId);
    }

    return Utils.isEqual(name, other.name);
  }
}
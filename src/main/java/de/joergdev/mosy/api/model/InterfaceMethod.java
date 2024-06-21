package de.joergdev.mosy.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class InterfaceMethod extends AbstractModel implements Cloneable
{
  private Integer interfaceMethodId;
  private String name;
  private String servicePath;

  /** HttpMethod for rest services */
  private HttpMethod httpMethod;

  private Boolean routingOnNoMockData;
  private Boolean mockActiveOnStartup;
  private Boolean mockActive;

  private Integer countCalls;

  private Integer interfaceId;
  private String interfaceName;

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

  public void setMockInterfaceData(Interface mockInterface)
  {
    if (mockInterface != null)
    {
      // set id and name and not the interface object because it results in following error running in JBOSS even
      // if a new Interfac object is created with only id+name.
      // Error Unexpected error occured. RESTEASY004655: Unable to invoke request: javax.ws.rs.ProcessingException: 
      // RESTEASY008205: JSON Binding serialization error javax.json.bind.JsonbException:
      // Unable to serialize property 'methods' from de.joergdev.mosy.api.model.Interface

      interfaceId = mockInterface.getInterfaceId();
      interfaceName = mockInterface.getName();
    }
    else
    {
      interfaceId = null;
      interfaceName = null;
    }
  }

  @JsonIgnore
  @JsonbTransient
  public Interface getMockInterface()
  {
    Interface blInterface = new Interface();
    blInterface.setInterfaceId(interfaceId);
    blInterface.setName(interfaceName);

    return blInterface;
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

  @Override
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

  public HttpMethod getHttpMethod()
  {
    return httpMethod;
  }

  public void setHttpMethod(HttpMethod httpMethod)
  {
    this.httpMethod = httpMethod;
  }

  public Integer getInterfaceId()
  {
    return interfaceId;
  }

  public void setInterfaceId(Integer interfaceId)
  {
    this.interfaceId = interfaceId;
  }

  public String getInterfaceName()
  {
    return interfaceName;
  }

  public void setInterfaceName(String interfaceName)
  {
    this.interfaceName = interfaceName;
  }

  @Override
  public String toString()
  {
    return name == null ? super.toString() : name;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;

    if (interfaceId != null)
    {
      hash = interfaceId.hashCode();
    }
    else if (!Utils.isEmpty(interfaceName))
    {
      hash = interfaceName.hashCode();
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

    if (interfaceId != null && other.interfaceId != null && !interfaceId.equals(other.interfaceId))
    {
      return false;
    }

    if (!Utils.isEmpty(interfaceName) && !Utils.isEmpty(other.interfaceName) && !interfaceName.equals(other.interfaceName))
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

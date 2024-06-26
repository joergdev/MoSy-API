package de.joergdev.mosy.api.model;

import java.util.ArrayList;
import java.util.List;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class Interface extends AbstractModel implements Cloneable
{
  private Integer interfaceId;
  private String name;
  private InterfaceType type;
  private String servicePath;

  private Boolean mockActiveOnStartup;
  private Boolean mockActive;

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
    if (methods == null)
    {
      methods = new ArrayList<>();
    }

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

  public InterfaceMethod getMethodByName(String name)
  {
    if (name != null)
    {
      return methods.stream().filter(m -> name.equals(m.getName())).findAny().orElse(null);
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

  @Override
  public Interface clone()
  {
    try
    {
      Interface clone = (Interface) super.clone();

      if (methods != null)
      {
        clone.methods = new ArrayList<>();

        for (InterfaceMethod method : methods)
        {
          method = method.clone();
          method.setMockInterfaceData(clone);

          clone.methods.add(method);
        }
      }

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  @Override
  public String toString()
  {
    return name == null ? super.toString() : name;
  }

  @Override
  public int hashCode()
  {
    if (interfaceId != null)
    {
      return interfaceId;
    }
    else if (!Utils.isEmpty(name))
    {
      return name.hashCode();
    }
    else
    {
      return super.hashCode();
    }
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof Interface == false)
    {
      return false;
    }

    if (this == obj)
    {
      return true;
    }

    Interface other = (Interface) obj;

    if (interfaceId != null && other.interfaceId != null)
    {
      return interfaceId.equals(other.interfaceId);
    }

    return Utils.isEqual(name, other.name);
  }
}

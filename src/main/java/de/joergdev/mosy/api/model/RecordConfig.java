package de.joergdev.mosy.api.model;

import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class RecordConfig extends AbstractModel implements Cloneable
{
  private Integer recordConfigId;
  private String title;

  private Interface mockInterface;
  private InterfaceMethod interfaceMethod;

  private String requestData;
  private Boolean enabled;

  public Integer getRecordConfigId()
  {
    return recordConfigId;
  }

  public void setRecordConfigId(Integer recordConfigId)
  {
    this.recordConfigId = recordConfigId;
  }

  public Interface getMockInterface()
  {
    return mockInterface;
  }

  public void setMockInterface(Interface mockInterface)
  {
    this.mockInterface = mockInterface;
  }

  public InterfaceMethod getInterfaceMethod()
  {
    return interfaceMethod;
  }

  public void setInterfaceMethod(InterfaceMethod interfaceMethod)
  {
    this.interfaceMethod = interfaceMethod;
  }

  public String getRequestData()
  {
    return requestData;
  }

  public void setRequestData(String requestData)
  {
    this.requestData = requestData;
  }

  public Boolean getEnabled()
  {
    return enabled;
  }

  public void setEnabled(Boolean enabled)
  {
    this.enabled = enabled;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public RecordConfig clone()
  {
    try
    {
      RecordConfig clone = (RecordConfig) super.clone();

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  public void formatRequest(Integer interfaceTypeId)
  {
    boolean isXmlInterface = InterfaceType.SOAP.id.equals(interfaceTypeId)
                             || InterfaceType.CUSTOM_XML.id.equals(interfaceTypeId);
    boolean isJsonInterface = InterfaceType.CUSTOM_JSON.equals(interfaceTypeId);

    if (isXmlInterface || (requestData != null && requestData.startsWith("<?xml")))
    {
      requestData = Utils.formatXml(requestData);
    }
    else if (isJsonInterface
             || (requestData != null && requestData.startsWith("{") && requestData.endsWith("}")))
    {
      requestData = Utils.formatJSON(requestData, true);
    }
  }
}
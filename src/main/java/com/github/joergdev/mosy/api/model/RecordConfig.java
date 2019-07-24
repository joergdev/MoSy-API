package com.github.joergdev.mosy.api.model;

import com.github.joergdev.mosy.api.model.core.AbstractModel;

public class RecordConfig extends AbstractModel
{
  private Integer recordConfigId;

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
}
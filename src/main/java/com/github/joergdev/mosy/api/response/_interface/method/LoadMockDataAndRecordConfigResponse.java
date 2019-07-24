package com.github.joergdev.mosy.api.response._interface.method;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.InterfaceMethod;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadMockDataAndRecordConfigResponse", propOrder = {"stateOK", "messages", "interfaceMethod"})
public class LoadMockDataAndRecordConfigResponse extends AbstractResponse
{
  @XmlElement(name = "interfaceMethod")
  private InterfaceMethod interfaceMethod;

  public InterfaceMethod getInterfaceMethod()
  {
    return interfaceMethod;
  }

  public void setInterfaceMethod(InterfaceMethod interfaceMethod)
  {
    this.interfaceMethod = interfaceMethod;
  }
}
package de.joergdev.mosy.api.response.mockservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.InterfaceMethod;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomRequestResponse", propOrder = {"stateOK", "messages", "record", "response", "route",
                                                      "interfaceMethod"})
public class CustomRequestResponse extends AbstractResponse
{
  private boolean record;
  private String response;
  private boolean route;
  private InterfaceMethod interfaceMethod;

  public boolean isRecord()
  {
    return record;
  }

  public void setRecord(boolean record)
  {
    this.record = record;
  }

  public String getResponse()
  {
    return response;
  }

  public void setResponse(String response)
  {
    this.response = response;
  }

  public boolean isRoute()
  {
    return route;
  }

  public void setRoute(boolean route)
  {
    this.route = route;
  }

  public InterfaceMethod getInterfaceMethod()
  {
    return interfaceMethod;
  }

  public void setInterfaceMethod(InterfaceMethod interfaceMethod)
  {
    this.interfaceMethod = interfaceMethod;
  }
}
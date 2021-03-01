package de.joergdev.mosy.api.request.mockservices;

public class CustomRequestRequest
{
  private String interfaceName;
  private String interfaceMethod;
  private String request;

  public String getInterfaceName()
  {
    return interfaceName;
  }

  public void setInterfaceName(String interfaceName)
  {
    this.interfaceName = interfaceName;
  }

  public String getInterfaceMethod()
  {
    return interfaceMethod;
  }

  public void setInterfaceMethod(String interfaceMethod)
  {
    this.interfaceMethod = interfaceMethod;
  }

  public String getRequest()
  {
    return request;
  }

  public void setRequest(String request)
  {
    this.request = request;
  }
}
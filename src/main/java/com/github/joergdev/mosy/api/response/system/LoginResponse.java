package com.github.joergdev.mosy.api.response.system;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginResponse", propOrder = {"stateOK", "messages", "token"})
public class LoginResponse extends AbstractResponse
{
  @XmlElement(name = "token")
  private String token;

  public String getToken()
  {
    return token;
  }

  public void setToken(String token)
  {
    this.token = token;
  }
}
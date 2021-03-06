package de.joergdev.mosy.api.response._interface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.Interface;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadResponse", propOrder = {"stateOK", "messages", "_interface"})
public class LoadResponse extends AbstractResponse
{
  @XmlElement(name = "interface")
  private Interface _interface;

  public Interface getInterface()
  {
    return _interface;
  }

  public void setInterface(Interface _interface)
  {
    this._interface = _interface;
  }
}